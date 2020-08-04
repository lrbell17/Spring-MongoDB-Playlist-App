import React from 'react';
import '../App.css';
import NavBar from './NavBar';


const SearchBar = props => {
    
        return(

            
            <div id="notebooks">
                <h2>Search for new Songs</h2>
               
                <NavBar genres={props.genres} artists={props.artists} filterByGenre={props.filterByGenre} 
                filterByArtist={props.filterByArtist}/>
                    
                <input id="query" type="text" onChange={props.onTextChange} value={props.text} />
                {props.renderSuggestions()}
                <span>Suggestions: {props.suggestions.length}</span>

            </div>
        );
    

}

export default SearchBar;