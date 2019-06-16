package factory.abs;

import factory.Audi;
import factory.Benz;
import factory.Car;

public abstract class AbstractFactory {
   protected abstract Car getCar();
   protected  Car getCar(String carName){
       if ("Audi".equals(carName)) {
           return new AudiFactory().getCar();
       } else if ("Benz".equals(carName)) {
           return new BenzFactory().getCar();
       } else {
           System.out.println("我们只是搬运工");
           return null;
       }
   }
}
