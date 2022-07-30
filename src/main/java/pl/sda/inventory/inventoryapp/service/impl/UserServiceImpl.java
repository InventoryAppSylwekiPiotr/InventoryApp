package pl.sda.inventory.inventoryapp.service.impl;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.sda.inventory.inventoryapp.exception.EmptyUsernameException;
import pl.sda.inventory.inventoryapp.model.Role;
import pl.sda.inventory.inventoryapp.model.User;
import pl.sda.inventory.inventoryapp.repository.RoleRepository;
import pl.sda.inventory.inventoryapp.repository.UserRepository;
import pl.sda.inventory.inventoryapp.service.UserService;

import java.util.Arrays;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;




    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }


    @Override
    public boolean existsByUserName(String username) throws EmptyUsernameException {
        if(username==null || username.isBlank()){
            throw new EmptyUsernameException("Username can not be empty!");
        }
        return userRepository.existsByUsername(username);
    }

    @Override
    public void save (User user) {
        user.setRoles( getUserRoles());
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    private List<Role> getUserRoles(){
        Role userRole = roleRepository.findByName("USER");
        return Arrays.asList(userRole);
    }
}