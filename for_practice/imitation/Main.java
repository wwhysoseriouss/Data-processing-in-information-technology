package for_practice.imitation;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Наслiдування ===");
            Vehicle vehicle = new Vehicle("Toyota", "Corolla");
            vehicle.displayInfo();

         Motorcycle motorcycle = new Motorcycle("Honda", "CBR600", 600);
            motorcycle.displayInfo();

            Employee employee = new Employee("Alice", "Developer");
            employee.displayInfo();

            Manager manager = new Manager("Bob", "Team Lead", 5);
            manager.displayInfo();
            System.out.println();
    }
    
}
