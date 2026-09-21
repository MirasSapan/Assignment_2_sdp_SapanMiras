package com.miras.factorydemo.factorymethod;

/**
 * Concrete Creator #1.
 */
public class VeganMealFactory extends MealFactory {

    @Override
    protected Meal createMeal(String name, int calories) {
        return new VeganMeal(name, calories);
    }
}
