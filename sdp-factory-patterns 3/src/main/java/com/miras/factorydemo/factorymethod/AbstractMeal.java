package com.miras.factorydemo.factorymethod;

/**
 * Shared base for all concrete meals.
 *
 * Clean Code principle #4 - Validated construction:
 * the constructor is the single choke point every subclass must pass
 * through, so an invalid meal can never exist. Failing fast here beats
 * discovering a blank name or a non-positive calorie count deep inside
 * some unrelated report-printing code later on.
 */
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
