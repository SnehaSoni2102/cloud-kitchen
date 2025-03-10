package com.cloudkitchen.backend.service;

import com.cloudkitchen.backend.dto.MenuCardDto;

import java.util.List;

public interface MenuCardsService {
    public MenuCardDto createMenuCards(MenuCardDto menuCardDto);
    public List<MenuCardDto> getAllMenuCards();
    public MenuCardDto getMenuCardsById(long id);
}
