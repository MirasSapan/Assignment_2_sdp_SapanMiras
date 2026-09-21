package com.miras.factorydemo.abstractfactory;

public class MediterraneanMainDish implements MainDish {

    private static final String CUISINE = "Mediterranean";

    private final String name;

    public MediterraneanMainDish(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getCuisine() {
        return CUISINE;
    }
}
