package pl.sda.inventory.inventoryapp.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity

public class Inventory {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(min=3, max =50, message = "Field item must be at least 3 characters and max 30 characters")
    private String item;

    @Size(min=3, max =50, message = "Field owner must be at least 3 characters and max 30 characters")
    private String owner;

    private String place;

    @Size(min=3, message = "Field place must be at least 3 characters")
    private String invNumb;

    @Column(length = 1000)
    private String description;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate addDate;
}









