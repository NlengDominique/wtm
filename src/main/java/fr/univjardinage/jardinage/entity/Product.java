package fr.univjardinage.jardinage.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,length = 100)
    private String name;
    private ProductCategory category;
    @Column ( nullable = false , precision = 10 , scale = 2)
    private BigDecimal price ;
    @Column ( nullable = false )
    private Integer stock ;
    @Column(length = 500)
    private String description ;
    @Column ( nullable = false )
    private Boolean active ;
    @Column ( nullable = false , updatable = false )
    private LocalDateTime creationDate ;

    @PrePersist
    public void prePersist() {
        if (creationDate == null) {
            creationDate = LocalDateTime.now();
        }
        if (active == null) {
            active = true ;
        }
    }
}
