package proxy.privateModel;

import proxy.Person;

public class TestProxyPrivate {
    public static void main(String[] args) {
        Person target = new Papp();
        Person proxyPerson =(Person) new PZhongjie().getInstance(target);
        proxyPerson.findLove();

    }
}
