package com.miras.factorydemo.abstractfactory;

public class MediterraneanSideDish implements SideDish {

    private static final String CUISINE = "Mediterranean";

    private final String name;

    public MediterraneanSideDish(String name) {
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
