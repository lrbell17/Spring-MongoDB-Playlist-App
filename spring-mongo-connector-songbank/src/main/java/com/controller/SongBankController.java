package com.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dao.SongBankDao;
import com.model.Song;

@CrossOrigin(origins = "http://localhost:3000") // allow access from port 3000
@RestController
@RequestMapping("/songs")
public class SongBankController {

	@Autowired
	private SongBankDao songBankDao;
	
	@GetMapping("")
	public List<Song> getAllSongs(){
		return songBankDao.getAllSongs();
	}
	
	@GetMapping("/title/{title}")
	public List<Song> findBytitle(@PathVariable String title) {
		return songBankDao.findByTitle(title);
	}
	
	@GetMapping("/genre/{genre}")
	public List<Song> filterByGenre(@PathVariable String genre){
		return songBankDao.filterByGenre(genre);
	}
	
	@GetMapping("/artist/{artist}")
	public List<Song> filterByArtist(@PathVariable String artist){
		return songBankDao.filterByArtist(artist);
	}
	
//
//	@GetMapping("/add/{title}/{artists}/{genre}")
//	public List<Song> addSong(@PathVariable String title, @PathVariable String artists, @PathVariable String genre){
//		
//		List<String> artistList = Arrays.asList(artists.split("-"));
//
//		songBankDao.addSong(new Song(title, artistList, genre));
//		return songBankDao.getPlaylist();
//	}
	
}
