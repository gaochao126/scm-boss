package core.InnerClazz;

        import com.alibaba.fastjson.JSONObject;

public class Main {

    public static void main(String[] args) {
        // 静态内部类
        OutClazz outClazz = new OutClazz();

        OutClazz.InnerClazz innerClazz = new OutClazz.InnerClazz();
        innerClazz.setAddress("重庆渝北区");
        innerClazz.setNo("100000");

        outClazz.setId("101");
        outClazz.setInnerClazz(innerClazz);
        outClazz.setName("测试静态内部类");

        System.out.println(JSONObject.toJSON(outClazz));


        // 成员内部类
        FieldInnerClazz fieldInnerClazz = new FieldInnerClazz();
        fieldInnerClazz.setId("10000");
        fieldInnerClazz.setName("成员内部类测试");
        FieldInnerClazz.FieldClazz fieldClazz = fieldInnerClazz.new FieldClazz();
        fieldClazz.print();


    }
}
