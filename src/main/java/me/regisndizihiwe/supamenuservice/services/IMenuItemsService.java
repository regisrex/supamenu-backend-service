package me.regisndizihiwe.supamenuservice.services;

import me.regisndizihiwe.supamenuservice.dtos.CreateMenuItemDto;
import me.regisndizihiwe.supamenuservice.models.MenuItem;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface IMenuItemsService {
    public MenuItem addMenuItem(CreateMenuItemDto menuItem, String restaurantId);
    public List<MenuItem> getMenuItemsByRestaurant(String restaurantId);
}

