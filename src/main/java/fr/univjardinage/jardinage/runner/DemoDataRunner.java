package fr.univjardinage.jardinage.runner;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@Order(4)
@ConditionalOnProperty(
        name = "app.demo.data.enabled",
        havingValue = "true",
        matchIfMissing = false
)
public class DemoDataRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        log.info ("[ ORDRE 4 - CONDITIONNEL] Chargement des donnees de demonstration") ;
        log.info("Attention : mode demo active");
        log.info("Donnees fictives chargees pour les tests");
    }
}
