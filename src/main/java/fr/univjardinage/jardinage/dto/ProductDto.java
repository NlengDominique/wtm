package fr.univjardinage.jardinage.dto;

import fr.univjardinage.jardinage.entity.ProductCategory;

import java.time.LocalDateTime;

public record ProductDto(
        Long id,
        String name,
        ProductCategory category,
        Integer stock,
        String description,
        Boolean active,
        LocalDateTime creationDate
) {
}
