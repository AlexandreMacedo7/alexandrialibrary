package com.alexandre.alexandrialibrary.model;

import com.alexandre.alexandrialibrary.util.enums.Genre;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String Author;
    @Column(name = "isbn", unique = true)
    private String ISBN;
    @Enumerated(EnumType.STRING)
    private Genre genre;
    private int numberOfPages;
    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private BookPublisher publisher;
    private LocalDate publicationDate;
    private int quantity;
    @OneToMany(mappedBy = "book")
    private List<BookLending> bookLendingList = new ArrayList<>();

    public Book() {
    }

    public Book(Long id, String title, String author, String ISBN, Genre genre, int numberOfPages, BookPublisher publisher, LocalDate publicationDate, int quantity) {
        this.id = id;
        this.title = title;
        Author = author;
        this.ISBN = ISBN;
        this.genre = genre;
        this.numberOfPages = numberOfPages;
        this.publisher = publisher;
        this.publicationDate = publicationDate;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public BookPublisher getPublisher() {
        return publisher;
    }

    public void setPublisher(BookPublisher publisher) {
        this.publisher = publisher;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void addLoan(BookLending bookLending){
        bookLendingList.add(bookLending);
    }
}
