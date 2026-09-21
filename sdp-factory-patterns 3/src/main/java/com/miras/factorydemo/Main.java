package com.miras.factorydemo;

import com.miras.factorydemo.abstractfactory.CuisineFactory;
import com.miras.factorydemo.abstractfactory.CuisineFactoryProvider;
import com.miras.factorydemo.abstractfactory.CuisineType;
import com.miras.factorydemo.abstractfactory.MealKit;
import com.miras.factorydemo.abstractfactory.MealKitOrderService;
import com.miras.factorydemo.factorymethod.KetoMealFactory;
import com.miras.factorydemo.factorymethod.Meal;
import com.miras.factorydemo.factorymethod.MealFactory;
import com.miras.factorydemo.factorymethod.VeganMealFactory;

/**
 * Demo entry point exercising both patterns end to end.
 */
public final class Main {

    private Main() {
    }

    public static void main(String[] args) {
        System.out.println("=== Part A: Factory Method ===");
        runFactoryMethodDemo();

        System.out.println();
        System.out.println("=== Part B: Abstract Factory ===");
        runAbstractFactoryDemo();

        System.out.println();
        System.out.println("=== Validation checks ===");
        runValidationChecks();
    }

    private static void runFactoryMethodDemo() {
        MealFactory veganFactory = new VeganMealFactory();
        Meal veganMeal = veganFactory.prepareMeal("Buddha Bowl", 520);

        MealFactory ketoFactory = new KetoMealFactory();
        Meal ketoMeal = ketoFactory.prepareMeal("Salmon & Avocado Plate", 610);

        System.out.println("Created: " + veganMeal.getDescription());
        System.out.println("Created: " + ketoMeal.getDescription());
    }

    private static void runAbstractFactoryDemo() {
        CuisineFactory asianFactory = CuisineFactoryProvider.factoryFor(CuisineType.ASIAN);
        MealKit asianKit = new MealKitOrderService(asianFactory).order();
        System.out.println(asianKit);

        CuisineFactory medFactory = CuisineFactoryProvider.factoryFor(CuisineType.MEDITERRANEAN);
        MealKit medKit = new MealKitOrderService(medFactory).order();
        System.out.println(medKit);
    }

    private static void runValidationChecks() {
        try {
            new VeganMealFactory().prepareMeal("", -5);
        } catch (IllegalArgumentException e) {
            System.out.println("Rejected invalid meal as expected: " + e.getMessage());
        }
    }
}
