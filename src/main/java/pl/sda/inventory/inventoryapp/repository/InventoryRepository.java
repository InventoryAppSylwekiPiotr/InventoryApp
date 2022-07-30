package pl.sda.inventory.inventoryapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.inventory.inventoryapp.model.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Integer> {

    Inventory findByInvNumb(String invNumb);

//    Inventory deleteByInvNumb(String invNumb);
}
