package com.example.bootcamp;

import java.io.Serializable;

public class ListData implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4363074930476902927L;
	private int year;
	private String title;
	private String url;
	private String id;
	private int rating;
	private int runtime;
	public final static String NAME = "com.example.Bootcamp.ListData";
	
	public ListData(String id, int year, String title, String url, int rating, int runtime) {
		this.id = id;
		this.year = year;
		this.title = title;
		this.url = url;
		this.rating = rating;
		this.runtime = runtime;
	}
	
	public int getYear() {
		return year;
	}

	public String getTitle() {
		return title;
	}

	public String getUrl() {
		return url;
	}

	public String getId() {
		return id;
	}

	public int getRating() {
		return rating;
	}

	public int getRuntime() {
		return runtime;
	}

	@Override
	public boolean equals(Object o) {
		ListData other = (ListData) o;
		return other.getYear() == year && other.getTitle().equals(title) && other.getUrl().equals(url) && other.getId().equals(id) && other.getRating() == rating && other.getRuntime() == runtime; 
	}
	

}
