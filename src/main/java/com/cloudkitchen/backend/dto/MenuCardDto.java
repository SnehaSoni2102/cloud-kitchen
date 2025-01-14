package com.cloudkitchen.backend.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuCardDto {

    private int id;

    private String imageURL;

    private int ratings;  // Ensure this matches the entity's field name

    private List<String> cuisine;

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
}
