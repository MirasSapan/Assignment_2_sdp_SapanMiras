package com.miras.factorydemo.abstractfactory;

public class AsianCuisineFactory implements CuisineFactory {

    @Override
    public MainDish createMainDish() {
        return new AsianMainDish("Teriyaki Chicken Rice Bowl");
    }

    @Override
    public SideDish createSideDish() {
        return new AsianSideDish("Miso Soup");
    }
}
