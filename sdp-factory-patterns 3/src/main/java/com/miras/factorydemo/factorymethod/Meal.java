package com.miras.factorydemo.factorymethod;

/**
 * Product interface (Factory Method).
 * Declares the common contract every meal must satisfy, regardless of
 * which diet-specific concrete product created it.
 */
public interface Meal {

    String getName();

    int getCalories();

    String getDescription();
}
