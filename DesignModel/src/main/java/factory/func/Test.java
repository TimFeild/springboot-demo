package factory.func;

public class Test {
    public static void main(String[] args) {
        Factory factory = new AudiFactory();
        System.out.println(factory.getCar().getName());
    }
}
