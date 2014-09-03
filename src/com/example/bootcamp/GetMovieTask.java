package com.example.bootcamp;

import org.apache.http.HttpEntity;
import org.json.JSONArray;
import org.json.JSONObject;

import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;

public class GetMovieTask {

	private Profile activity;
	private static final String API_KEY = "6rzu8wc83rwn96h5hkndep27";

	private String generateURL(String id) {
		id = Uri.encode(id);
		return "http://api.rottentomatoes.com/api/public/v1.0/movies/" + id
				+ ".json?apikey=" + API_KEY;
	}

	public GetMovieTask(Profile activity) {
		this.activity = activity;
	}

	public void execute(String id) {
		String url = generateURL(id);
		new GetById().execute(url);
	}

	private class GetById extends AsyncTask<String, Integer, MovieData> {
		private static final String debug_tag = "Search id";

		@Override
		protected MovieData doInBackground(String... arg0) {
			String url = arg0[0];
			try {
				HttpEntity entity = HelperClass.getEntityFromURL(url);
				if (entity != null) {
					JSONObject result = HelperClass.getJSONFromEntity(entity);
					JSONArray genres = result.getJSONArray("genres");

					StringBuilder builder = new StringBuilder();
					for (int i = 0; i < genres.length() - 1; i++) {
						builder.append(genres.get(i));
						builder.append(", ");
					}
					builder.append(genres.getString(genres.length() - 1));
					String genres_string = builder.toString();
					builder.delete(0, builder.length());
					String directors_string;
					try {
						JSONArray director = result
								.getJSONArray("abridged_directors");
						builder = new StringBuilder();
						for (int i = 0; i < director.length() - 1; i++) {
							builder.append(director.getJSONObject(i).getString(
									"name"));
							builder.append(", ");
						}
						builder.append(director.getJSONObject(
								(director.length() - 1)).getString("name"));
						directors_string = builder.toString();
					} catch (Exception e) {
						directors_string = "";

					}
					String synopsis = result.getString("synopsis");
					String date = result.getJSONObject("release_dates")
							.getString("theater");
					String posterURL = result.getJSONObject("posters")
							.getString("original");
					posterURL = posterURL.replace("tmb.jpg", "det.jpg");

					boolean tomato = false;

					try {
						tomato = result.getJSONObject("ratings")
								.getString("critics_rating")
								.equals("Certified Fresh");
					} catch (Exception e) {
						Log.d(debug_tag, e.getMessage());
					}

					return new MovieData(directors_string, genres_string,
							synopsis, date, posterURL, tomato);
				}
			} catch (Exception e) {
				Log.d(debug_tag, e.getMessage());
			}
			return null;
		}

		@Override
		protected void onPostExecute(MovieData result) {
			super.onPostExecute(result);
			activity.setMovie(result);
		}

	}
}
