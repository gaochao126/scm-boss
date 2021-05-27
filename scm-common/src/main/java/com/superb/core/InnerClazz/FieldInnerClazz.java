package com.superb.core.InnerClazz;

/**
 * 成员内部类
 */
public class FieldInnerClazz {

    private String id;

    private String name;

    public class FieldClazz {
        public FieldClazz(){

        }
        public void print() {
            System.out.println("这是成员内部类输出的字符串。。。id" + id);
            System.out.println("这是成员内部类输出的字符串。。。name" + name);
        }

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
