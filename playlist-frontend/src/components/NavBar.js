import React from 'react';
import '../App.css';

const NavBar = props => {

    return (
        <div className="navbar">
            <div className="dropdown">
                <button className="dropbtn">Filter by Genre  
                <i className="fa fa-caret-down"></i>
                </button>
                <div className="dropdown-content">
                    {

                            props.genres.sort().map((genre, index) => (
                                <button className="dropdown-item" type="button" key={index} 
                                    onClick={() => props.filterByGenre(genre)} >
                                    {genre} 
                                </button>))
                            
                    }
                </div>
            </div>

            <div className="navDesc"> Search by Artist/Title </div>
            <div className="dropdown">
                    <button className="dropbtn">Filter by Artist
                    <i className="fa fa-caret-down"></i>
                    </button>

                    <div className="dropdown-content">
                        {

                                props.artists.sort().map((artist, index) => (
                                    <button className="dropdown-item" type="button" key={index} 
                                        onClick={() => props.filterByArtist(artist)} >
                                        {artist} 
                                    </button>))
                                
                        }
                    </div>
            </div>
    
        </div>


    )



}
export default NavBar;