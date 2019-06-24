package com.example.build.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Drink {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min=3, max=15)
    private String name;

    @OneToMany
    @JoinColumn(name = "inventory_id")
    private List<Inventory> inventories = new ArrayList<>();

    @NotNull
    @Size(min=25, max=5000)
    private String instructions;

    @ManyToMany(mappedBy = "drink")
    private List<Menu> menus;

    //used by Hibernate in the process of creating objects from data retrieved from db
    // !!! LEAVE EMPTY !!!
    public Drink() { }

    public Drink(String name, List<Inventory> inventories, String instructions) {
        this.name = name;
        this.inventories = inventories;
        this.instructions = instructions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Inventory> getInventories() {
        return inventories;
    }

    public int getId() {
        return id;
    }

    public String getInstructions() { return instructions; }

    public void setInstructions(String instructions) { this.instructions = instructions; }
}
