package com.miras.factorydemo.factorymethod;

/**
 * Concrete Product #2.
 */
public class KetoMeal extends AbstractMeal {

    private static final String DESCRIPTION_TEMPLATE =
            "%s (keto, %d kcal) - low-carb, high-fat";

    public KetoMeal(String name, int calories) {
        super(name, calories);
    }

    @Override
    public String getDescription() {
        return DESCRIPTION_TEMPLATE.formatted(getName(), getCalories());
    }
}
