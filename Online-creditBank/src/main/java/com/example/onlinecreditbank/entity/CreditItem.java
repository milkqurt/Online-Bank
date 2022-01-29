package com.example.onlinecreditbank.entity;

import javax.persistence.*;

@Entity
@Table(name ="credit_items")
public class CreditItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String usernameC;
    @Column(nullable = false)
    private String date;
    @Column(nullable = false)
    private String company;
    @Column(nullable = false)
    private int salary;
    @Column(nullable = false)
    private int credit;
    @Column(nullable = false)
    private String dateCredit;
    @ManyToOne
    private User user;

    public CreditItem() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsernameC() {
        return usernameC;
    }

    public void setUsernameC(String usernameC) {
        this.usernameC = usernameC;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public String getDateCredit() {
        return dateCredit;
    }

    public void setDateCredit(String dateCredit) {
        this.dateCredit = dateCredit;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
