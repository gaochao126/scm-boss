package com.superb.core.InnerClazz;

/**
 * 静态内部类，静态static关键词修饰
 */
public class OutClazz {

    private String id;

    private String name;

    private InnerClazz innerClazz;

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

    public InnerClazz getInnerClazz() {
        return innerClazz;
    }

    public void setInnerClazz(InnerClazz innerClazz) {
        this.innerClazz = innerClazz;
    }

    public static class InnerClazz {
        private String no;

        private String address;

        public String getNo() {
            return no;
        }

        public void setNo(String no) {
            this.no = no;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }
    }
}
