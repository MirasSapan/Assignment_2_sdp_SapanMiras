package com.miras.factorydemo.factorymethod;

/**
 * Creator (Factory Method).
 *
 * Declares the factory method {@link #createMeal(String, int)} and, on top
 * of it, a template method {@link #prepareMeal(String, int)} that every
 * subclass gets for free: common steps (logging, packing) stay here once,
 * while only the actual product creation varies per subclass.
 *
 * Clean Code principle #2 - Small methods, each doing one thing:
 * prepareMeal() only orchestrates; it does not know how to build a meal.
 * createMeal() only builds; it does not know about logging or packing.
 */
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
