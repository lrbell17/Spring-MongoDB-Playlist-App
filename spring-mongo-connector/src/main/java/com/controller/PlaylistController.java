package com.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dao.PlaylistDao;
import com.model.Song;

@RestController
@RequestMapping("/playlist")
public class PlaylistController {

	@Autowired
	private PlaylistDao playlistDao;
	
	@GetMapping("")
	public List<Song> getPlaylist(){
		return playlistDao.getPlaylist();
	}
	
	@GetMapping("/title/{title}")
	public List<Song> findBytitle(@PathVariable String title) {
		return playlistDao.findByTitle(title);
	}
	
	@GetMapping("/genre/{genre}")
	public List<Song> filterByGenre(@PathVariable String genre){
		return playlistDao.filterByGenre(genre);
	}
	
	@GetMapping("/artist/{artist}")
	public List<Song> filterByArtist(@PathVariable String artist){
		return playlistDao.filterByArtist(artist);
	}
	
	@GetMapping("/delete/{title}")
	public List<Song> delete(@PathVariable String title){
		playlistDao.deleteByTitle(title);
		return playlistDao.getPlaylist();
	}
	
	@GetMapping("/add/{title}/{artists}/{genre}")
	public List<Song> addSong(@PathVariable String title, @PathVariable String artists, @PathVariable String genre){
		
		List<String> artistList = Arrays.asList(artists.split("-"));

		playlistDao.addSong(new Song(title, artistList, genre));
		return playlistDao.getPlaylist();
	}
	
}
