package pl.sda.inventory.inventoryapp.service;

import pl.sda.inventory.inventoryapp.exception.EmptyUsernameException;
import pl.sda.inventory.inventoryapp.model.User;

import java.util.List;

public interface UserService {

    boolean existsByUserName(String username) throws EmptyUsernameException;

    void save(User user);

    List<User> findAll();


}