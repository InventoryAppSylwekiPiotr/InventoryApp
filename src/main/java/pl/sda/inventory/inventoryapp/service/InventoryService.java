package pl.sda.inventory.inventoryapp.service;

import pl.sda.inventory.inventoryapp.model.Inventory;

import java.util.List;

public interface InventoryService {

    void save(Inventory inventory);

    List<Inventory> getAll();

    void deleteById(Integer id);

    void update(Inventory inventory);

    Inventory getById(Integer id);
}
