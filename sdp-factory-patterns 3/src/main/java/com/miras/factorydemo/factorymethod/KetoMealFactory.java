package com.miras.factorydemo.factorymethod;

/**
 * Concrete Creator #2.
 */
public class KetoMealFactory extends MealFactory {

    @Override
    protected Meal createMeal(String name, int calories) {
        return new KetoMeal(name, calories);
    }
}
