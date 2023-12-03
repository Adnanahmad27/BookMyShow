package com.example.BookMyShow.Service;

import com.example.BookMyShow.Enums.SeatType;
import com.example.BookMyShow.Models.Theater;
import com.example.BookMyShow.Models.TheaterSeat;
import com.example.BookMyShow.Repository.TheaterRepository;
import com.example.BookMyShow.RequestDtos.AddTheaterRequest;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class TheaterService {

    @Autowired
    private TheaterRepository theaterRepository;
    public String addTheater(AddTheaterRequest addTheaterRequest) {
        Theater theater = Theater.builder()
                .name(addTheaterRequest.getName())
                .address(addTheaterRequest.getAddress())
                .location(addTheaterRequest.getLocation())
                            .build();
        CreateTheaterSeat(theater,addTheaterRequest);
        return "Theater is added successfully";
    }

    private void CreateTheaterSeat(Theater theater, AddTheaterRequest addTheaterRequest) {
        int noOfRows = addTheaterRequest.getNoOfRows();
        int noOfPremiumSeat = addTheaterRequest.getNoOfPremiumSeats();
        int noOfClassicSeat = addTheaterRequest.getNoOfClassicSeat();

        List<TheaterSeat> theaterSeatList = new ArrayList<>();
        int row = 0;
        char ch = 'A';
        for(int i=0 ; i < noOfClassicSeat ; i++){
            if(i%noOfRows==0){
                row++;
                ch = 'A';
            }
            String seatNo = row+""+ch;
            TheaterSeat theaterSeat = TheaterSeat.builder()
                    .seatNo(seatNo)
                    .seatType(SeatType.CLASSIC)
                    .build();
            ch++;
            theaterSeatList.add(theaterSeat);
        }
        for(int i=0 ; i<noOfPremiumSeat ; i++){
            if(i%noOfRows==0){
                row++;
                ch = 'A';
            }
            String seatNo = row+""+ch;
            TheaterSeat theaterSeat = TheaterSeat.builder()
                    .seatNo(seatNo)
                    .seatType(SeatType.PREMIUM)
                    .build();
            ch++;
            theaterSeatList.add(theaterSeat);
        }
        theater.setTheaterSeatList(theaterSeatList);
        theaterRepository.save(theater);
    }
}
