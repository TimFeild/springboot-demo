package factory.abs;

import factory.Car;

public class DefaultFactory extends AbstractFactory {
    private AudiFactory defFactory = new AudiFactory();

    protected Car getCar() {
        return defFactory.getCar();
    }
}
