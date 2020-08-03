import React from 'react';
import PlaylistService from '../services/PlaylistService';


class PlaylistComponent extends React.Component{

    constructor(props){
        super(props);
        this.state = {
            songs: [],
            message: ""
        }
    }

    componentDidMount = () => {

        // Getting songs in playlist from backend
        PlaylistService.getPlaylist().then((response) => {
            this.setState({songs: response.data})
        });
    }

    handleClickDelete(title){
        // delete item & update list
        PlaylistService.handleDelete(title).then((response)=> {
            this.setState({songs: response.data})
        });
    }

    handleClickPlay(title){
        this.setState({message: "Play feauture is coming soon, sorry for the inconvenience!"});
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
                                    onClick={() => this.handleClickDelete(song.title)}> 
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