package factory.abs;

public class Test
{
    public static void main(String[] args) {
        AbstractFactory factory = new DefaultFactory();
        System.out.println(factory.getCar());
        System.out.println(factory.getCar("Benz"));
    }
}
