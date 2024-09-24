// Product Interface
interface CarPart {
    void assemble();
}

// Concrete Products
class Engine implements CarPart {
    public void assemble() {
        System.out.println("Assembling engine.");
    }
}

class Tires implements CarPart {
    public void assemble() {
        System.out.println("Assembling tires.");
    }
}

// Factory
class CarPartFactory {
    public CarPart getCarPart(String type) {
        switch (type) {
            case "Engine":
                return new Engine();
            case "Tires":
                return new Tires();
            default:
                return null;
        }
    }
}

// Demo
public class FactoryDemo {
    public static void main(String[] args) {
        CarPartFactory factory = new CarPartFactory();

        CarPart engine = factory.getCarPart("Engine");
        engine.assemble();  // Assembling engine

        CarPart tires = factory.getCarPart("Tires");
        tires.assemble();  // Assembling tires
    }
}
