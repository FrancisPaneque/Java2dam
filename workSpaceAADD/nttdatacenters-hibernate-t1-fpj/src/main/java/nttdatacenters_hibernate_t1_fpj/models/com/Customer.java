package nttdatacenters_hibernate_t1_fpj.models.com;

import java.io.Serializable;

import javax.persistence.*;

import lombok.Data;

/**
 * Represents a Customer entity with JPA annotations.
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "cliente")
@Data
public class Customer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Customer's name
    @Column(name = "name", nullable = false)
    private String name;

    // Customer's first surname
    @Column(name = "first_surname", nullable = false)
    private String firstSurname;

    // Customer's second surname
    @Column(name = "second_surname")
    private String secondSurname;

    // Unique identifier for the customer, e.g., national ID
    @Column(name = "doct_number", unique = true, nullable = false, length = 9)
    private String documentNumber;
}

