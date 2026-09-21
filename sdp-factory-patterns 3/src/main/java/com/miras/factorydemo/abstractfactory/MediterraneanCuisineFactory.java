package com.miras.factorydemo.abstractfactory;


public class MediterraneanCuisineFactory implements CuisineFactory {

    @Override
    public MainDish createMainDish() {
        return new MediterraneanMainDish("Grilled Falafel Plate");
    }

    @Override
    public SideDish createSideDish() {
        return new MediterraneanSideDish("Greek Salad");
    }
}
