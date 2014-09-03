package com.example.bootcamp;

public class MovieData {

	private String director;
	private String genre;
	private String synopsis;
	private String date;
	private String url;
	private boolean tomato;
	
	public MovieData(String d, String g, String s, String date, String url, boolean tomato) {
		this.director = d;
		this.genre = g;
		this.synopsis = s;
		this.date = date;
		this.url = url;
		this.tomato = tomato;
	}

	public String getUrl() {
		return url;
	}
	
	public boolean getTomato() {
		return tomato;
	}

	public String getDirector() {
		return director;
	}

	public String getGenre() {
		return genre;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public String getDate() {
		return date;
	}
	
	
}
