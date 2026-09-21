package com.miras.factorydemo.abstractfactory;


public final class CuisineFactoryProvider {

    private CuisineFactoryProvider() {
    }

    public static CuisineFactory factoryFor(CuisineType type) {
        return switch (type) {
            case ASIAN -> new AsianCuisineFactory();
            case MEDITERRANEAN -> new MediterraneanCuisineFactory();
        };
    }
}
