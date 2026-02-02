package fr.univjardinage.jardinage.entity;

import lombok.Getter;

@Getter
public enum ProductCategory {

    PLANTE("Plante"),
    OUTIL("Outil"),
    ENGRAIS ("Engrais") ,
    TERRE ("Terre et terreau" ) ,
    ACCESSOIRE ("Accessoire") ;

    private final String displayName;

    ProductCategory(String displayName) {
        this.displayName = displayName;
    }

}
