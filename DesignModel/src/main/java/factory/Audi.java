package factory;

public class Audi implements Car {
    public String getName() {
        return this.getClass().getName();
    }
}
