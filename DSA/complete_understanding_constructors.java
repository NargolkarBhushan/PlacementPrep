// Base class
class Vehicle {
    String type;

    // Default constructor
    Vehicle() {
        System.out.println("Default Vehicle constructor called");
        type = "Unknown";
    }

    // Parameterized constructor
    Vehicle(String type) {
        System.out.println("Parameterized Vehicle constructor called");
        this.type = type;
    }

    void displayType() {
        System.out.println("Vehicle Type: " + type);
    }
}

// Subclass
class Car extends Vehicle {
    String brand;
    int modelYear;

    // No-arg constructor (uses this())
    Car() {
        this("DefaultBrand", 2000);
        System.out.println("No-arg Car constructor");
    }

    // Parameterized constructor (uses super())
    Car(String brand, int year) {
        super("Car");
        this.brand = brand;
        this.modelYear = year;
        System.out.println("Parameterized Car constructor");
    }

    // Copy constructor
    Car(Car other) {
        super(other.type); // copying parent field
        this.brand = other.brand;
        this.modelYear = other.modelYear;
        System.out.println("Copy Car constructor");
    }

    void showDetails() {
        System.out.println("Brand: " + brand);
        System.out.println("Model Year: " + modelYear);
        displayType(); // from Vehicle
    }
}

// Singleton class with private constructor
class Database {
    private static Database instance = null;

    private Database() {
        System.out.println("Database Connection Established");
    }

    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }
}

// Main class to test everything
public class ConstructorDemo {
    public static void main(String[] args) {

        System.out.println("\n1. Default Constructor:");
        Car c1 = new Car();
        c1.showDetails();

        System.out.println("\n2. Parameterized Constructor:");
        Car c2 = new Car("Hyundai", 2022);
        c2.showDetails();

        System.out.println("\n3. Copy Constructor:");
        Car c3 = new Car(c2);
        c3.showDetails();

        System.out.println("\n4. Singleton Class with Private Constructor:");
        Database db1 = Database.getInstance();
        Database db2 = Database.getInstance();
        System.out.println("Are both DB objects same? " + (db1 == db2)); // true
    }
}
