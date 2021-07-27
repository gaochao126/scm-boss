package com.superb.design.factory;

import com.superb.design.factory.abstractFactory.AbstractFactory;
import com.superb.design.factory.abstractFactory.FactoryProducer;
import com.superb.design.factory.ordinaryFactory.Shape;
import com.superb.design.factory.ordinaryFactory.ShapeFactory;


public class TestFactory {

    public static void main(String[] args) {

        ordinaryFactory();
    }


    public static void ordinaryFactory() {
        ShapeFactory shapeFactory = new ShapeFactory();
        Shape circle = shapeFactory.getShape("circle");
        circle.draw();
    }

    public static void abstractFactory() {
        AbstractFactory shape = FactoryProducer.getFactory("shape");
        com.superb.design.factory.abstractFactory.shape.Shape circle = shape.getShape("circle");
        circle.draw();

    }
}
