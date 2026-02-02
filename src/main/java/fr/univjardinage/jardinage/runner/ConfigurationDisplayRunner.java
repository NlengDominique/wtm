package fr.univjardinage.jardinage.runner;

import jakarta.validation.constraints.NotNull;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Objects;


@Component
@Slf4j
@Order(2)
public class ConfigurationDisplayRunner implements CommandLineRunner {


    @Value("${spring.application.name}")
    private String applicationName;
    @Value("${spring.profiles.active}")
    private String activeProfile;
    @Value("${server.port}")
    private String serverPort;

    @Override
    public void run(String... args) throws Exception {
        log.info("[Ordre 2 ] affichage de la configuration");
        log.info("Nom de l'application : {}", applicationName);
        log.info("Profil actif : {}",activeProfile);
        log.info("Port du serveur : {}",serverPort);
    }


}
