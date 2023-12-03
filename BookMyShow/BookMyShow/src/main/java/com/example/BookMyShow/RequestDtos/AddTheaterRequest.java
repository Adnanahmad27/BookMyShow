package com.example.BookMyShow.RequestDtos;

import com.example.BookMyShow.Enums.Location;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddTheaterRequest {
    private String name;
    private Location location;
    private String address;
    private int noOfRows;
    private int noOfPremiumSeats;
    private int noOfClassicSeat;
}
