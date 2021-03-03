package com.superb.anno;

import org.springframework.stereotype.Component;


@Event(value = "A")
@Component
public class TypeA implements IAnno {

    @Override
    public String exe() {
        System.out.println("A.....");
        return "A";
    }
}
