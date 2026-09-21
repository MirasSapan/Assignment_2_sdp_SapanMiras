package com.miras.factorydemo.factorymethod;


public abstract class AbstractMeal implements Meal {

    private final String name;
    private final int calories;

    protected AbstractMeal(String name, int calories) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Meal name must not be blank");
        }
        if (calories <= 0) {
            throw new IllegalArgumentException(
                    "Meal calories must be positive, got: " + calories);
        }
        this.name = name;
        this.calories = calories;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getCalories() {
        return calories;
    }
}
