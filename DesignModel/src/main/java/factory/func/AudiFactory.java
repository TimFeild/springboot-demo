package factory.func;

import factory.Audi;
import factory.Car;

public class AudiFactory implements  Factory {
    public Car getCar() {
        return new Audi();
    }
}
