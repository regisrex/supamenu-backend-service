package me.regisndizihiwe.supamenuservice.models;

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

    @Column(name = "price")
    @NotBlank(message = "Item price is needed")
    private  Float price;

    @Column(name = "description")
    @NotBlank(message = "Item  description is needed")
    private String description;

    @Column(name = "preparationMinutes")
    private int preparationMinutes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

}
