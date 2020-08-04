package com.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dao.PlaylistDao;
import com.model.Song;

@CrossOrigin(origins = "http://localhost:3000") // allow access from port 3000
@RestController
@RequestMapping("/playlist")
public class PlaylistController {

	@Autowired
	private PlaylistDao playlistDao;
	
	@GetMapping("")
	public List<Song> getPlaylist(){
		return playlistDao.getPlaylist();
	}
	
	
	@GetMapping("/delete/{id}")
	public List<Song> delete(@PathVariable String id){
		playlistDao.deleteById(id);
		return playlistDao.getPlaylist();
	}
	
	@GetMapping("/add/{title}/{artists}/{genre}")
	public List<Song> addSong(@PathVariable String title, @PathVariable String artists, @PathVariable String genre){
		
		List<String> artistList = Arrays.asList(artists.split("-"));

		playlistDao.addSong(new Song(title, artistList, genre));
		return playlistDao.getPlaylist();
	}
	
}
