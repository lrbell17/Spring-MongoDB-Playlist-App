package com.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Song;
import com.repo.SongBankRepository;

@Service
public class SongBankDaoImpl implements SongBankDao{

	@Autowired
	private SongBankRepository songBankRepo;
	
	
	// add song 
	@Override
	public void addSong(Song song) {
		songBankRepo.save(song);
	}

	// find song by title
	@Override
	public List<Song> findByTitle(String title) {
		return songBankRepo.findByTitle(title);
	}

	// filter by genre
	@Override
	public List<Song> filterByGenre(String genre){
		return songBankRepo.findByGenre(genre);
	}
	
	// filter by artist
	@Override 
	public List<Song> filterByArtist(String artist){
		
		List<Song> playlist = songBankRepo.findAll();
		List<Song> filtered = new ArrayList<Song>();
		
		for (Song song : playlist) {
			List<String> artists = song.getArtists();
			
			if (artists.contains(artist)) {
				filtered.add(song);
			}
		}
		
		System.out.println(filtered);
		return filtered;
	}
	
	
	// find all
	@Override
	public List<Song> getAllSongs(){
		return songBankRepo.findAll();
	}
	
	// delete all records
	@Override
	public void truncate() {
		songBankRepo.deleteAll();
	}
	
	
}
