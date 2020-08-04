import React from 'react';
import '../App.css';

const NavBar = props => {

    return (
        <div class="navbar">
            <div class="dropdown">
                <button class="dropbtn">Filter by Genre  
                <i class="fa fa-caret-down"></i>
                </button>
                <div class="dropdown-content">
                    {

                            props.genres.sort().map((genre, index) => (
                                <button className="dropdown-item" type="button" key={index} 
                                    onClick={() => props.filterByGenre(genre)} >
                                    {genre} 
                                </button>))
                            
                    }
                </div>
            </div>

            <div class="navDesc"> Search by Title </div>
            <div class="dropdown">
                    <button class="dropbtn">Filter by Artist
                    <i class="fa fa-caret-down"></i>
                    </button>

                    <div class="dropdown-content">
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