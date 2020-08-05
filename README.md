# Spring-MongoDB-Playlist-App

A Spring Boot/React application for accessing and manipulating song data in a personal playlist from your local MongoDB instance with a React.js user interface.  
  
**Back-end:**
* **spring-mongo-connector:** Spring Boot REST application containing methods for managing a personal playlist by adding songs from the song bank or removing them
* **spring-mongo-connector-songbank:** Spring Boot REST application containing methods for retrieving and manipulating songs in the song bank, with options to filter songs based on the genre or artist

**Front-End:**
* **playlist-frontend:** React.js application that communicates with the backend services to display data and provide a UI
  - displays all songs in the playlist, with buttons to delete or play (not implemented)
  - auto-completed search bar for adding new songs to the playlist by title
  - dropdown menu options to filter search suggestions by artist or genre

**Dependencies:** cd to the "shopping-frontend" folder in cmd and run these commands
* **Bootstrap:** "npm install bootstrap --save"
* **Axios:** "npm add axios"
* **Font-Awesome:** "npm install --save font-awesome"  

**To Run:**
* **Back-end:** run "SpringMongoConnectorApplication.java" and "SpringMongoConnectorSongbankApplication.java" as Java Applications
* **Front-end:** cd to "playlist-frontend" folder in cmd and run "npm start"
