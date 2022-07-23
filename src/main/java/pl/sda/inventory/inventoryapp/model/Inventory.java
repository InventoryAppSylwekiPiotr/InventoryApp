package pl.sda.inventory.inventoryapp.model;

import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.time.LocalDate;


@Data
@NoArgsConstructor
@Entity

public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;

    private String item;

    private String owner;

    private String place;

    private String invNumb;

    @Column(length = 1000)
    private String description;

    private LocalDate addDate;

}
