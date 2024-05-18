package me.regisndizihiwe.supamenuservice.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateRestaurantDto {
    @NotEmpty
    private String name;
    @NotEmpty
    private String location;
    @NotEmpty
    private int rate;

    @NotEmpty
    private String phoneNumber;

    private String websiteUrl;

    @Email
    private String email;

}
