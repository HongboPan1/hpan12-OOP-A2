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

    }

    public void partFourB() {

    }


    public void partFive() {

    }


    public void partSix() {

    }


    public void partSeven() {

    }
}
