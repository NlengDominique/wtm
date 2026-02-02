package fr.univjardinage.jardinage.runner;

import fr.univjardinage.jardinage.entity.Customer;
import fr.univjardinage.jardinage.event.CsvImportEvent;
import fr.univjardinage.jardinage.repo.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;


import java.io.*;

@Component
@Slf4j
@RequiredArgsConstructor
public class CsvRunner implements CommandLineRunner {

    private final CustomerRepository customerRepository;

    private final ApplicationEventPublisher eventPublisher;

    private static final int MAX_CUSTOMERS = 100;

    @Override
    public void run(String... args) throws Exception {
        long start = System.currentTimeMillis();
        log.info("Debut import csv");
        try(BufferedReader reader = new BufferedReader(new FileReader("customers-100.csv"))) {
            String header = reader.readLine();
            log.info("Header détecté : {}", header);
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                csvToCustomer(fields);
            }
        }
        catch (IOException e) {
            log.error(e.getMessage(), e);
        }
        log.info("Import termine");
        eventPublisher.publishEvent(new CsvImportEvent(
                MAX_CUSTOMERS,System.currentTimeMillis() - start
        ));

    }

    private void csvToCustomer(String[] fields) {
        Long index = Long.valueOf(fields[0]);
        String customerId = fields[1];
        String firstName = fields[2];
        String lastName = fields[3];
        Customer customer = Customer.builder()
                .index(index)
                .customerId(customerId)
                .firstName(firstName)
                .lastName(lastName)
                .build();

        customerRepository.save(customer);
        log.info("Customer {}: {} {}", index, firstName, lastName);
    }
}
