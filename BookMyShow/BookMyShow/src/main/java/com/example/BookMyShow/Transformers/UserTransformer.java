package com.example.BookMyShow.Transformers;

import com.example.BookMyShow.Models.User;
import com.example.BookMyShow.RequestDtos.AddUserRequest;

public class UserTransformer {
    public static User convertUserReqToUser(AddUserRequest addUserRequest){
        User user = User.builder()
                .name(addUserRequest.getName())
                .email(addUserRequest.getEmail())
                .mobNo(addUserRequest.getMobNo())
                .age(addUserRequest.getAge())
                .build();
        return user;
    }
}
