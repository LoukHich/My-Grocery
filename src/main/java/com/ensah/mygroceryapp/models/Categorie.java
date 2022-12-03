package com.ensah.mygroceryapp.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "Categorie")
public class Categorie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name ;

    @OneToMany(mappedBy = "categorie")
    List<Product>  products = new ArrayList<>();
}
