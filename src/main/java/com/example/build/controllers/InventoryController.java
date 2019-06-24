package com.example.build.controllers;

import com.example.build.models.Inventory;
import com.example.build.models.data.DrinkDao;
import com.example.build.models.data.InventoryDao;
import com.example.build.models.data.MenuDao;
import com.sun.xml.internal.bind.v2.TODO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "inventory")
public class InventoryController {

    @Autowired
    private DrinkDao drinkDao;
    @Autowired
    private InventoryDao inventoryDao;
    @Autowired
    private MenuDao menuDao;

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddInventory(Model model) {
        model.addAttribute("title", "Add To Your Personal Collection");
        model.addAttribute(new Inventory());
        model.addAttribute("inventory", inventoryDao.findAll());
        return "cheese/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddInventoryForm(@ModelAttribute @Valid Inventory newInventory,
                                          Errors errors,
                                          Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add  To Your Personal Collection");
            return "inventory/add";
        }

        inventoryDao.save(newInventory);
        return "redirect:";
    }

    @RequestMapping(value = "archive", method = RequestMethod.GET)
    public String displayArchiveInventoryForm(Model model) {
        model.addAttribute("inventory", inventoryDao.findAll());
        model.addAttribute("title", "Archive/Wishlist Items");
        return "inventory/remove";
    }

    @RequestMapping(value = "archive", method = RequestMethod.POST)
    public String processArchiveInventoryForm(@RequestParam int[] inventoryIds) {
        //TODO - need setter in inventory model to set id to archive
        for (int inventoryId : inventoryIds) {
            Inventory inventoryItem = inventoryDao.getById(inventoryId);
            inventoryItem.setArchive(1);
        }

        return "redirect:";
    }



}
