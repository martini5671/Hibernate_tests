package org.example.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "people")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String surname;

    // cascade allows to save on code and not persist everything
    // e.g you dont have to persist now manually both passport and person
    // persisting person with passport is enough
    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE},
    fetch = FetchType.EAGER) // eager vs lazy
    // optional = helps to specify if the relationship can have null in some key
    @JoinColumn(name = "passportID") // this defines name of the column with FK
    private Passport passport;

    // there is also this thing called: @SecondaryTable()
    // which is used to model non-entities e.g
    // person and personDetails

    public Person() {
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }
}
