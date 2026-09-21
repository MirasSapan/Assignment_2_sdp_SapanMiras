package com.miras.factorydemo.abstractfactory;


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
