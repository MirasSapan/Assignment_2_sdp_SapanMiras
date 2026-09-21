package com.miras.factorydemo.abstractfactory;

/**
 * The one place in the whole application allowed to know about concrete
 * factory classes. Everything downstream (the client, the builder, the
 * products) only ever sees the {@link CuisineFactory} abstraction.
 */
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
