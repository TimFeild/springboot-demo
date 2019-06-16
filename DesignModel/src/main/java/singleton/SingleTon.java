package singleton;
//懒汉式
//这种写法,安全高效
public class SingleTon {
    //私有的构造方法
    private SingleTon() {
    }
    //1.生命静态内部类
    //2.private 私有保证别人不能改
    //3.static 保证全局唯一
    private static class Lazyholder {
        private static final SingleTon Instance = new SingleTon();
    }
    //final 确保不会被重写
    public static final SingleTon getInstance(){
        return  Lazyholder.Instance;
    }
}
