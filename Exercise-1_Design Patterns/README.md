# Brief Explanation about the implementation 

## 1. Behavioral Design Patterns

### a. **Observer Pattern** - Car Production Line Notification System
- **Context**: Workers and machines on the production line need to be notified of changes like halts or updates.
- **Implementation**: 
  - `Worker` interface defines the `update()` method.
  - `Mechanic` implements `Worker` to receive notifications.
  - `CarProductionLine` is the subject that registers, unregisters, and notifies workers.

### b. **Command Pattern** - Car Assembly Task Automation Console
- **Context**: Automate tasks like engine installation or car painting.
- **Implementation**:
  - `AssemblyTask` interface defines `execute()` and `undo()` methods.
  - `InstallEngineCommand` and `PaintCarCommand` are concrete commands.
  - `AssemblyConsole` is the invoker that executes or undoes tasks.

## 2. Creational Design Patterns

### a. **Factory Pattern** - Car Parts Factory
- **Context**: Dynamic creation of car parts (e.g., engines, tires).
- **Implementation**:
  - `CarPart` interface defines the `assemble()` method.
  - `Engine` and `Tires` are concrete products.
  - `CarPartFactory` returns appropriate car part based on the type requested.

### b. **Singleton Pattern** - Centralized Quality Control System
- **Context**: A single instance of the quality control system monitors the cars.
- **Implementation**:
  - `QualityControlSystem` has a private constructor and static method `getInstance()` to ensure only one instance is created.

## 3. Structural Design Patterns

### a. **Adapter Pattern** - Legacy Robot System with Modern Software
- **Context**: Integrating old robotic systems with modern control software.
- **Implementation**:
  - `LegacyRobotSystem` defines old protocols.
  - `NewRobotSystem` defines new protocols.
  - `RobotAdapter` adapts old systems to work with the new interface.

### b. **Decorator Pattern** - Car Customization System
- **Context**: Add optional features (e.g., GPS, sunroof) to a basic car model.
- **Implementation**:
  - `Car` interface defines the `assemble()` method.
  - `BasicCar` is the base model.
  - `GPSDecorator` and `SunroofDecorator` are concrete decorators adding features to the car.
