
// QUESTION 1: Interface implementation (test -> Arithmetic -> ToTestInt)

interface TestInterface {
    void square(int num); // Member function declared [cite: 225]
}

class Arithmetic implements TestInterface {
    @Override
    public void square(int num) {
        System.out.println("The square of " + num + " is: " + (num * num));
    }
}


// QUESTION 2: Outer and Inner class handling with matching method names

class Outer {
    void display() {
        System.out.println("Display method inside the Outer class.");
    }

    class Inner {
        void display() {
            System.out.println("Display method inside the Inner class.");
        }
    }
}


// QUESTION 3: Point Class with overloaded constructors and chain setters

class Point {
    private int x, y; // private fields [cite: 229]

    public Point() {
        this.x = 0;
        this.y = 0;
    }

    public Point(int x, int y) { // Parameterized constructor [cite: 231]
        this.x = x;
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setXY(int x, int y) { // Combined setter [cite: 232]
        this.x = x;
        this.y = y;
    }

    public void showCoordinates() {
        System.out.println("Point coordinates are at position: (" + x + ", " + y + ")");
    }
}


// QUESTION 4: Box and Box3D Inheritance Hierarchy (Area & Volume)

class Box {
    protected double length;
    protected double breadth;

    public Box(double length, double breadth) { // Constructor [cite: 235]
        this.length = length;
        this.breadth = breadth;
    }

    public double findArea() {
        return length * breadth;
    }
}

class Box3d extends Box {
    private double height;

    public Box3d(double length, double breadth, double height) {
        super(length, breadth); // Pulling base variables [cite: 233]
        this.height = height;
    }

    public double findVolume() {
        return length * breadth * height; // Volume formula evaluation [cite: 236]
    }
}


// MAIN EXECUTION HUB: ToTestInt Class

public class ToTestInt {
    public static void main(String[] args) {
        System.out.println("--- Executing OOPS Week 4 Assignment --- \n");

        // 1. Testing Interface Implementation [cite: 226]
        Arithmetic calc = new Arithmetic();
        calc.square(9);
        System.out.println();

        // 2. Testing Inner Class Invocation [cite: 227]
        Outer outerObj = new Outer();
        outerObj.display();
        
        // Correct human technique to instantiate an inner class safely
        Outer.Inner innerObj = outerObj.new Inner();
        innerObj.display();
        System.out.println();

        // 3. Testing Point Coordinates state mutations
        Point spatialPoint = new Point(14, 28);
        spatialPoint.showCoordinates();
        spatialPoint.setXY(45, 90);
        spatialPoint.showCoordinates();
        System.out.println();

        // 4. Testing Box and Box3D inheritance computations [cite: 233, 236]
        Box3d shippingContainer = new Box3d(10.5, 5.0, 4.0);
        System.out.println("Base area of the container layout: " + shippingContainer.findArea());
        System.out.println("Total 3D volume capacity of the container: " + shippingContainer.findVolume());
    }
}
