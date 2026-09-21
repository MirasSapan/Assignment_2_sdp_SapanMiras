package com.miras.factorydemo.abstractfactory;


public class MealKitBuilder {

    private MainDish mainDish;
    private SideDish sideDish;

    public MealKitBuilder mainDish(MainDish mainDish) {
        this.mainDish = mainDish;
        return this;
    }

    public MealKitBuilder sideDish(SideDish sideDish) {
        this.sideDish = sideDish;
        return this;
    }

    public MealKit build() {
        if (mainDish == null || sideDish == null) {
            throw new IllegalStateException(
                    "A MealKit requires both a main dish and a side dish");
        }
        if (!mainDish.getCuisine().equals(sideDish.getCuisine())) {
            throw new IllegalStateException(
                    "Cuisine mismatch: main dish is " + mainDish.getCuisine()
                            + " but side dish is " + sideDish.getCuisine());
        }
        return new MealKit(mainDish, sideDish);
    }
}
