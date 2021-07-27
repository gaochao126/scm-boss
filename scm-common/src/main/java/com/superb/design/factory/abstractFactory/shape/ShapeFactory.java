package com.superb.design.factory.abstractFactory.shape;

import com.superb.design.factory.abstractFactory.AbstractFactory;
import com.superb.design.factory.abstractFactory.color.Color;

public class ShapeFactory extends AbstractFactory {

    @Override
    public Color getColor(String type) {
        return null;
    }

    @Override
    public Shape getShape(String type) {
        if (type.equalsIgnoreCase("circle")) {
            return new Circle();
        } else if (type.equalsIgnoreCase("rectangle")) {
            return new Rectangle();
        } else {
            System.out.println("shape type 非法");
            return null;
        }
    }
}
