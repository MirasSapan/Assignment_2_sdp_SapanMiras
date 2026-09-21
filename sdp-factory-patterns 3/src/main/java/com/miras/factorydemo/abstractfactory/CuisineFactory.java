package com.miras.factorydemo.abstractfactory;

/**
 * Abstract Factory.
 * Declares one creation method per product type in the family, so any
 * concrete factory is guaranteed to produce a full, mutually-consistent
 * set of dishes.
 */
public interface CuisineFactory {

    MainDish createMainDish();

    SideDish createSideDish();
}
