package proxy.privateModel;

import proxy.Person;

import java.lang.reflect.Method;

public class PZhongjie implements PInvocationHandler{

    private Person target;

    public Object getInstance(Person target){
        this.target = target;
        Class clazz = target.getClass();
        return PProxy.newProxyInstance(new PClassLoader(),clazz.getInterfaces(),this);
    }
    public Object invoke(Object object, Method method, Object[] args) {
        System.out.println("Hello Private jdkProxy");
        target.findLove();
        System.out.println("ending");
        return null;
    }
}
