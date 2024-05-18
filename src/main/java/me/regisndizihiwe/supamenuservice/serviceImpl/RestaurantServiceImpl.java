package me.regisndizihiwe.supamenuservice.serviceImpl;

import me.regisndizihiwe.supamenuservice.dtos.CreateRestaurantDto;
import me.regisndizihiwe.supamenuservice.models.Restaurant;
import me.regisndizihiwe.supamenuservice.repositories.IRestaurantsRepository;
import me.regisndizihiwe.supamenuservice.services.IRestaurantsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantServiceImpl implements IRestaurantsService {

    private final IRestaurantsRepository restaurantRepository;

    @Autowired
    public RestaurantServiceImpl(IRestaurantsRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }


    @Override
    public List<Restaurant> getRestaurants() {
        return this.restaurantRepository.findAll();
    }

    @Override
    public Restaurant createRestaurant(CreateRestaurantDto dto) {
        Restaurant newRestaurant = new Restaurant(
                dto.getEmail(),
                dto.getWebsiteUrl(),
                dto.getPhoneNumber(),
                dto.getRate(),
                dto.getLocation(),
                dto.getName()
        );
        return this.restaurantRepository.save(newRestaurant);
    }

    @Override
    public Restaurant deleteRestaurant(String id){
     this.restaurantRepository.deleteById(id);
     return null;
    }


    @Override
    public Restaurant getRestaurantById(String id){
        Optional<Restaurant> restaurant = this.restaurantRepository.findById(id);
        return restaurant.isEmpty() ? null : restaurant.get() ;
    }
}
