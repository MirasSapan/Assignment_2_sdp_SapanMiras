package com.miras.factorydemo.factorymethod;


public class VeganMealFactory extends MealFactory {

    @Override
    protected Meal createMeal(String name, int calories) {
        return new VeganMeal(name, calories);
    }
}
