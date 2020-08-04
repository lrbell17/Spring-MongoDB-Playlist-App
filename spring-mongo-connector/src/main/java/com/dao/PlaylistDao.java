package com.dao;

import java.util.List;

import com.model.Song;

public interface PlaylistDao {

	List<Song> getPlaylist();

	void addSong(Song song);

	void deleteById(String id);

	void truncate();


}
