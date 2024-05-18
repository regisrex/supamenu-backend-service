package me.regisndizihiwe.supamenuservice.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.boot.context.properties.bind.DefaultValue;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "menuItems", uniqueConstraints = { @UniqueConstraint(columnNames = {"name"})})
public class MenuItem {
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    @Id
    private String id;

    @Column(name =  "item_name")
    @NotBlank(message= "Item should have a name")
    private String itemName;

    @Column(name =  "photo")
    private String photo;

    @Column(name = "price")
    @NotBlank(message = "Item price is needed")
    private  Float price;

    @Column(name = "description")
    private String description;

    @Column(name = "preparationMinutes")
    private int preparationMinutes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    public MenuItem(int preparationMinutes, String description, Float price, String photo, String itemName) {
        this.preparationMinutes = preparationMinutes;
        this.description = description;
        this.price = price;
        this.photo = photo;
        this.itemName = itemName;
    }
}
