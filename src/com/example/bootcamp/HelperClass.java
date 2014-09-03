package com.example.bootcamp;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;

public class HelperClass {
	public static JSONObject getJSONFromEntity(HttpEntity entity) throws Exception {
		InputStream is = entity.getContent();
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		StringBuilder builder = new StringBuilder();
		String line = null;
		while ((line = reader.readLine()) != null) {
			builder.append(line + "\n");
		}
		
		JSONObject result = new JSONObject(builder.toString());
		return result;
	}
	
	public static HttpEntity getEntityFromURL(String url) throws Exception {
		HttpClient client = new DefaultHttpClient();
		HttpGet request = new HttpGet(url);
		
		//gets json string from response
		HttpResponse response = client.execute(request);
		HttpEntity entity = response.getEntity();
		return entity;
	}
}
