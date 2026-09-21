package com.miras.factorydemo.factorymethod;

/**
 * Concrete Product #1.
 */
public class VeganMeal extends AbstractMeal {

    private static final String DESCRIPTION_TEMPLATE =
            "%s (vegan, %d kcal) - plant-based, no animal products";

    public VeganMeal(String name, int calories) {
        super(name, calories);
    }

    @Override
    public String getDescription() {
        return DESCRIPTION_TEMPLATE.formatted(getName(), getCalories());
    }
}
