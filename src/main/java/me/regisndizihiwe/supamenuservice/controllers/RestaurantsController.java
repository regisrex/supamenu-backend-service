package me.regisndizihiwe.supamenuservice.controllers;

import me.regisndizihiwe.supamenuservice.dtos.CreateRestaurantDto;
import me.regisndizihiwe.supamenuservice.models.Restaurant;
import me.regisndizihiwe.supamenuservice.serviceImpl.RestaurantServiceImpl;
import me.regisndizihiwe.supamenuservice.services.IRestaurantsService;
import me.regisndizihiwe.supamenuservice.utils.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/restaurants")
public class RestaurantsController {

    private RestaurantServiceImpl restaurantService;

    public RestaurantsController(RestaurantServiceImpl restaurantService) {
        this.restaurantService = restaurantService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse> getAllRestaurants() {
        return ResponseEntity
                .ok()
                .body(new ApiResponse<List<Restaurant>>(true, "Restaurants fetched", this.restaurantService.getRestaurants()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> getRestaurantbyId(@PathVariable("id") String id){
        return ResponseEntity
                .ok()
                .body(new ApiResponse<Restaurant>(true, "Restaurant fetched", this.restaurantService.getRestaurantById(id)));
    }

    @PostMapping
    public ResponseEntity<ApiResponse> createRestaurant(
            @RequestBody() CreateRestaurantDto dto) {
        return ResponseEntity
                .ok()
                .body(new ApiResponse<Restaurant>(true, "Restaurant created", this.restaurantService.createRestaurant(dto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteRestaurant(@PathVariable("id") String id){
        return ResponseEntity
                .ok()
                .body(new ApiResponse<Restaurant>(true, "Restaurant deleted", this.restaurantService.deleteRestaurant(id)));
    }
}
