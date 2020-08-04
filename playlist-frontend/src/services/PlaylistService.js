import axios from 'axios';


const PLAYLIST_URL = 'http://localhost:8095/playlist';

const DELETE_URL = 'http://localhost:8095/playlist/delete/';

const SAVE_URL = 'http://localhost:8095/playlist/add/';

class PlaylistService {

    getPlaylist = () => {
        return axios.get(PLAYLIST_URL);
    }

    handleDelete = (id) => {
        return axios.get(DELETE_URL.concat(id));
    }

    handleSave = (title, artists, genre) => {
        return axios.get(SAVE_URL.concat(title).concat("/").concat(artists).concat("/").concat(genre));
    }
}

export default new PlaylistService();