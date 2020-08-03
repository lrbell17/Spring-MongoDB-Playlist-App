import axios from 'axios';


const PLAYLIST_URL = 'http://localhost:8095/playlist';

const DELETE_URL = 'http://localhost:8095/playlist/delete/';

class PlaylistService {

    getPlaylist = () => {
        return axios.get(PLAYLIST_URL);
    }

    handleDelete = (title) => {
        return axios.get(DELETE_URL.concat(title));
    }
}

export default new PlaylistService();