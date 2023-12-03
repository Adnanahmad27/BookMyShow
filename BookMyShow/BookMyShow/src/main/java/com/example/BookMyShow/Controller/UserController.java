package com.example.BookMyShow.Controller;

import com.example.BookMyShow.RequestDtos.AddUserRequest;
import com.example.BookMyShow.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/add")
    public ResponseEntity addUser(AddUserRequest addUserRequest){
        String result = userService.addUser(addUserRequest);
        return null;
    }
}
