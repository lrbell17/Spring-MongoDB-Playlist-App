package com.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.model.Song;

@Repository
public interface SongBankRepository extends MongoRepository<Song, String>{

	public List<Song> findByTitle(String title);
	
	public List<Song> findByGenre(String genre);

}
