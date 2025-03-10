package com.cloudkitchen.backend.service.impl;

import com.cloudkitchen.backend.dto.MenuCardDto;
import com.cloudkitchen.backend.mapper.Mapper;
import com.cloudkitchen.backend.model.MenuCards;
import com.cloudkitchen.backend.repository.MenuCardRepository;
import com.cloudkitchen.backend.service.MenuCardsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.PrintStream;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MenuCardsServiceImpl implements MenuCardsService {

    private final  Mapper mapper;

    private final MenuCardRepository menuCardRepository;
    @Autowired
    public MenuCardsServiceImpl(MenuCardRepository menuCardRepository, Mapper mapper) {
        this.menuCardRepository = menuCardRepository;
        this.mapper=mapper;
    }

    @Override
    public MenuCardDto createMenuCards(MenuCardDto menuCardDto) {

        MenuCards menuCards = mapper.mapToModel(menuCardDto);

        MenuCards savedMenuCards = menuCardRepository.save(menuCards);

        MenuCardDto menuCardDto1 =mapper.mapToDto(savedMenuCards);

        return menuCardDto1;
    }

    @Override
    public List<MenuCardDto> getAllMenucards() {
        List<MenuCards> allMenuCards = menuCardRepository.findAll();
        List<MenuCardDto> allMenuCardsDto = allMenuCards.stream().map(allMenucards -> mapper.mapToDto(allMenucards)).collect(Collectors.toList());
        return allMenuCardsDto;
    }

    @Override
    public MenuCardDto getMenucardsById(long id) {
        MenuCards menuCards = menuCardRepository.findById(id).orElseThrow(null);
        MenuCardDto menuCardDto = mapper.mapToDto(menuCards);
        return menuCardDto;
    }
}
