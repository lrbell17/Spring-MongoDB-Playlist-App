package com.dao;

import java.util.ArrayList;
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
	
	// remove song
	@Override
	public void removeSong(String id) {
		playlistRepo.deleteById(id);
	}
	
	// find song by title
	@Override
	public List<Song> findByTitle(String title) {
		return playlistRepo.findByTitle(title);
	}
	
	// delete song by title
	@Override 
	public void deleteByTitle(String title) {
		playlistRepo.deleteByTitle(title);
	}
	
	// filer by genre
	@Override
	public List<Song> filterByGenre(String genre){
		return playlistRepo.findByGenre(genre);
	}
	
	// filter by artist
	@Override 
	public List<Song> filterByArtist(String artist){
		
		List<Song> playlist = playlistRepo.findAll();
		List<Song> filtered = new ArrayList<Song>();
		
		for (Song song : playlist) {
			List<String> artists = song.getArtists();
			
			if (artists.contains(artist)) {
				filtered.add(song);
			}
		}
		
		return filtered;
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
