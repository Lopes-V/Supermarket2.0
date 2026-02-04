package com.example.Supermarket20.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table (name = "Categoria")
@Getter
@Setter
public class Categoria {
    @Id
    @GeneratedValue (strategy = GenerationType.UUID)
    private UUID id;
    private String name;
}
