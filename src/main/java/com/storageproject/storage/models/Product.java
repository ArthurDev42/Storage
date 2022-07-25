package com.storageproject.storage.models;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String title;
    private int quantity;
    @Column(name = "release_date")
    private Date releaseDate;
    @Column(name = "upc_code")
    private long upc;
    private String manufacturer;
    @ManyToOne
    @JoinColumn(name = "provider_id")
    private Provider provider;
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    public Product(String title, int quantity, Date releaseDate, long upc, String manufacturer, Provider provider) {
        this.title = title;
        this.quantity = quantity;
        this.releaseDate = releaseDate;
        this.upc = upc;
        this.manufacturer = manufacturer;
        this.provider = provider;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
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
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public Date getReleaseDate() {
        return releaseDate;
    }
    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }
    public long getUpc() {
        return upc;
    }
    public void setUpc(long upc) {
        this.upc = upc;
    }
}
