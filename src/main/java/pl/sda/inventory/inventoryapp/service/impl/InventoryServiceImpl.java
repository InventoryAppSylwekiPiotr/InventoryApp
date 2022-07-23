package pl.sda.inventory.inventoryapp.service.impl;

import org.springframework.stereotype.Service;
import pl.sda.inventory.inventoryapp.model.Inventory;
import pl.sda.inventory.inventoryapp.repository.InventoryRepository;
import pl.sda.inventory.inventoryapp.service.InventoryService;

import java.util.List;

@Service
public class InventoryServiceImpl implements InventoryService {


    private final InventoryRepository inventoryRepository;

    public InventoryServiceImpl(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }


    @Override
    public void save(Inventory inventory) {
        inventoryRepository.save(inventory);
    }

    @Override
    public List<Inventory> getAll() {
        return inventoryRepository.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        inventoryRepository.deleteById(id);
    }

    @Override
    public void update(Inventory inventory) {
        inventoryRepository.save(inventory);
    }

    @Override
    public Inventory getById(Integer id) {
        return inventoryRepository.findById(id).orElse(null);
    }
}
