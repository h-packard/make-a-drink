package com.example.build.controllers;

import com.example.build.models.Drink;
import com.example.build.models.data.DrinkDao;
import com.example.build.models.data.InventoryDao;
import com.example.build.models.data.MenuDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @Autowired
    private DrinkDao drinkDao;
    @Autowired
    private InventoryDao inventoryDao;
    @Autowired
    private MenuDao menuDao;

    //home page
    @RequestMapping(value="")
    public String index(Model model) {

        model.addAttribute("title", "build.");
        model.addAttribute("drinks", drinkDao.findAll());

    }

}
