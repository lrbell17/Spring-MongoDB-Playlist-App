package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Song;
import com.repo.PlaylistRepository;

@Service
public class PlaylistDaoImpl implements PlaylistDao{

	@Autowired
	private PlaylistRepository playlistRepo;
	
	
	// add song to playlist
	@Override
	public void addSong(Song song) {
		playlistRepo.save(song);
	}

	// delete song by title
	@Override 
	public void deleteById(String id) {
		playlistRepo.deleteById(id);
	}

	// find all
	@Override
	public List<Song> getPlaylist(){
		return playlistRepo.findAll();
	}
	
	// delete all records
	@Override
	public void truncate() {
		playlistRepo.deleteAll();
	}
	
	
}
