package com.example.BookMyShow.RequestDtos;

import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddUserRequest {
    private String name;
    private String email;
    private String mobNo;
    private Integer age;
}
