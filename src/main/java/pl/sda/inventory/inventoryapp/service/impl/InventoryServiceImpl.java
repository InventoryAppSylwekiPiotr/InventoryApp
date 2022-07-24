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

    public void deleteByInvNumb(String invNumb) {
        Inventory inventory = getByInvNumb(invNumb);
        inventoryRepository.deleteById(inventory.getId());
    }

    @Override
    public void update(Inventory inventory) {
        inventoryRepository.save(inventory);
    }

    @Override
    public Inventory getById(Integer id) {
        return inventoryRepository.findById(id).orElse(null);
    }

    @Override
    public Inventory getByInvNumb(String invNumb) {
        return inventoryRepository.findByInvNumb(invNumb);
    }
}
