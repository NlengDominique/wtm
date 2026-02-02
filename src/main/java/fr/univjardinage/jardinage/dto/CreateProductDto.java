package fr.univjardinage.jardinage.dto;

import fr.univjardinage.jardinage.entity.ProductCategory;

import java.math.BigDecimal;

public record CreateProductDto(
        String name,
        ProductCategory category,
        BigDecimal price,
        Integer stock,
        String description
) {
}
