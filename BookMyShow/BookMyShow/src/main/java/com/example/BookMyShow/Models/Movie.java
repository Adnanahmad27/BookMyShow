package com.example.BookMyShow.Models;

import com.example.BookMyShow.Enums.Genre;
import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "movie")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer movieId;
    @Column(unique = true)
    private String movieName;
    private Double rating;
    @Enumerated(value = EnumType.STRING)
    private Genre genre;
    private LocalDate releaseDate;
    @OneToMany(mappedBy = "movie" , cascade = CascadeType.ALL)
    private List<Show> showList = new ArrayList<>();
}
