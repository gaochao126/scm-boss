package com.superb.design.factory.ordinaryFactory;

/**
 * 普通工厂模式
 */
public class ShapeFactory {

    public Shape getShape(String type) {
        if (type.equalsIgnoreCase("circle")) {
            return new Circle();
        } else if (type.equalsIgnoreCase("rectangle")) {
            return new RectAngle();
        } else {
            System.out.println("类型不正确");
            return null;
        }
    }
}
