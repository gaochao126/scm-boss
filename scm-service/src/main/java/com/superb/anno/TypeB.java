package com.superb.anno;

import org.springframework.stereotype.Component;

@Event(value = "B")
@Component
public class TypeB implements IAnno {
    @Override
    public String exe() {
        System.out.println("B....");
        return "B";
    }
}
