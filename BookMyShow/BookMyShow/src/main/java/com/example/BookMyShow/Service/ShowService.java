package com.example.BookMyShow.Service;

import com.example.BookMyShow.Enums.SeatType;
import com.example.BookMyShow.Models.*;
import com.example.BookMyShow.Repository.MovieRepository;
import com.example.BookMyShow.Repository.ShowRepository;
import com.example.BookMyShow.Repository.TheaterRepository;
import com.example.BookMyShow.RequestDtos.AddShowRequest;
import com.example.BookMyShow.RequestDtos.AddShowSeatRequest;
import com.example.BookMyShow.Transformers.ShowTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class ShowService {
    @Autowired
    private ShowRepository showRepository;
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private TheaterRepository theaterRepository;

    public String addShow(AddShowRequest addShowRequest) {
        Show show = ShowTransformer.createAddRequestToEntity(addShowRequest);
        Movie movie = movieRepository.findMovieByMovieName(addShowRequest.getMovieName());
        Optional<Theater> optionalTheater = theaterRepository.findById(addShowRequest.getTheaterId());
        Theater theater = optionalTheater.get();
        show.setMovie(movie);
        show.setTheater(theater);
        return "Show is added to database "+ show.getShowId();
    }

    public String createShowSeats(AddShowSeatRequest addShowSeatRequest) {
        //I need to create the show Seats and save to the DB.
        Show show = showRepository.findById(addShowSeatRequest.getShowId()).get();
        Theater theater = show.getTheater();
        List<TheaterSeat> theaterSeatList = theater.getTheaterSeatList();
        List<ShowSeat> showSeatList = new ArrayList<>();
        for(TheaterSeat theaterSeat:theaterSeatList){
            ShowSeat showSeat = ShowSeat.builder()
                    .seatNo(theaterSeat.getSeatNo())
                    .seatType(theaterSeat.getSeatType())
                    .isAvailable(true)
                    .isFoodAttach(false)
                    .build();
            if(theaterSeat.getSeatType().equals(SeatType.PREMIUM)){
                showSeat.setFoodAttach(true);
                showSeat.setPrice(addShowSeatRequest.getPriceOfPremiumSeats());
            }else{
                showSeat.setPrice(addShowSeatRequest.getPriceOfClassicSeats());
            }
            showSeatList.add(showSeat);
        }
        show.setShowSeatList(showSeatList);
        showRepository.save(show);
        return "ShowSeat is created";
    }
}
