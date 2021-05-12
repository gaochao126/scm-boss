package core.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

public class CglibClazz {

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(CglibClazz.class);
        enhancer.setCallback((MethodInterceptor) (o, method, objects, methodProxy) -> {
            System.out.println("before method run...");
            Object result = methodProxy.invokeSuper(o, args);
            System.out.println("after method run...");
            return result;
        });

        CglibClazz clazz = (CglibClazz)enhancer.create();
        clazz.test();
    }


    public void test(){
        System.out.println("hello world");
    }
}
