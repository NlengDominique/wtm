package fr.univjardinage.jardinage.runner;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class DataInitializerRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        log.info("Démarrage de l'initialisation des donnees");
        log.info("Chargement des categories de produits.....");
        Thread.sleep(500);
        log.info("Categories chargees: Plantes ,Outils,Engrais");
        log.info("Chargement des produits initiaux...");
        Thread.sleep(500);
        log.info("10 produits charges avec succès");
        log.info("Initialisation terminée");

    }
}
