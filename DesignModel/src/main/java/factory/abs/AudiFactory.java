package factory.abs;

import factory.Audi;
import factory.Car;
import factory.func.Factory;

public class AudiFactory{
    public Car getCar() {
        return new Audi();
    }
}
