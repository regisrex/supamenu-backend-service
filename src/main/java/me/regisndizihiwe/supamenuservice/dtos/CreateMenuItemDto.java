package me.regisndizihiwe.supamenuservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateMenuItemDto {
    private String  photo;
    private String itemName;
    private String description;
    private int preparationMinutes;
    private  Float price;
}
