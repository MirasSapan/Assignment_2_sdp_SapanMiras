package com.miras.factorydemo.abstractfactory;

public class AsianMainDish implements MainDish {

    private static final String CUISINE = "Asian";

    private final String name;

    public AsianMainDish(String name) {
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
