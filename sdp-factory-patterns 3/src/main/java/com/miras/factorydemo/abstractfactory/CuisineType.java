package com.miras.factorydemo.abstractfactory;

/**
 * Clean Code principle #3 - No magic strings:
 * callers used to select a family by typing "asian" / "mediterranean"
 * literals. A typo ("asain") would only surface at runtime as a wrong
 * or missing meal kit. This enum makes the set of valid families a
 * closed, compiler-checked set instead.
 */
public enum CuisineType {
    ASIAN,
    MEDITERRANEAN
}
