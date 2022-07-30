package pl.sda.inventory.inventoryapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.inventory.inventoryapp.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

    Role findByName(String name);
}
