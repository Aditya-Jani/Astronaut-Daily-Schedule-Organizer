// Component Interface
interface Car {
    String assemble();
}

// Concrete Component
class BasicCar implements Car {
    public String assemble() {
        return "Basic Car";
    }
}

// Decorator
abstract class CarDecorator implements Car {
    protected Car decoratedCar;

    public CarDecorator(Car car) {
        this.decoratedCar = car;
    }

    public String assemble() {
        return decoratedCar.assemble();
    }
}

// Concrete Decorators
class GPSDecorator extends CarDecorator {
    public GPSDecorator(Car car) {
        super(car);
    }

    @Override
    public String assemble() {
        return super.assemble() + " + GPS";
    }
}

class SunroofDecorator extends CarDecorator {
    public SunroofDecorator(Car car) {
        super(car);
    }

    @Override
    public String assemble() {
        return super.assemble() + " + Sunroof";
    }
}

// Demo
public class DecoratorDemo {
    public static void main(String[] args) {
        Car basicCar = new BasicCar();
        Car luxuryCar = new SunroofDecorator(new GPSDecorator(basicCar));

        System.out.println(luxuryCar.assemble());  // Output: Basic Car + GPS + Sunroof
    }
}
