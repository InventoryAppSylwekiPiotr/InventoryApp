package pl.sda.inventory.inventoryapp.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import pl.sda.inventory.inventoryapp.model.Inventory;
import pl.sda.inventory.inventoryapp.service.InventoryService;

import javax.persistence.PostRemove;
import javax.validation.Valid;


@Slf4j
@Controller
public class InventoryController {

    @Autowired
    private final InventoryService invetoryService;


    public InventoryController(InventoryService invetoryService) {
        this.invetoryService = invetoryService;
    }

    @GetMapping("/inventory/list")
    public String inventoryList(ModelMap modelMap) {
        modelMap.addAttribute("inventory",invetoryService.getAll());

        String currentUser = SecurityContextHolder.getContext().getAuthentication().getName();
        modelMap.addAttribute("currentUser", currentUser);

        return "inventory-list";
    }

    @GetMapping("/admin/inventory/add")
    public String showAddInventoryForm(ModelMap modelMap) {
        modelMap.addAttribute("emptyInventory", new Inventory());
        return "inventory-add";
    }

    @PostMapping("/admin/inventory/save")
    public String saveInventory(@Valid @ModelAttribute("emptyInventory")Inventory inventory, Errors errors) {
        log.info("Add new item: " + inventory);

        if(errors.hasErrors()){
            log.error("Errors form fronted: " +errors.getFieldErrors());
            return "inventory-add";
        }

        invetoryService.save(inventory);
        return "redirect:/inventory/list";
    }
    @GetMapping("/inventory/{invNumb}")
    public String inventoryDetails(@PathVariable String invNumb, ModelMap modelMap){
        modelMap.addAttribute("inventory",invetoryService.getByInvNumb(invNumb));
        return "inventory-number";
    }

    @GetMapping("/admin/inventory/edit/{invNumb}")
    public String showEditItem(@PathVariable String invNumb, ModelMap modelMap) {
        modelMap.addAttribute("inventory", invetoryService.getByInvNumb(invNumb));
        return "inventory-edit";
    }
    @PostMapping("/admin/inventory/update")
    public String updateItem(@ModelAttribute("inventory") Inventory inventory) {
        log.info("Update Item: " + inventory);
        invetoryService.update(inventory);
        return "redirect:/inventory/list";
    }
    @GetMapping("/admin/inventory/delete/{invNumb}")
    public String deleteItem(@PathVariable String invNumb, ModelMap modelMap) {
        log.info("Delete item by Item Number" + invNumb);
        invetoryService.deleteByInvNumb(invNumb);
        return "redirect:/inventory/list";
    }

    @GetMapping("/inventory/list/params")
    public String inventoryParametrized(ModelMap modelMap,
                                        @RequestParam(defaultValue = "0") Integer pageNo,
                                        @RequestParam(defaultValue = "2") Integer pageSize,
                                        @RequestParam(defaultValue = "id") String sortBy)  {

        modelMap.addAttribute("inventory", invetoryService.getAll(pageNo,pageSize,sortBy));
        return "inventory-list";

    }
}