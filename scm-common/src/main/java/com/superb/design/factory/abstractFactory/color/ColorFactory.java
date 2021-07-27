package com.superb.design.factory.abstractFactory.color;

import com.superb.design.factory.abstractFactory.AbstractFactory;
import com.superb.design.factory.abstractFactory.shape.Shape;

public class ColorFactory extends AbstractFactory {


    @Override
    public Color getColor(String type) {
        if (type.equalsIgnoreCase("red")) {
            return new Red();
        } else if (type.equalsIgnoreCase("yello")) {
            return new Yello();
        } else {
            System.out.println("type非法");
            return null;
        }
    }

    @Override
    public Shape getShape(String type) {

        return null;
    }
}
