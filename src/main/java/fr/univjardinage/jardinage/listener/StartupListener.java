package fr.univjardinage.jardinage.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class StartupListener {

    @EventListener(ApplicationReadyEvent.class)
    public void onReady(ApplicationReadyEvent event) {
        log.info("Application ready : {}",event.getApplicationContext().getId());
        log.info("Temps pris :{}",event.getTimeTaken());
    }

}
