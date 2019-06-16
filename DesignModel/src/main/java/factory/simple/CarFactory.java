package factory.simple;

import factory.Audi;
import factory.Benz;
import factory.Car;

public class CarFactory {
    Car getCar(String carName) {
        if ("Audi".equals(carName)) {
            return new Audi();
        } else if ("Benz".equals(carName)) {
            return new Benz();
        } else {
            System.out.println("我们只是搬运工");
            return null;
        }

    }
}
