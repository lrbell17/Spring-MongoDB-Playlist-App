package com.springmongoconnector;

import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.dao.PlaylistDao;
import com.model.Song;

@SpringBootApplication
@ComponentScan(basePackages = "com")
@EnableMongoRepositories(basePackages = "com.repo")
public class SpringMongoConnectorApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringMongoConnectorApplication.class, args);
	}

	@Autowired
	private PlaylistDao playlistDao;
	
	@Override
	public void run(String... args) throws Exception {
		
		// delete existing records
		playlistDao.truncate();

		
		// initializing some values
		Song s1 = new Song("Sunshine", Arrays.asList("Atmosphere"), "Rap");
		Song s2 = new Song("Jungle Boogie", Arrays.asList("Kool & The Gang"), "Funk");
		Song s3 = new Song("Baby Blue", Arrays.asList("Action Bronson", "Chance the Rapper"), "Rap");
		Song s4 = new Song("Sweet Emotion", Arrays.asList("Aerosmith"), "Rock");
		Song s5 = new Song("Big Iron", Arrays.asList("Marty Robbins"), "Country");
		Song s6 = new Song("Wanted Dead or Alive", Arrays.asList("Peter Tosh"), "Reggae");
		
		playlistDao.addSong(s1);
		playlistDao.addSong(s2);
		playlistDao.addSong(s3);
		playlistDao.addSong(s4);
		playlistDao.addSong(s5);
		playlistDao.addSong(s6);


	}

}
