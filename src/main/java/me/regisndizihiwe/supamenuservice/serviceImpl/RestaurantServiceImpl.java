package me.regisndizihiwe.supamenuservice.serviceImpl;
import me.regisndizihiwe.supamenuservice.models.Restaurant;
import me.regisndizihiwe.supamenuservice.repositories.IRestaurantsRepository;
import me.regisndizihiwe.supamenuservice.services.IRestaurantsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RestaurantServiceImpl implements IRestaurantsService {

    private final IRestaurantsRepository restaurantRepository;

    @Autowired
    public RestaurantServiceImpl(IRestaurantsRepository restaurantRepository){
        this.restaurantRepository = restaurantRepository;
    }


    @Override
    public List<Restaurant> getRestaurants() {
        return this.restaurantRepository.findAll();
    }
}
