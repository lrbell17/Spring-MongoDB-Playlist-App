package com.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "songbank")
public class Song {

	@Id
	private String songId;
	private String title;
	private List<String> artists;
	private String genre;
	
	// default constructor
	public Song() {
	}

	// constructor
	public Song(String title, List<String> artists, String genre) {
		super();
		this.title = title;
		this.artists = artists;
		this.genre = genre;
	}

	// Getters and Setters
	public String getSongId() {
		return songId;
	}

	public void setSongId(String songId) {
		this.songId = songId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<String> getArtists() {
		return artists;
	}

	public void setArtists(List<String> artists) {
		this.artists = artists;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}



}
