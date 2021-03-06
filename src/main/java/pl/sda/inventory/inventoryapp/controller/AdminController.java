package pl.sda.inventory.inventoryapp.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import pl.sda.inventory.inventoryapp.dto.UserDto;
import pl.sda.inventory.inventoryapp.model.User;
import pl.sda.inventory.inventoryapp.service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class AdminController {

    private final UserService userService;

    public AdminController(UserService userService) {

        this.userService = userService;
    }

    @GetMapping("/admin/users/list")
    public String showUserList(ModelMap modelMap){
        List<UserDto> userDtoList = new ArrayList<>();

        for(User user: userService.findAll()){
            UserDto userDto = new UserDto(user.getUsername(),
                    user.getRoles()
                            .stream()
                            .map(u -> u.getName() + " ")
                            .collect(Collectors.joining())
            );

            userDtoList.add(userDto);
        }

        modelMap.addAttribute("users", userDtoList);
        return "user-list";
    }
}