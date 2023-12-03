package com.example.BookMyShow.RequestDtos;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddShowSeatRequest {
        private Integer showId;
        private Integer priceOfClassicSeats;
        private Integer priceOfPremiumSeats;
    }

