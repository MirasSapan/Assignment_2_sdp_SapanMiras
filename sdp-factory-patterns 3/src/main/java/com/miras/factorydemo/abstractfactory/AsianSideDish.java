package com.miras.factorydemo.abstractfactory;

public class AsianSideDish implements SideDish {

    private static final String CUISINE = "Asian";

    private final String name;

    public AsianSideDish(String name) {
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
