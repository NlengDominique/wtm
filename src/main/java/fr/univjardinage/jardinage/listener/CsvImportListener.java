package fr.univjardinage.jardinage.listener;

import fr.univjardinage.jardinage.event.CsvImportEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CsvImportListener {

    @EventListener(CsvImportEvent.class)
    public void onCsvImportFinished(CsvImportEvent event) {
        log.info("Received event {}", event.toString());
    }
}
