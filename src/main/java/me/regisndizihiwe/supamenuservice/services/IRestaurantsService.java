package me.regisndizihiwe.supamenuservice.services;
import me.regisndizihiwe.supamenuservice.models.Restaurant;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface IRestaurantsService {
    public List<Restaurant> getRestaurants();
}
