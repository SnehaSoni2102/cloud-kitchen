package com.cloudkitchen.backend.mapper;

import com.cloudkitchen.backend.dto.MenuCardDto;
import com.cloudkitchen.backend.model.MenuCards;

public class Mapper {
    public static MenuCardDto mapToDto(MenuCards menuCards){
        MenuCardDto menuCardDto =new MenuCardDto();
        menuCardDto.setImageURL(menuCards.getImageURL());
        menuCardDto.setRatings(menuCards.getRatings());
        menuCardDto.setCuisine(menuCards.getCuisine());
        return menuCardDto;
    }

    public static MenuCards mapToModel(MenuCardDto menuCardDto){
        MenuCards menuCards = new MenuCards();
        menuCards.setImageURL(menuCardDto.getImageURL());  // Set the image URL
        menuCards.setRatings(menuCardDto.getRatings());    // Set the ratings
        menuCards.setCuisine(menuCardDto.getCuisine());
        return menuCards;
    }

}
