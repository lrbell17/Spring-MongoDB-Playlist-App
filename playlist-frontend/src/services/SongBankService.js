import axios from 'axios';


const FINDALL_URL = 'http://localhost:8085/songs';

const FIND_BY_TITLE_URL = 'http://localhost:8085/songs/title/';

const FILTER_GENRE_URL = 'http://localhost:8085/songs/genre/';

const FILTER_ARTIST_URL = 'http://localhost:8085/songs/artist/';

class SongBankService {

    getAllSongs = () => {
        return axios.get(FINDALL_URL);
    }

    findByTitle = (title) => {
        return axios.get(FIND_BY_TITLE_URL.concat(title))
    }

    handleGenre = (genre) => {
        return axios.get(FILTER_GENRE_URL.concat(genre));
    }

    handleArtist = (artist) => {
        return axios.get(FILTER_GENRE_URL.concat(artist));
    }
}

export default new SongBankService();