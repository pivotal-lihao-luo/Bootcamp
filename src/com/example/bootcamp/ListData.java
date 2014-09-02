package com.example.bootcamp;

public class ListData {
	private int year;
	private String title;
	private String url;
	private String id;
	private int rating;
	private int runtime;
	
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
}
