package me.regisndizihiwe.supamenuservice.serviceImpl;

import me.regisndizihiwe.supamenuservice.dtos.CreateMenuItemDto;
import me.regisndizihiwe.supamenuservice.models.MenuItem;
import me.regisndizihiwe.supamenuservice.models.Restaurant;
import me.regisndizihiwe.supamenuservice.repositories.IMenuItemsRepository;
import me.regisndizihiwe.supamenuservice.repositories.IRestaurantsRepository;
import me.regisndizihiwe.supamenuservice.services.IMenuItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuItemsServiceImpl implements IMenuItemsService {


    private final IMenuItemsRepository menuItemsRepository;
    private final IRestaurantsRepository restaurantsRepository;

    @Autowired
    public MenuItemsServiceImpl(IMenuItemsRepository menuItemsRepository, IRestaurantsRepository restaurantsRepository) {
        this.menuItemsRepository = menuItemsRepository;
        this.restaurantsRepository  = restaurantsRepository;
    }

    @Override
    public MenuItem addMenuItem(CreateMenuItemDto menuItem, String restaurantId) {
        MenuItem newItem  = new MenuItem(
                menuItem.getPreparationMinutes(),
                menuItem.getDescription(),
                menuItem.getPrice(),
                menuItem.getPhoto(),
                menuItem.getItemName()
        );
        Restaurant restaurant =  this.restaurantsRepository.findById(restaurantId).orElseThrow();
        newItem.setRestaurant(restaurant );
        MenuItem item = this.menuItemsRepository.save(newItem);
        return newItem;
    }

    @Override
    public List<MenuItem> getMenuItemsByRestaurant(String restaurantId) {
        return this.menuItemsRepository.findMenuByRestaurantId(
                restaurantId
        );
    }
}
