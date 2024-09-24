//Observer Pattern

import java.util.ArrayList;
import java.util.List;

// Observer Interface
interface Worker {
    void update(String message);
}

// Concrete Observer
class Mechanic implements Worker {
    private String name;

    public Mechanic(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + " received notification: " + message);
    }
}

// Subject Interface
interface ProductionLine {
    void register(Worker worker);
    void unregister(Worker worker);
    void notifyObservers(String message);
}

// Concrete Subject
class CarProductionLine implements ProductionLine {
    private List<Worker> workers = new ArrayList<>();

    @Override
    public void register(Worker worker) {
        workers.add(worker);
    }

    @Override
    public void unregister(Worker worker) {
        workers.remove(worker);
    }

    @Override
    public void notifyObservers(String message) {
        for (Worker worker : workers) {
            worker.update(message);
        }
    }
}

// Demo
public class ObserverDemo {
    public static void main(String[] args) {
        CarProductionLine productionLine = new CarProductionLine();
        Worker mechanic1 = new Mechanic("Mechanic A");
        Worker mechanic2 = new Mechanic("Mechanic B");

        productionLine.register(mechanic1);
        productionLine.register(mechanic2);

        productionLine.notifyObservers("Engine assembly has paused!");
        
        productionLine.unregister(mechanic1);

        productionLine.notifyObservers("Engine assembly resumed.");
    }
}
