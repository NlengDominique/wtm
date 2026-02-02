package fr.univjardinage.jardinage.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "customers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {

    @Id
    private Long index;
    private String customerId;
    private String firstName;
    private String lastName;
    private String email;
    private String company;
    private String country;
    private String city;
    private String phone1;
    private String phone2;
    private LocalDate subscriptionDate;
    private String website;
}
