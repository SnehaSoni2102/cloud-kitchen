package com.cloudkitchen.backend.service.impl;

import com.cloudkitchen.backend.dto.MenuCardDto;
import com.cloudkitchen.backend.mapper.Mapper;
import com.cloudkitchen.backend.model.MenuCards;
import com.cloudkitchen.backend.repository.MenuCardRepository;
import com.cloudkitchen.backend.service.MenuCardsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.PrintStream;

@Service
public class MenuCardsServiceImpl implements MenuCardsService {

    private final MenuCardRepository menuCardRepository;
    @Autowired
    public MenuCardsServiceImpl(MenuCardRepository menuCardRepository) {
        this.menuCardRepository = menuCardRepository;
    }

    @Override
    public MenuCardDto createMenuCards(MenuCardDto menuCardDto) {

        MenuCards menuCards = Mapper.mapToModel(menuCardDto);

        MenuCards savedMenuCards = menuCardRepository.save(menuCards);

        MenuCardDto menuCardDto1 =Mapper.mapToDto(savedMenuCards);

        return menuCardDto1;
    }
}
