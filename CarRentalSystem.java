import java.util.ArrayList;
import java.util.List;

// my first class here is the Car class and it represents a car that can be rented or returned.
class Car {
    //declaring attributes
    private String licensePlate;
    private String model;
    private boolean isRented;

    // a constructor that initializes a car with a given license plate and model.
    public Car(String licensePlate, String model) {
        this.licensePlate = licensePlate;
        this.model = model;
        this.isRented = false;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public String getModel() {
        return model;
    }

    public boolean isRented() {
        return isRented;
    }

    public void rentCar() {
        this.isRented = true;
    }

    public void returnCar() {
        this.isRented = false;
    }
}

//  the customer class represents customers renting cars.
class Customer {
    private String name;
    private String customerId;

    // a constructor that initializes a customer with a name and an ID.
    public Customer(String name, String customerId) {
        this.name = name;
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public String getCustomerId() {
        return customerId;
    }
}

// this class manages cars and customers, handling rentals and returns.
class RentalAgency {
    private List<Car> cars;
    private List<Customer> customers;

    //a constructor that initializes  empty lists of cars and customers
    public RentalAgency() {
        this.cars = new ArrayList<>();
        this.customers = new ArrayList<>();
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public Car rentCar(String licensePlate, String customerId) {
        for (Car car : cars) {
            if (car.getLicensePlate().equals(licensePlate) && !car.isRented()) {
                car.rentCar();
                System.out.println("Car rented to customer " + customerId);
                return car;
            }
        }
        System.out.println("Car not available for rent.");
        return null;
    }

    public void returnCar(String licensePlate) {
        for (Car car : cars) {
            if (car.getLicensePlate().equals(licensePlate) && car.isRented()) {
                car.returnCar();
                System.out.println("Car returned successfully.");
                return;
            }
        }
        System.out.println("Car not found or not rented.");
    }
}

//The Main Class runs the system and demonstrates renting and returning a car.
public class CarRentalSystem {
    public static void main(String[] args) {
        //create a rental agency system
        RentalAgency agency = new RentalAgency();

        //add cars to the system
        Car car1 = new Car("KCB", "Toyota Fortuner");
        Car car2 = new Car("KDH", "Subaru Forester");

        agency.addCar(car1);
        agency.addCar(car2);

        //adds customers to the system
        Customer customer1 = new Customer("Mwathi Don", "C001");
        Customer customer2 = new Customer("Kamau Lance", "C002");

        agency.addCustomer(customer1);
        agency.addCustomer(customer2);

        agency.rentCar("KCB", "C001");
        agency.returnCar("KCB");
    }
}
