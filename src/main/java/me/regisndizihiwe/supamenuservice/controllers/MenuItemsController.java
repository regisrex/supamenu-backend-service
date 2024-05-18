package me.regisndizihiwe.supamenuservice.controllers;

import me.regisndizihiwe.supamenuservice.dtos.CreateMenuItemDto;
import me.regisndizihiwe.supamenuservice.models.MenuItem;
import me.regisndizihiwe.supamenuservice.serviceImpl.MenuItemsServiceImpl;
import me.regisndizihiwe.supamenuservice.serviceImpl.RestaurantServiceImpl;
import me.regisndizihiwe.supamenuservice.utils.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/menu_items")
public class MenuItemsController {


    private MenuItemsServiceImpl menuService;

    public MenuItemsController(MenuItemsServiceImpl menuService) {
        this.menuService = menuService;
    }

    @PostMapping("/{restaurantId}")
    public ResponseEntity<ApiResponse> createMenuItem(
            @RequestBody() CreateMenuItemDto itemDto,
            @PathVariable("restaurantId") String restaurantId
    ) {
        return ResponseEntity
                .ok()
                .body(new ApiResponse(true, "Item added to menu", this.menuService.addMenuItem( itemDto, restaurantId)));
    }


    @GetMapping("/menu/{restaurantId}")
    public ResponseEntity<ApiResponse> getMenuByRestaurant(@PathVariable("restaurantId") String restoId) {
        return ResponseEntity
                .ok()
                .body(new ApiResponse<List<MenuItem>>(true, "Menu fetched", this.menuService.getMenuItemsByRestaurant(restoId)));
    }

}
