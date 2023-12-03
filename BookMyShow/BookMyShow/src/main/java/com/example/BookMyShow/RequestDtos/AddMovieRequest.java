package com.example.BookMyShow.RequestDtos;

import com.example.BookMyShow.Enums.Genre;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddMovieRequest {
    private String name;
    private Double rating;
    private Genre genre;
    private LocalDate releaseDate;
}
