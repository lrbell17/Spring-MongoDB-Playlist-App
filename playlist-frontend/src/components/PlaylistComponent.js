import React from 'react';
import PlaylistService from '../services/PlaylistService';
import SongBankService from '../services/SongBankService';
import SearchBar from './SearchBar';


class PlaylistComponent extends React.Component{

    constructor(props){
        super(props);
        this.genreList = []

        this.state = {
            songs: [],
            songList: [], 
            suggestions: [],
            text: '', // text to be rendered in search bar 
            criteria: 'title', // criteria to filter on search
            message: "" // error message
        }
    }

    componentDidMount = () => {

        // Getting total list of songs from backend
        SongBankService.getAllSongs().then((response) => {
            this.setState({songList: response.data})
        });
        // Getting songs in playlist from backend
        PlaylistService.getPlaylist().then((response) => {
            this.setState({songs: response.data})
        });

    }
    
    // ------------------------ Playlist ------------------------------------------------//

    // Deleting a song from the playlist
    handleClickDelete = (id) => {
        // delete item & update list
        PlaylistService.handleDelete(id).then((response)=> {
            this.setState({songs: response.data})
        });
    }

    handleClickPlay = (title) => {
        this.setState({message: "Play feauture is coming soon, sorry for the inconvenience!"});
    }

    handleSave = (title, artists, genre) => {

        PlaylistService.handleSave(title, artists, genre).then((response) => {
            this.setState({songs: response.data})
        });

    }

    getGenres = () => {
        const songList = this.state.songList;
        let genreList = [];
        for (let i = 0; i < songList.length; i++){

            if (!genreList.includes(songList[i].genre)) {

                genreList.push(songList[i].genre);
            }
        }
        return genreList;
    }

    getArtists = () => {
        const songList = this.state.songList;
        let artistList = [];
        for (let i = 0; i < songList.length; i++){

            let artists = songList[i].artists; // list of artists for each record

            for (let j = 0; j < artists.length; j++){

                if (!artistList.includes(artists[j])) {

                    artistList.push(artists[j]);
                }
            }
        }
        return artistList;
    }
    // ------------------------------- Search Bar -----------------------------------------------//

    onTextChange = (e) => {
        const value = e.target.value;
        let suggestions = [];

        if(value.length > 0){
            let songList = this.state.songList;

            /*checking for matching substring in songList (by title) */
            for (let i=0; i< songList.length; i++ ){

                if (songList[i].title.substr(0, value.length).toLowerCase() === value.toLowerCase()){
                    suggestions.push(songList[i]);
                }

            }

        }

        this.setState(() => ({
            suggestions,
            text: value
        }))
    }

    selectedText = (value) => {

        this.handleSave(value.title, value.artists, value.genre);
        this.setState(() => ({
            text: value.title, //.concat(" - ").concat(value.artists),
            suggestions: []
        }));

    }

    renderSuggestions = () => {
        let { suggestions } = this.state;
        if(suggestions.length === 0){
            return null;
        }
        return (
            <ul >
                {
                    suggestions.map((song, index) => (
                        <li key={index} onClick={() => this.selectedText(song)}>
                             {song.title} - {song.artists} ({song.genre})
                        </li>))
                }
            </ul>
        );
    }

    filterByGenre = (genre) => {
        SongBankService.handleGenre(genre).then((response) => {
            this.setState({suggestions: response.data})
        });
        this.renderSuggestions();
    }
    
    filterByArtist = (artist) => {
        SongBankService.handleArtist(artist).then((response) => {
            this.setState({suggestions: response.data})
        });
        this.renderSuggestions();
        console.log("Suggestions:".concat(this.state.suggestions));
    }

    render() {

        const errorStyle = {
            color: 'red'
        }
        
        const genreList = this.getGenres();
        const artistList = this.getArtists();

        return(
            <div>
            {/* <h1 id="notebooks" className="text-center">Playlist</h1> */}

            <SearchBar
                    suggestions={this.state.suggestions}
                    text={this.state.text}
                    genres = {genreList}
                    artists = {artistList}
                    onTextChange={this.onTextChange}
                    renderSuggestions={this.renderSuggestions}
                    filterByGenre={this.filterByGenre}
                    filterByArtist={this.filterByArtist}
            />

            <h1 id="notebooks-alt" className="text-center">Playlist</h1>
            <p style={errorStyle}>{this.state.message}</p>
            <table className = "table table-striped table-dark"> 
                <thead>
                    <tr>
                        <td> <strong>Title</strong> </td>
                        <td><strong>Artists</strong></td>
                        <td><strong>Genre</strong></td>
                        <td><strong>Date Added</strong></td>
                        <td></td>
                        <td></td>
                    </tr>
                </thead>
                <tbody>
                    {this.state.songs.map(
                        song =>
                        <tr key={song.songId}>
                            <td>{song.title}</td>
                            <td>{song.artists}</td>
                            <td>{song.genre}</td>
                            <td>{song.dateAdded}</td>
                            <td>
                                <button className="btn btn-success"
                                onClick={() => this.handleClickPlay(song.title)} >
                                    <i className="fa fa-play-circle"/></button>

                            </td>
                            
                            
                            <td>
                                <button
                                    className="btn btn-danger"
                                    onClick={() => this.handleClickDelete(song.songId)}> 
                                        <i className="fa fa-trash-o" aria-hidden="true" />
                                </button>
                            </td>
                        </tr>
                    )}
                </tbody>
            </table>

            </div>
        )
    }
}

export default PlaylistComponent