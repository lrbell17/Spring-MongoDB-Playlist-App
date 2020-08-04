import React from 'react';
import PlaylistService from '../services/PlaylistService';
import SongBankService from '../services/SongBankService';
import SearchBar from './SearchBar';


class PlaylistComponent extends React.Component{

    constructor(props){
        super(props);
        this.state = {
            songs: [],
            songList: [], 
            suggestions: [],
            text: '', // text to be rendered in search bar 
            criteria: 'title', // criteria to filter on search
            artists:[], 
            genres:[],
            message: "" // error message
        }
    }

    componentDidMount = () => {

        // Getting songs in playlist from backend
        PlaylistService.getPlaylist().then((response) => {
            this.setState({songs: response.data})
        });

        // Getting total list of songs from backend
        SongBankService.getAllSongs().then((response) => {
            this.setState({songList: response.data})
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
       

    render() {

        const errorStyle = {
            color: 'red'
        }

        return(
            <div>
            <h1 className="text-center">Playlist</h1>

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
                                    <i class="fa fa-play-circle"/></button>

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
            <SearchBar
                    suggestions={this.state.suggestions}
                    text={this.state.text}
                    onTextChange={this.onTextChange}
                    renderSuggestions={this.renderSuggestions}
            />
            </div>
        )
    }
}

export default PlaylistComponent