package me.regisndizihiwe.supamenuservice.models;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.boot.context.properties.bind.DefaultValue;

import java.util.Set;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "restaurants", uniqueConstraints = {@UniqueConstraint(columnNames = {"email"}), @UniqueConstraint(columnNames = {"email"})})
public class Restaurant {

    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    @Id
    private String id;

    @Column(name = "name")
    @NotBlank(message = "Provide restaurant\'s name")
    private String name;

    @Column(name = "location")
    @NotBlank(message = "Provide restaurant\'s location")
    private String location;

    @Column(name = "rate")
    private int rate;

    @Column(name = "phoneNumber")
    @NotBlank(message = "Restaurant phone is required")
    private String phoneNumber;


    @Column(name = "websiteUrl")
    private String websiteUrl;

    @Email
    @NotNull(message = "Email is mandatory")
    private String email;

    @Column(name = "photo")
    private String photo;

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private Set<MenuItem> menuItems;

    public Restaurant(String email, String websiteUrl, String phoneNumber, int rate, String location, String name , String photo) {
        this.email = email;
        this.websiteUrl = websiteUrl;
        this.phoneNumber = phoneNumber;
        this.rate = rate;
        this.photo = photo;
        this.location = location;
        this.name = name;
    }



}
