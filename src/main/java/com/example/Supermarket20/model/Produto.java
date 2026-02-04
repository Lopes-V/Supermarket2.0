package com.example.Supermarket20.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table (name = "Produto")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Produto {
    @Id
    @GeneratedValue (strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    @Column(precision = 10, scale = 2)
    private BigDecimal value;
    @Column(precision = 5)
    private int quantity;
    @ManyToOne
    private Categoria categoria;

}
