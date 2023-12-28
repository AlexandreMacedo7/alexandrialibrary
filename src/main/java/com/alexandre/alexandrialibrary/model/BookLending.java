package com.alexandre.alexandrialibrary.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class BookLending {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;
    private LocalDateTime dateOfWithdrawal;
    private LocalDate returnDate;
    private LocalDate actualReturnDate;
    private Boolean returned;

    public BookLending(User user, Book book, LocalDateTime dateOfWithdrawal, LocalDate returnDate, LocalDate actualReturnDate) {
        this.user = user;
        this.book = book;
        this.dateOfWithdrawal = dateOfWithdrawal;
        this.returnDate = returnDate;
        this.actualReturnDate = actualReturnDate;
    }

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public LocalDateTime getDateOfWithdrawal() {
        return dateOfWithdrawal;
    }

    public void setDateOfWithdrawal(LocalDateTime dateOfWithdrawal) {
        this.dateOfWithdrawal = dateOfWithdrawal;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public LocalDate getActualReturnDate() {
        return actualReturnDate;
    }

    public void setActualReturnDate(LocalDate actualReturnDate) {
        this.actualReturnDate = actualReturnDate;
    }

    public Boolean getReturned() {
        return returned;
    }

    public void setReturned(Boolean returned) {
        this.returned = returned;
    }
}
