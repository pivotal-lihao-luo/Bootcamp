package com.example.bootcamp;

import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.json.JSONArray;
import org.json.JSONObject;

import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;

public class SearchTask {

	MainActivity display;
	
	private static final String API_KEY = "6rzu8wc83rwn96h5hkndep27";
	private static final int page_limit = 6;
	
	public SearchTask(MainActivity activity) {
		this.display = activity;
	}
	
	private String generateURL(String query, int pageNum) {
		query = Uri.encode(query);
		return "http://api.rottentomatoes.com/api/public/v1.0/movies.json?apikey=" + API_KEY + "&q=" + query + "&page_limit=" + page_limit + "&page=" + pageNum;
	}
	
	public void execute(String query, int pageNum) {
		String url = generateURL(query, pageNum);
		new Search().execute(url);
	}
	
	
	private class Search extends AsyncTask<String, Integer, ArrayList<ListData> >{
		private static final String debug_tag = "Search query";
		@Override
		protected ArrayList<ListData> doInBackground(String... arg0) {
			String url = arg0[0];
			ArrayList<ListData> newList = new ArrayList<ListData>();
			try {
				HttpEntity entity = HelperClass.getEntityFromURL(url);
				if (entity != null) {
					JSONObject result = HelperClass.getJSONFromEntity(entity);
					JSONArray movies = result.getJSONArray("movies");
					
					//add the movies to the list
					for (int i = 0; i < movies.length(); i++) {
						try {
							JSONObject movie = movies.getJSONObject(i);
							String id = movie.getString("id");
							String title = movie.getString("title");
							int year = movie.getInt("year");
							int rating = movie.getJSONObject("ratings").getInt("critics_score");
							String posterURL = movie.getJSONObject("posters").getString("thumbnail");
							int runtime = movie.getInt("runtime");
							newList.add(new ListData(id, year, title, posterURL, rating, runtime));							
						} catch (Exception e) {
							Log.d(debug_tag, "Error parsing movie " + i);
						}
					}
					
				} else {
					throw new Exception("Error accessing server");
				}
				
				
			} catch (Exception e) {
				Log.d(debug_tag, e.getMessage());
			}
			return newList;
		}
		
		protected void onPostExecute(ArrayList<ListData> list) {
			super.onPostExecute(list);
			display.setList(list);
		}
	}
	

}