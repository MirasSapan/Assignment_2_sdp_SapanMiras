package com.miras.factorydemo.abstractfactory;

/**
 * Client.
 * Works only through the {@link CuisineFactory} interface and the
 * {@link MainDish}/{@link SideDish} abstractions - it never names a
 * concrete product or concrete factory class.
 */
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
