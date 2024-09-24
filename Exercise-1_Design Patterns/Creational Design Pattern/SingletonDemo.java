// Singleton class
class QualityControlSystem {
    private static QualityControlSystem instance;

    private QualityControlSystem() {
        // private constructor
    }

    public static QualityControlSystem getInstance() {
        if (instance == null) {
            instance = new QualityControlSystem();
        }
        return instance;
    }

    public void inspectCar() {
        System.out.println("Inspecting car...");
    }
}

// Demo
public class SingletonDemo {
    public static void main(String[] args) {
        QualityControlSystem qc1 = QualityControlSystem.getInstance();
        QualityControlSystem qc2 = QualityControlSystem.getInstance();

        qc1.inspectCar();
        System.out.println(qc1 == qc2);  // Should print true, as both are same instance
    }
}
