import java.util.List;
/**
 * This class represents the main implementation for the assignment. It simulates a ride system
 * with different parts showcasing functionality such as adding visitors to queues, managing ride history,
 * sorting visitors, and exporting/importing ride history to/from a CSV file.
 *
 * Author: hpan12
 */
public class AssignmentTwo {
    public static void main(String[] args) {
        AssignmentTwo assignment = new AssignmentTwo();
//        assignment.partThree();
//        assignment.partFourA();
//        assignment.partFourB();
//        assignment.partFive();
//        assignment.partSix();
        assignment.partSeven();
    }

    public void partThree() {

        Employee operator = new Employee("Alice", 35, "Female", "E101", "Ride Operator");

        Ride rollerCoaster = new Ride("Roller Coaster", 2, operator);

        Visitor visitor1 = new Visitor("Sophia", 27, "Female", "V201", 222);
        Visitor visitor2 = new Visitor("Ethan", 33, "Male", "V202", 223);
        Visitor visitor3 = new Visitor("Olivia", 29, "Female", "V203", 224);
        Visitor visitor4 = new Visitor("Liam", 26, "Male", "V204", 225);
        Visitor visitor5 = new Visitor("Ava", 31, "Female", "V205", 226);
        // Add visitors to the queue
        List<Visitor> visitors = List.of(visitor1, visitor2, visitor3, visitor4, visitor5);
        visitors.forEach(rollerCoaster::addVisitorToQueue);
        // Print the queue
        rollerCoaster.printQueue();
        rollerCoaster.removeVisitorFromQueue();
        rollerCoaster.printQueue();
    }

    public void partFourA() {
        // Create a new Employee who will operate the ride
        Employee operator = new Employee("John", 42, "Male", "E202", "Senior Operator");

        // Create a new Ride object
        Ride ferrisWheel = new Ride("Ferris Wheel", 3, operator);

        // Create 5 visitors with updated values
        Visitor visitor1 = new Visitor("Sophia", 27, "Female", "V201", 5678);
        Visitor visitor2 = new Visitor("Ethan", 33, "Male", "V202", 1234);
        Visitor visitor3 = new Visitor("Olivia", 29, "Female", "V203", 3456);
        Visitor visitor4 = new Visitor("Liam", 26, "Male", "V204", 7890);
        Visitor visitor5 = new Visitor("Ava", 31, "Female", "V205", 1357);

        // Add visitors to the ride history
        ferrisWheel.addVisitorToHistory(visitor1);
        ferrisWheel.addVisitorToHistory(visitor2);
        ferrisWheel.addVisitorToHistory(visitor3);
        ferrisWheel.addVisitorToHistory(visitor4);
        ferrisWheel.addVisitorToHistory(visitor5);

        // Check if a visitor is in the ride history
        ferrisWheel.checkVisitorFromHistory(visitor3);
        ferrisWheel.checkVisitorFromHistory(new Visitor("Demo", 30, "Male", "V206", 2468));

        // Print the number of visitors in the ride history with a more specific message
        System.out.println("The ride history for 'Ferris Wheel' currently holds a total of " + ferrisWheel.numberOfVisitors() + " visitors.");

        // Print all visitors in the ride history
        ferrisWheel.printRideHistory();
    }

    public void partFourB() {
        // Create a new Employee who will operate the ride
        Employee operator = new Employee("James", 45, "Male", "E103", "Senior Operator");

        // Create a new Ride object
        Ride thunderStorm = new Ride("Thunderstorm", 5, operator);

        // Create 6 visitors with updated values
        Visitor visitor1 = new Visitor("Henry", 27, "Male", "V201", 101);
        Visitor visitor2 = new Visitor("Grace", 23, "Female", "V202", 102);
        Visitor visitor3 = new Visitor("Mason", 29, "Male", "V203", 103);
        Visitor visitor4 = new Visitor("Ella", 26, "Female", "V204", 104);
        Visitor visitor5 = new Visitor("Lucas", 32, "Male", "V205", 105);
        Visitor visitor6 = new Visitor("Chloe", 28, "Female", "V206", 106);

        // Add visitors to the ride history
        thunderStorm.addVisitorToHistory(visitor1);
        thunderStorm.addVisitorToHistory(visitor2);
        thunderStorm.addVisitorToHistory(visitor3);
        thunderStorm.addVisitorToHistory(visitor4);
        thunderStorm.addVisitorToHistory(visitor5);
        thunderStorm.addVisitorToHistory(visitor6);

        // Print all visitors in the ride history before sorting
        System.out.println("Visitors before sorting by membership ID:");
        thunderStorm.printRideHistory();

        // Sort the ride history
        thunderStorm.sortRideHistory();

        // Print all visitors in the ride history after sorting
        System.out.println("Visitors after sorting by membership ID:");
        thunderStorm.printRideHistory();
    }


    public void partFive() {
        // Create a new Employee to operate the ride
        Employee operator = new Employee("Bob", 40, "Male", "E102", "Ride Operator");

        // Create a new Ride object with max riders as 2
        Ride rollerCoaster = new Ride("Roller Coaster", 2, operator);

        // Add at least 10 visitors to the queue
        Visitor visitor1 = new Visitor("Tom", 25, "Male", "V101", 000);
        Visitor visitor2 = new Visitor("Sherly", 22, "Female", "V102", 999);
        Visitor visitor3 = new Visitor("Ben", 28, "Male", "V103", 6777);
        Visitor visitor4 = new Visitor("David", 24, "Female", "V104", 868);
        Visitor visitor5 = new Visitor("Jack", 30, "Male", "V105", 456654);
        Visitor visitor6 = new Visitor("Lee", 30, "Female", "V106", 645645);
        Visitor visitor7 = new Visitor("Jack", 25, "Male", "V101", 654654);
        Visitor visitor8 = new Visitor("Sharon", 22, "Female", "V102", 65465463);
        Visitor visitor9 = new Visitor("Benny", 28, "Male", "V103", 635634);
        Visitor visitor10 = new Visitor("Leo", 24, "Female", "V104", 63463546);
        Visitor visitor11 = new Visitor("Nehemia", 30, "Male", "V105", 634565436);

        // Add visitors to the queue
        rollerCoaster.addVisitorToQueue(visitor1);
        rollerCoaster.addVisitorToQueue(visitor2);
        rollerCoaster.addVisitorToQueue(visitor3);
        rollerCoaster.addVisitorToQueue(visitor4);
        rollerCoaster.addVisitorToQueue(visitor5);
        rollerCoaster.addVisitorToQueue(visitor7);
        rollerCoaster.addVisitorToQueue(visitor8);
        rollerCoaster.addVisitorToQueue(visitor9);
        rollerCoaster.addVisitorToQueue(visitor10);
        rollerCoaster.addVisitorToQueue(visitor11);

        // Print all visitors in the queue before the cycle
        System.out.println("\nVisitors in queue before the cycle:");
        rollerCoaster.printQueue();

        // Run one cycle of the ride
        rollerCoaster.runOneCycle();

        // Print all visitors in the queue after the cycle
        System.out.println("\nVisitors in queue after the cycle:");
        rollerCoaster.printQueue();

        // Print the ride history
        System.out.println("\nRide history:");
        rollerCoaster.printRideHistory();
    }


    public void partSix() {
        // Create a new Employee to operate the ride
        Employee operator = new Employee("Amy", 23, "Female", "E34", "Ride Operator");

        // Create a new Ride object with max riders as 2
        Ride rollerCoaster = new Ride("Roller Coaster", 2, operator);

        // Create 5 visitors
        Visitor visitor1 = new Visitor("Jack", 25, "Male", "V101", 111);
        Visitor visitor2 = new Visitor("Sharon", 22, "Female", "V102", 222);
        Visitor visitor3 = new Visitor("Benny", 28, "Male", "V103", 333);
        Visitor visitor4 = new Visitor("Leo", 24, "Female", "V104", 444);
        Visitor visitor5 = new Visitor("Nehemia", 30, "Male", "V105", 555);

        // Add visitors to the ride history
        rollerCoaster.addVisitorToHistory(visitor1);
        rollerCoaster.addVisitorToHistory(visitor2);
        rollerCoaster.addVisitorToHistory(visitor3);
        rollerCoaster.addVisitorToHistory(visitor4);
        rollerCoaster.addVisitorToHistory(visitor5);

        // Export the ride history as a CSV file
        String filename = "history.csv";
        rollerCoaster.exportRideHistory(filename);
    }


    public void partSeven() {
        // Part 7 implementation
        Employee operator = new Employee("Bob", 35, "Female", "E342", "Ride Operator");
        Ride rollerCoaster = new Ride("Roller Coaster", 2, operator);
        rollerCoaster.importRideHistory("history.csv");
        System.out.println("The number of Visitors: "+rollerCoaster.getSizeOfVisitorQueue() +"\n");
        System.out.println("All Visitors:");
        rollerCoaster.printQueue();
    }
}
