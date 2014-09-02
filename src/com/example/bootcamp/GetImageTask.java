package com.example.bootcamp;

import java.util.HashMap;

import android.graphics.drawable.Drawable;
import android.os.AsyncTask;

public class GetImageTask {
	
	private static GetImageTask instance;
	private HashMap<String, Drawable> cache;
	
	public synchronized static GetImageTask getInstance() {
		if (instance == null) {
			instance = new GetImageTask();
		}
		return instance;
	}
	
	private GetImageTask() {
		cache = new HashMap<String, Drawable>();
	}
	
	public Drawable getImage(String url) {
		if (cache.containsKey(url))
			return cache.get(url);
		else {
			new GetImage().execute(url);
			return null;
		}
	}
	
	private class GetImage extends AsyncTask<String, Integer, Drawable> {
	
		@Override
		protected Drawable doInBackground(String... url) {
			try {
				
				Drawable.createFromStream(is, "src");
			} catch (Exception e) {
				
			}
			return null;
		}
	
	}
}