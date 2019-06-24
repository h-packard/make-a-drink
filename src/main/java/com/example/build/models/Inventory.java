package com.example.build.models;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;


@Entity
public class Inventory {

        @Id
        @GeneratedValue
        private int id;

        @NotNull
        @Size(min=3, max=50)
        private String name;

        @NotNull
        @Size(min=1, message = "Description must not be empty")
        private String description;

        @ManyToOne
        private Drink drink;

        public Inventory(String name, String description) {
            this.name = name;
            this.description = description;
        }

        public Inventory() { }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public Drink getDrink() {
            return drink;
        }

        public void setDrink(Drink drink) {
            this.drink = drink;
        }
}


