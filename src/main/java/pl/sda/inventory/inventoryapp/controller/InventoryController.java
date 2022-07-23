package pl.sda.inventory.inventoryapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import pl.sda.inventory.inventoryapp.service.InventoryService;

@Controller
public class InventoryController {

    private final InventoryService invetoryService;


    public InventoryController(InventoryService invetoryService) {
        this.invetoryService = invetoryService;
    }
    @GetMapping("/inventory/list")
    public String inventoryList(ModelMap modelMap) {
        modelMap.addAttribute("inventory",invetoryService.getAll());
        return "inventory-list";
    }
}
