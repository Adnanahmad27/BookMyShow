package com.example.BookMyShow.Transformers;


import com.example.BookMyShow.Models.Movie;
import com.example.BookMyShow.RequestDtos.AddMovieRequest;

public class MovieTransformer {
    public static Movie createAddMovieReqToMovie(AddMovieRequest addMovieRequest){
        Movie movie = Movie.builder()
                .name(addMovieRequest.getName())
                .genre(addMovieRequest.getGenre())
                .releaseDate(addMovieRequest.getReleaseDate())
                .rating(addMovieRequest.getRating())
                .build();
        return movie;
    }
}
