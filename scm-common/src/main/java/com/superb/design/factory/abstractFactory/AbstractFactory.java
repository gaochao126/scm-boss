package com.superb.design.factory.abstractFactory;

import com.superb.design.factory.abstractFactory.color.Color;
import com.superb.design.factory.abstractFactory.shape.Shape;

public abstract class AbstractFactory {
    public abstract Color getColor(String type);

    public abstract Shape getShape(String type);
    public void a(){
        System.out.println(".....");
    }
}
