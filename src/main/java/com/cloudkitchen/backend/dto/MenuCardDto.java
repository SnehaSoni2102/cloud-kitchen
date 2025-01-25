package com.cloudkitchen.backend.dto;

import jakarta.persistence.Column;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuCardDto {

    private int id;

    private String imageURL;

    private int ratings;  // Ensure this matches the entity's field name

    private List<String> cuisine;

}
