package com.storageproject.storage.models;

import javax.persistence.*;

import static java.lang.String.format;

@Entity
public class Product {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;

    private String title, manufacturer;

    public Product(String title, String manufacturer) {
        this.title = title;
        this.manufacturer = manufacturer;
    }

    public Product() {
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String name) {
        this.title = name;
    }
    public String getManufacturer() {
        return manufacturer;
    }
    public void setManufacturer(String surname) {
        this.manufacturer = surname;
    }
}
