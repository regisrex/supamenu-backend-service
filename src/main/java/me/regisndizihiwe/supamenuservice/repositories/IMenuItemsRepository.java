package me.regisndizihiwe.supamenuservice.repositories;

import me.regisndizihiwe.supamenuservice.models.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMenuItemsRepository extends JpaRepository<MenuItem, String> {

}
