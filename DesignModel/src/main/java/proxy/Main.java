package proxy;

import sun.misc.ProxyGenerator;

import java.io.InputStream;
import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) {
        Tianye tianye = new Tianye("TimFeild","男");
        Person person = (Person) new FriendApp().getInstance(tianye);
        person.findLove();
        byte [] b = ProxyGenerator.generateProxyClass("$Proxy0",new Class[]{person.getClass()});
        String str = new String(b);
        System.out.println(str);

//
//
//        byte[] b= ProxyGenerator.generateProxyClass("$Proxy0",new Class[]{Tianye.class});
//        InputStream
    }
}
