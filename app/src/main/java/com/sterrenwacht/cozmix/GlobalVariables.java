package com.sterrenwacht.cozmix;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

public class GlobalVariables extends Application {

    // TODO: remove test array of Persons
    private List<Person> persons = new ArrayList<Person>() {{
        add(new Person("Pa", 80));
        add(new Person("Ma", 70));
        add(new Person("Zoon", 60));
        add(new Person("Dochter", 50));
    }};

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    public void addPerson(Person person) {
        this.persons.add(person);
    }
}