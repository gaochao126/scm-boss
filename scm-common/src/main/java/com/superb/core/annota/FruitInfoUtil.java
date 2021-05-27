package com.superb.core.annota;

import java.lang.reflect.Field;

public class FruitInfoUtil {

    public static void getFruitInfo(Class<?> clazz) {
        String provider = "供应商信息；";

        Field[] fields = clazz.getDeclaredFields();

        for (Field f : fields) {
            if (f.isAnnotationPresent(FruitProvider.class)) {
                FruitProvider p = f.getAnnotation(FruitProvider.class);
                provider = "供应商编号：" + p.id() + "；供应商名字：" + p.name() + "；供应商地址：" + p.address();
            }

            System.out.println(provider);
        }
    }
}
