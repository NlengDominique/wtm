package fr.univjardinage.jardinage.runner;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Component
@Slf4j
public class ArgRunner implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        long start = System.currentTimeMillis();
        log.info("=== Analyse des arguments ===");
        log.info("Tous les args: {}", Arrays.toString(args.getSourceArgs()));
        List<String> nonOptionArgs = args.getNonOptionArgs();
        log.info("Args positionnels: {}", nonOptionArgs);

        if (args.containsOption("mode")) {
            List<String> modes = args.getOptionValues("mode");
            log.info("Mode(s): {}", modes);
        }

        if (args.containsOption("port")) {
            String port = Objects.requireNonNull(args.getOptionValues("port")).get(0);
            log.info("Port: {}", port);
        }
        Thread.sleep(5);
        long stop = System.currentTimeMillis() - start;
        log.info("Durée du runner args : {}", stop);
    }
}
