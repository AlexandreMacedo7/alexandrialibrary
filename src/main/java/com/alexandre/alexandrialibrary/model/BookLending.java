package com.alexandre.alexandrialibrary.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class BookLending {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long idUser;
    private Long idBook;
    private LocalDateTime dateOfWithdrawal;
    private LocalDate returnDate;

    public BookLending(Long idUser, Long idBook, LocalDateTime dateOfWithdrawal, LocalDate returnDate) {
        this.idUser = idUser;
        this.idBook = idBook;
        this.dateOfWithdrawal = dateOfWithdrawal;
        this.returnDate = returnDate;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public Long getIdBook() {
        return idBook;
    }

    public void setIdBook(Long idBook) {
        this.idBook = idBook;
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
}
