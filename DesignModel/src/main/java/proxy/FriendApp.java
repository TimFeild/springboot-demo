package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class FriendApp implements InvocationHandler {
    private Person target;

    public Object getInstance(Person target) {
        this.target = target;
        Class clazz = target.getClass();
        return Proxy.newProxyInstance(clazz.getClassLoader(),clazz.getInterfaces(),this);
    }

    @Override
    public Person invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("打开探探");
        System.out.println("选择美女");
        method.invoke(target,args);
        System.out.println("爽不");
        return null;
    }
}
