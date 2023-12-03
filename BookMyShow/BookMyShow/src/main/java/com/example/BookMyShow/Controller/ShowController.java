package com.example.BookMyShow.Controller;

import com.example.BookMyShow.RequestDtos.AddShowRequest;
import com.example.BookMyShow.RequestDtos.AddShowSeatRequest;
import com.example.BookMyShow.Service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("show")
public class ShowController {
    @Autowired
    private ShowService showService;
    @PostMapping("/add")
    public ResponseEntity addShow(@RequestBody AddShowRequest addShowRequest){
        return new ResponseEntity(showService.addShow(addShowRequest) , HttpStatus.OK);
    }
    @PostMapping("/createShowSeats")
    public String enableShowSeats(@RequestBody AddShowSeatRequest addShowSeatRequest){

        String result = showService.createShowSeats(addShowSeatRequest);
        return result;

    }
}
