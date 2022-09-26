package com.kh.models;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
@Data
@Entity
public class Customer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="customer_id")
    private Long customer_id;

    @Column(name="name")
    private String name;

    @Column(name="last_name")
    private String last_name;

    @Column(name="email")
    private String email;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name="birthday")
    private LocalDate birthday;

}
