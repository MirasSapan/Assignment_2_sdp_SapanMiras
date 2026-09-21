package com.miras.factorydemo.abstractfactory;

public class MealKitOrderService {

    private final CuisineFactory cuisineFactory;

    public MealKitOrderService(CuisineFactory cuisineFactory) {
        this.cuisineFactory = cuisineFactory;
    }

    public MealKit order() {
        MainDish mainDish = cuisineFactory.createMainDish();
        SideDish sideDish = cuisineFactory.createSideDish();

        return new MealKitBuilder()
                .mainDish(mainDish)
                .sideDish(sideDish)
                .build();
    }
}
