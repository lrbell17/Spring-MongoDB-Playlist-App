package com.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.model.Song;

@Repository
public interface PlaylistRepository extends MongoRepository<Song, String>{

}
