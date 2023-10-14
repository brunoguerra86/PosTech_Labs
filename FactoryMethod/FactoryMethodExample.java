// Classe base para os produtos (veículos)
abstract class Vehicle {
    abstract void start();
    abstract void stop();
}

// Classes concretas dos produtos (carro e bicicleta)
class Car extends Vehicle {
    void start() {
        System.out.println("Car is starting.");
    }

    void stop() {
        System.out.println("Car is stopping.");
    }
}

class Bicycle extends Vehicle {
    void start() {
        System.out.println("Bicycle is starting.");
    }

    void stop() {
        System.out.println("Bicycle is stopping.");
    }
}

// Interface do Factory Method
interface VehicleFactory {
    Vehicle createVehicle();
}

// Implementações concretas do Factory Method
class CarFactory implements VehicleFactory {
    public Vehicle createVehicle() {
        return new Car();
    }
}

class BicycleFactory implements VehicleFactory {
    public Vehicle createVehicle() {
        return new Bicycle();
    }
}

// Exemplo de uso
public class FactoryMethodExample {
    public static void main(String[] args) {
        VehicleFactory carFactory = new CarFactory();
        Vehicle car = carFactory.createVehicle();
        car.start();
        car.stop();

        VehicleFactory bicycleFactory = new BicycleFactory();
        Vehicle bicycle = bicycleFactory.createVehicle();
        bicycle.start();
        bicycle.stop();
    }
}