package com.sterrenwacht.cozmix.helper;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private double weight;

    public Person(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }
    public void setWeight(double weight) { this.weight = weight; }

    public String toString() {
        DecimalFormat df = new DecimalFormat("0.0");
        return ( this.name + ": " + df.format(this.weight) + " kg");
    }

    public static List<Person> planetaryConversion(List<Person> lsPersons, double factorWeight) {
        List<Person> lsPersonsPlanet = new ArrayList<>();

        for (Person p : lsPersons) {
            lsPersonsPlanet.add(new Person(
                    p.name,
                    p.weight * factorWeight
            ));
        }

        return lsPersonsPlanet;
    }
}
