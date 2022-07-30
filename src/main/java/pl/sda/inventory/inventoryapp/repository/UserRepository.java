package pl.sda.inventory.inventoryapp.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.inventory.inventoryapp.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUsername(String username);

    boolean existsByUsername(String username);
}