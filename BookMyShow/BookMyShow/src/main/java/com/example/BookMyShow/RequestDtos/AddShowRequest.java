package com.example.BookMyShow.RequestDtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddShowRequest {
    private LocalDate showDate;
    private LocalTime showTime;
    private String movieName; //Movie name is unique : movie Entity is unique
    private Integer theaterId;
}
