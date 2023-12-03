package com.example.BookMyShow.Models;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    private String name;
    @Column(unique = true)
    private String email;

    private String mobNo;
    private Integer age;

    @OneToMany(mappedBy = "user" , cascade = CascadeType.ALL)
    private List<Ticket> ticketList = new ArrayList<>();

}
