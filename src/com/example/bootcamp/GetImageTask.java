package com.example.bootcamp;

import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;

import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.util.Log;

public class GetImageTask {
	
	private static GetImageTask instance;
	private HashMap<String, Drawable> cache;
	private static final String debug_tag = "getImageTask";
	private UpdatableActivity temp;
	
	public synchronized static GetImageTask getInstance() {
		if (instance == null) {
			instance = new GetImageTask();
		}
		return instance;
	}
	
	private GetImageTask() {
		cache = new HashMap<String, Drawable>();
	}
	
	public Drawable getImage(String url, UpdatableActivity adapter) {
		if (cache.containsKey(url))
			return cache.get(url);
		else {
			temp = adapter;
			new GetImage().execute(url);
			return null;
		}
	}
	
	private class GetImage extends AsyncTask<String, Integer, Drawable> {
	
		@Override
		protected Drawable doInBackground(String... url) {
			try {
				
				InputStream is = (InputStream) new URL(url[0]).getContent();
		        Drawable poster = Drawable.createFromStream(is, "src");
		        cache.put(url[0], poster);
		        return poster;
			} catch (Exception e) {
				Log.d(debug_tag, e.getMessage());
			}
			return null;
		}
	
		@Override
		protected void onPostExecute(Drawable result) {
			super.onPostExecute(result);
			temp.updateImage();
		}
	}
	
}