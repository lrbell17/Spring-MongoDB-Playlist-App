package com.springmongoconnector;

import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.dao.SongBankDao;
import com.model.Song;

@SpringBootApplication
@ComponentScan(basePackages = "com")
@EnableMongoRepositories(basePackages = "com.repo")
public class SpringMongoConnectorSongbankApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringMongoConnectorSongbankApplication.class, args);
	}

	@Autowired
	private SongBankDao songBankDao;
	
	@Override
	public void run(String... args) throws Exception {
		
		// delete existing records
		songBankDao.truncate();

		
		// initializing some values & adding to DB
		Song s1 = new Song("Sunshine", Arrays.asList("Atmosphere"), "Rap");
		Song s2 = new Song("Jungle Boogie", Arrays.asList("Kool & The Gang"), "Funk");
		Song s3 = new Song("Baby Blue", Arrays.asList("Action Bronson", "Chance the Rapper"), "Rap");
		Song s4 = new Song("Sweet Emotion", Arrays.asList("Aerosmith"), "Rock");
		Song s5 = new Song("Big Iron", Arrays.asList("Marty Robbins"), "Country");
		Song s6 = new Song("Wanted Dead or Alive", Arrays.asList("Peter Tosh"), "Reggae");
		Song s7 = new Song("Little Wing", Arrays.asList("Jimi Hendrix"), "Rock");
		Song s8 = new Song("Express Yourself", Arrays.asList("N.W.A."), "Rap");
		Song s9 = new Song("Saw Red", Arrays.asList("Sublime", "Gwen Stefani"), "Reggae");
		Song s10 = new Song("Black Irish", Arrays.asList("The Devil Makes Three"), "Bluegrass");
		Song s11 = new Song("Nothing From Nothing", Arrays.asList("Billy Preston"), "Funk");
		Song s12 = new Song("Everything I Am", Arrays.asList("Kanye West", "DJ Premier"), "Rap");
		Song s13 = new Song("Santeria", Arrays.asList("Sublime"), "Reggae");
		Song s14 = new Song("Jars at Home", Arrays.asList("Trampled by Turtles"), "Bluegrass");
		Song s15 = new Song("Space Oddity", Arrays.asList("David Bowie"), "Rock");
		Song s16 = new Song("Still D.R.E", Arrays.asList("Dr. Dre", "Snoop Dogg"), "Rap");
		Song s17 = new Song("Flowers on the Wall", Arrays.asList("The Staler Brothers"), "Country");
		Song s18 = new Song("Down by the Seaside", Arrays.asList("Led Zeppelin"), "Rock");
		Song s19 = new Song("Valerie", Arrays.asList("Amy Winehouse"), "Jazz");
		Song s20 = new Song("Sleeping on the Blacktop", Arrays.asList("Colter Walter"), "Folk");
		Song s21 = new Song("Freddie's Dead", Arrays.asList("Curtis Mayfield"), "Funk");
		Song s22 = new Song("Like a Rolling Stone", Arrays.asList("Bob Dylan"), "Folk");
		Song s23 = new Song("My Good Gal", Arrays.asList("Old Crow Medicine Show"), "Bluegrass");
		Song s24 = new Song("Wheels", Arrays.asList("Cake"), "Rock");
		
		songBankDao.addSong(s1);
		songBankDao.addSong(s2);
		songBankDao.addSong(s3);
		songBankDao.addSong(s4);
		songBankDao.addSong(s5);
		songBankDao.addSong(s6);
		songBankDao.addSong(s7);
		songBankDao.addSong(s8);
		songBankDao.addSong(s9);
		songBankDao.addSong(s10);
		songBankDao.addSong(s11);
		songBankDao.addSong(s12);
		songBankDao.addSong(s13);
		songBankDao.addSong(s14);
		songBankDao.addSong(s15);
		songBankDao.addSong(s16);
		songBankDao.addSong(s17);
		songBankDao.addSong(s18);
		songBankDao.addSong(s19);
		songBankDao.addSong(s20);
		songBankDao.addSong(s21);
		songBankDao.addSong(s22);
		songBankDao.addSong(s23);
		songBankDao.addSong(s24);

	}

}
