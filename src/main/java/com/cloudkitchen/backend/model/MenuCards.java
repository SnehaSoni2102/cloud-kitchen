package com.cloudkitchen.backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "menu_cards")
public class MenuCards {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;

    private String imageURL;

     // Nullable is fine, just make sure you are handling nulls properly
    private int ratings;

    private List<String> cuisine;

    public void setId(int id) {
        this.id = id;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public void setRatings(int ratings) {
        this.ratings = ratings;
    }

    public void setCuisine(List<String> cuisine) {
        this.cuisine = cuisine;
    }

    public int getId() {
        return id;
    }

    public String getImageURL() {
        return imageURL;
    }

    public int getRatings() {
        return ratings;
    }

    public List<String> getCuisine() {
        return cuisine;
    }
}
