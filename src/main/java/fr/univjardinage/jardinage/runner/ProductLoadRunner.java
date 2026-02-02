package fr.univjardinage.jardinage.runner;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
@Order(3)
public class ProductLoadRunner implements CommandLineRunner {


    @Override
    public void run(String... args) throws Exception {
        log.info("[Ordre 3] chargement des produits de jardinage");

        List<String> products = List.of(
                "Rosier grimpant - Catégorie : Plantes - Prix : 15.99 EUR",
                " Tondeuse électrique - Catégorie : Outils - Prix : 299.99 EUR ",
                " Engrais bio 5 kg - Catégorie : Engrais - Prix : 12.50 EUR ",
                " Terreau universel 50 L - Catégorie : Terre - Prix : 8.90 EUR ",
                "Scatter professionnel - Catégorie :Outils - Prix : 45.00 EUR"
        );
        log.info("Nombre de produits a charger : {}",products.size());

        products.forEach(product -> { log.debug("Produit charge : {}", product);});
        log.info("Tous les produits ont ete charge avec succès");
    }
}
