package com.dao;

import java.util.List;

import com.model.Song;

public interface SongBankDao {

	void addSong(Song song);

	List<Song> findByTitle(String title);

	List<Song> filterByGenre(String genre);

	List<Song> filterByArtist(String artist);

	List<Song> getAllSongs();

	void truncate();





}
