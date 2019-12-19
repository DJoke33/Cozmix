package com.sterrenwacht.cozmix;

import java.text.DecimalFormat;

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
}
