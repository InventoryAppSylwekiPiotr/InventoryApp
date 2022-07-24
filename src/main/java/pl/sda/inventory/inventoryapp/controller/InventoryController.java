package pl.sda.inventory.inventoryapp.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.sda.inventory.inventoryapp.model.Inventory;
import pl.sda.inventory.inventoryapp.service.InventoryService;

import javax.persistence.PostRemove;


@Slf4j
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

    @GetMapping("/inventory/add")
    public String showAddInventoryForm(ModelMap modelMap) {
        modelMap.addAttribute("emptyInventory", new Inventory());
        return "inventory-add";
    }

    @PostMapping("/inventory/save")
    public String saveInventory(@ModelAttribute("emptyInventory")Inventory inventory) {
      log.info("Add new Item: " + inventory);

        invetoryService.save(inventory);
        return "redirect:/inventory/list";
    }
    @GetMapping("/inventory/{invNumb}")
    public String inventoryDetails(@PathVariable String invNumb, ModelMap modelMap){
        modelMap.addAttribute("inventory",invetoryService.getByInvNumb(invNumb));
        return "inventory-number";
    }

    @GetMapping("/inventory/edit/{invNumb}")
    public String showEditItem(@PathVariable String invNumb, ModelMap modelMap) {
        modelMap.addAttribute("inventory", invetoryService.getByInvNumb(invNumb));
        return "inventory-edit";
    }
    @PostMapping("/inventory/update")
    public String updateItem(@ModelAttribute("inventory") Inventory inventory) {
        log.info("Update Item: " + inventory);
        invetoryService.update(inventory);
        return "redirect:/inventory/list";
    }
    @GetMapping("/inventory/delete/{invNumb}")
    public String deleteItem(@PathVariable String invNumb, ModelMap modelMap) {
        log.info("Delete item by Item Number" + invNumb);
        invetoryService.deleteByInvNumb(invNumb);
        return "redirect:/inventory/list";
    }


}
