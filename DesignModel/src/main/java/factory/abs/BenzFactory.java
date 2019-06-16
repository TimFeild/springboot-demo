package factory.abs;

import factory.Benz;
import factory.Car;
import factory.func.Factory;

public class BenzFactory{
    public Car getCar() {
        return new Benz();
    }
}
