package pl.sda.inventory.inventoryapp.service.impl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pl.sda.inventory.inventoryapp.model.Inventory;
import pl.sda.inventory.inventoryapp.repository.InventoryRepository;
import pl.sda.inventory.inventoryapp.service.InventoryService;

import java.util.List;

@Slf4j
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

    @Override
    public List<Inventory> getAll(int pageNo, int pageSize, String sortBy) {

        Pageable pageRequest = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

        Page<Inventory> inventoryPage = inventoryRepository.findAll(pageRequest);

        log.info("Total elements: " + inventoryPage.getTotalElements());
        log.info("Total pages: " + inventoryPage.getTotalPages());
        log.info("Elements in this page: " + inventoryPage.getNumberOfElements());
        log.info("Page number: " + inventoryPage.getNumber());

        return inventoryPage.getContent();
    }
}