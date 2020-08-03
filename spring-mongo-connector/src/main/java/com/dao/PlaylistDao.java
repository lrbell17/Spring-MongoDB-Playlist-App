package com.dao;

import java.util.List;

import com.model.Song;

public interface PlaylistDao {

	List<Song> getPlaylist();

	void addSong(Song song);

	void removeSong(String id);

	List<Song> findByTitle(String title);

	List<Song> filterByGenre(String genre);
	
	List<Song> filterByArtist(String artist);
	
	void deleteByTitle(String title);

	void truncate();


}
