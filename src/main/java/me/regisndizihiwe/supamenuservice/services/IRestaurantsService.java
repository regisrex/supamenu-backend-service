package me.regisndizihiwe.supamenuservice.services;
import me.regisndizihiwe.supamenuservice.dtos.CreateRestaurantDto;
import me.regisndizihiwe.supamenuservice.models.Restaurant;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface IRestaurantsService {
    public List<Restaurant> getRestaurants();
    public Restaurant getRestaurantById(String id);
    public Restaurant createRestaurant(CreateRestaurantDto dto);
    public Restaurant deleteRestaurant(String id);

}
