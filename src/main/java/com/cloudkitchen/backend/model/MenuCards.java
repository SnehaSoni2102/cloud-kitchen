package com.cloudkitchen.backend.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@Table(name = "menu_cards")
public class MenuCards {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;

    private String imageURL;

     // Nullable is fine, just make sure you are handling nulls properly
    private int ratings;

    private List<String> cuisine;

    public long getId() {
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

    public void setId(long id) {
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
}
