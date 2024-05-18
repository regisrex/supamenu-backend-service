package me.regisndizihiwe.supamenuservice.repositories;

import me.regisndizihiwe.supamenuservice.models.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMenuItemsRepository extends JpaRepository<MenuItem, String> {

    @Query("SELECT m FROM MenuItem m WHERE m.restaurant.id = :id")
    List<MenuItem> findMenuByRestaurantId(String id);
}
