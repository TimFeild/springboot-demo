package factory.simple;

public class Test {
    public static void main(String[] args) {
        CarFactory factory = new CarFactory();
        System.out.println(factory.getCar("Benz").getName());
    }
}
