package com.storageproject.storage.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Provider {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    String title;
    String contacts;
    String data;
    @OneToMany(mappedBy = "provider")
    private List<Product> products;

    public Provider() {

    }

    public Provider(String title, String contacts, String data) {
        this.title = title;
        this.contacts = contacts;
        this.data = data;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
