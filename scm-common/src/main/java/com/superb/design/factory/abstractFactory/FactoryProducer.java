package com.superb.design.factory.abstractFactory;

import com.superb.design.factory.abstractFactory.color.ColorFactory;
import com.superb.design.factory.abstractFactory.shape.ShapeFactory;

public class FactoryProducer {

    public static AbstractFactory getFactory(String choice) {
        if (choice.equalsIgnoreCase("SHAPE")) {
            return new ShapeFactory();
        } else if (choice.equalsIgnoreCase("COLOR")) {
            return new ColorFactory();
        }
        return null;
    }
}
