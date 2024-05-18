package me.regisndizihiwe.supamenuservice.repositories;

import me.regisndizihiwe.supamenuservice.models.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRestaurantsRepository extends JpaRepository<Restaurant, String> {
}
