package factory.func;

import factory.Benz;
import factory.Car;

public class BenzFactory implements Factory {
    public Car getCar() {
        return new Benz();
    }
}
