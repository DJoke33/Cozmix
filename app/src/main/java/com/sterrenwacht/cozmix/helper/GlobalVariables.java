package com.sterrenwacht.cozmix.helper;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

public class GlobalVariables extends Application {

    private List<Person> persons = new ArrayList<Person>() {{

    }};

    public List<Person> getPersons() {
        return persons;
    }

    public void addPerson(Person person) {
        this.persons.add(person);
    }

    public void deletePerson(int index) {
        persons.remove(index);
    }
}