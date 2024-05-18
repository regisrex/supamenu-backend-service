package me.regisndizihiwe.supamenuservice.repositories;

import me.regisndizihiwe.supamenuservice.models.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMenuItemsRepository extends JpaRepository<MenuItem, String> {

}
