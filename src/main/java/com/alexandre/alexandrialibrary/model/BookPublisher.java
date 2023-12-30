package com.alexandre.alexandrialibrary.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "books_publishers")
public class BookPublisher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @Column(name = "name", unique = true)
    private String name;
    @OneToMany(mappedBy = "publisher", cascade = CascadeType.ALL)
    private List<Book> bookList;

    public BookPublisher() {
    }

    public BookPublisher(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
