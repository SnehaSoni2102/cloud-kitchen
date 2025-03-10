package com.cloudkitchen.backend.controller;

import com.cloudkitchen.backend.dto.MenuCardDto;
import com.cloudkitchen.backend.service.MenuCardsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/menucards/")
public class MenuCardController {
@Autowired(required = true)
private final MenuCardsService menuCardsService;

    public MenuCardController(MenuCardsService menuCardsService) {
        this.menuCardsService = menuCardsService;
    }

    @PostMapping ("create")
    public ResponseEntity<MenuCardDto> createCard(@RequestBody MenuCardDto menuCarddto){
        return new ResponseEntity<>(menuCardsService.createMenuCards(menuCarddto),HttpStatus.CREATED);
    }
    @GetMapping ("getMenu")
    public ResponseEntity<List<MenuCardDto>> createCard(){

        return new ResponseEntity<>(menuCardsService.getAllMenucards(),HttpStatus.OK);
    }

    @GetMapping("getMenu/{id}")
    public ResponseEntity<MenuCardDto> createCard1(@PathVariable long id) {
        return new ResponseEntity<>(menuCardsService.getMenucardsById(id), HttpStatus.OK);
    }

}
