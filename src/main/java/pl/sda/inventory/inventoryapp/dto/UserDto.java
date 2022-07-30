package pl.sda.inventory.inventoryapp.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;


@ToString
@Getter
@AllArgsConstructor
public class UserDto {

    private String username;

    private String roles;


}