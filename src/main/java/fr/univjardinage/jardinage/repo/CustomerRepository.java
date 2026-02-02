package fr.univjardinage.jardinage.repo;

import fr.univjardinage.jardinage.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {}
