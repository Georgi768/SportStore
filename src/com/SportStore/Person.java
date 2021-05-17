package com.SportStore;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

abstract public class Person {
    private int id;
    private String name;
    private LocalDate dateOfBirth;
    private SportStore sportStore;

    public Person(int id, String name, String dateOfBirth, SportStore sportStore) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = this.parseDate(dateOfBirth);
        this.sportStore = sportStore;
    }

    public int getId() {
        return this.id;
    }

    public SportStore getSportStore() {
        return this.sportStore;
    }

    public void setSportStore(SportStore sportStore) {
        this.sportStore = sportStore;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    protected LocalDate parseDate(String date) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return LocalDate.parse(date, dateFormatter);
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return this.dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
