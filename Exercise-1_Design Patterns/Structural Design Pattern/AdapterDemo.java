// Legacy System (Old Protocol)
class LegacyRobotSystem {
    public void moveOld() {
        System.out.println("Moving robot with legacy system.");
    }
}

// Target Interface (New Protocol)
interface NewRobotSystem {
    void move();
}

// Adapter
class RobotAdapter implements NewRobotSystem {
    private LegacyRobotSystem legacyRobot;

    public RobotAdapter(LegacyRobotSystem legacyRobot) {
        this.legacyRobot = legacyRobot;
    }

    @Override
    public void move() {
        legacyRobot.moveOld();
    }
}

// Demo
public class AdapterDemo {
    public static void main(String[] args) {
        LegacyRobotSystem oldRobot = new LegacyRobotSystem();
        NewRobotSystem adaptedRobot = new RobotAdapter(oldRobot);

        adaptedRobot.move();  // Using adapter to control legacy robot
    }
}
