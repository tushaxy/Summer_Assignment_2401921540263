import java.util.Random;

// 1. Base Abstract Class definition
abstract class Compartment {
    public abstract String notice();
}

// 2. Derived specific coach classes
class FirstClass extends Compartment {
    @Override
    public String notice() {
        return "[NOTICE]: First Class Section - Authorized ticket holders only.";
    }
}

class Ladies extends Compartment {
    @Override
    public String notice() {
        return "[NOTICE]: Ladies Compartment - Reserved exclusively for female commuters.";
    }
}

class General extends Compartment {
    @Override
    public String notice() {
        return "[NOTICE]: General Coach - Open seating for unreserved passengers.";
    }
}

class Luggage extends Compartment {
    @Override
    public String notice() {
        return "[NOTICE]: Luggage Van - Cargo and heavy transport item holding only.";
    }
}

// 3. Main execution class demonstrating polymorphism
public class TestCompartment {
    public static void main(String[] args) {
        // Declare an array of Compartment of size 10
        Compartment[] trainCoaches = new Compartment[10];
        Random randomGenerator = new Random();
        
        // Populate the array based on a randomly generated integer from 1 to 4
        for (int i = 0; i < trainCoaches.length; i++) {
            int randomType = randomGenerator.nextInt(4) + 1; 
            
            switch (randomType) {
                case 1:
                    trainCoaches[i] = new FirstClass();
                    break;
                case 2:
                    trainCoaches[i] = new Ladies();
                    break;
                case 3:
                    trainCoaches[i] = new General();
                    break;
                case 4:
                    trainCoaches[i] = new Luggage();
                    break;
            }
        }
        
        // Verify and display the polymorphic behavior of the notice method
        System.out.println("--- Generated Train Layout & Notices ---");
        for (int i = 0; i < trainCoaches.length; i++) {
            System.out.print("Coach #" + (i + 1) + " Type: " + trainCoaches[i].getClass().getSimpleName() + " -> ");
            System.out.println(trainCoaches[i].notice());
        }
    }
}
