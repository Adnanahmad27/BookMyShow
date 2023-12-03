package com.example.BookMyShow.Service;

import com.example.BookMyShow.Models.*;
import com.example.BookMyShow.Repository.*;
import com.example.BookMyShow.RequestDtos.BookTicketRequest;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TicketService {
    @Autowired
    private TheaterRepository theaterRepository;
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private ShowRepository showRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TicketRepository ticketRepository;

    public String bookTicket(BookTicketRequest bookTicketRequest) {
        Show show = findRightShow(bookTicketRequest);
        List<ShowSeat> showSeatList = show.getShowSeatList();
        int totalPrice = 0;
        for(ShowSeat showSeat : showSeatList){
            if(bookTicketRequest.getRequestedSeatNos().contains(showSeat.getSeatNo())){
                showSeat.setAvailable(false);
                totalPrice = totalPrice + showSeat.getPrice();
            }
        }
        User user = userRepository.findById(bookTicketRequest.getUserId()).get();
        Ticket ticket = Ticket.builder()
                .movieName(show.getMovie().getMovieName())
                .showDate(show.getShowDate())
                .showTime(show.getShowTime())
                .bookedSeat(bookTicketRequest.getRequestedSeatNos().toString())
                .theaterAddress(show.getTheater().getAddress())
                .show(show)
                .user(user)
                .totalPrice(totalPrice)
                .build();
        user.getTicketList().add(ticket);
        show.getTicketList().add(ticket);
        ticketRepository.save(ticket);
        return "Ticket has been booked";
    }
    private Show findRightShow(BookTicketRequest bookTicketRequest){
        Movie movie = movieRepository.findMovieByMovieName(bookTicketRequest.getMovieName());
        Theater theater = theaterRepository.findById(bookTicketRequest.getTheaterId()).get();
        Show show = showRepository.findShowByShowDateAndShowTimeAndMovieAndTheater(
                bookTicketRequest.getShowDate(),
                bookTicketRequest.getShowTime(),
                movie,theater);
        return show;
    }
}
