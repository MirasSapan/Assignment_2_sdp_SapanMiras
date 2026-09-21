package com.miras.factorydemo.factorymethod;

public abstract class MealFactory {

    protected abstract Meal createMeal(String name, int calories);

    public final Meal prepareMeal(String name, int calories) {
        Meal meal = createMeal(name, calories);
        packMeal(meal);
        return meal;
    }

    private void packMeal(Meal meal) {
        System.out.println("Packing: " + meal.getDescription());
    }
}
