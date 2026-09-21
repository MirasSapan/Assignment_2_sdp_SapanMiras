package com.miras.factorydemo.abstractfactory;

/**
 * An immutable, already-validated bundle of a main dish and a side dish
 * belonging to the same cuisine family. Only {@link MealKitBuilder} can
 * create one.
 */
public final class MealKit {

    private final MainDish mainDish;
    private final SideDish sideDish;

    MealKit(MainDish mainDish, SideDish sideDish) {
        this.mainDish = mainDish;
        this.sideDish = sideDish;
    }

    public MainDish getMainDish() {
        return mainDish;
    }

    public SideDish getSideDish() {
        return sideDish;
    }

    @Override
    public String toString() {
        return "MealKit[" + mainDish.getCuisine() + "]: "
                + mainDish.getName() + " + " + sideDish.getName();
    }
}
