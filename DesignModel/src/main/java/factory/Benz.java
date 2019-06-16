package factory;

public class Benz implements Car {
    public String getName() {
        return this.getClass().getName();
    }
}
