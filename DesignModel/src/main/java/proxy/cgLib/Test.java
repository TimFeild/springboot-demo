package proxy.cgLib;

public class Test {
    public static void main(String[] args) {
        Man man = new Man("jack","man");
        ProxyMan proxyMan = new ProxyMan();
        Man newMan = (Man) proxyMan.getInstance(man.getClass());
        newMan.marry();
        Class clazz = newMan.getClass();
        Class classes = newMan.getClass().getSuperclass();
        System.out.println("helloworld");
    }
}
