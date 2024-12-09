import java.io.*;
import java.util.*;
/**
 * The Ride class represents an amusement ride with a queue of visitors waiting to board,
 * a history of visitors who have ridden the attraction, and the ability to run the ride cycles.
 * It manages the addition and removal of visitors to the queue, keeps track of ride history,
 * and allows for exporting and importing ride history data from files.
 *
 * Author: hpan12
 */
public class Ride implements RideInterface {
    private String rideName;
    private int maxRiders;
    private Employee operator;
    private Queue<Visitor> visitorQueue = new LinkedList<>();
    private List<Visitor> rideHistory = new ArrayList<>();
    private int numOfCycles = 0;


    public Ride() {
    }


    public Ride(String rideName, int maxRiders, Employee operator) {
        this.rideName = rideName;
        this.maxRiders = maxRiders;
        this.operator = operator;
    }

    public String getRideName() {
        return rideName;
    }

    public void setRideName(String rideName) {
        this.rideName = rideName;
    }

    public int getMaxRiders() {
        return maxRiders;
    }

    public void setMaxRiders(int maxRiders) {
        this.maxRiders = maxRiders;
    }

    public Employee getOperator() {
        return operator;
    }

    public void setOperator(Employee operator) {
        this.operator = operator;
    }

    public int getNumOfCycles() {
        return numOfCycles;
    }

    public int getSizeOfVisitorQueue(){
        return visitorQueue.size();
    }

    @Override
    public void addVisitorToQueue(Visitor visitor) {
        visitorQueue.add(visitor);
        System.out.println(visitor.getName() + " is now in line for the " + rideName + " ride.");
    }


    @Override
    public void removeVisitorFromQueue() {
        Visitor removedVisitor = visitorQueue.poll(); // Remove the first visitor in the queue
        if (removedVisitor != null) {
            System.out.println(removedVisitor.getName() + " has exited the line for the " + rideName + " ride.");
        } else {
            System.out.println("The line for " + rideName + " is currently empty. No visitor to remove.");
        }
    }


    @Override
    public void printQueue() {
        if (visitorQueue.isEmpty()) {
            System.out.println("There are no visitors in the queue for " + rideName + " at the moment.");
        } else {
            System.out.println("The following visitors are currently in the queue for the " + rideName + " ride:");
            for (Visitor visitor : visitorQueue) {
                System.out.println("- " + visitor.getName() + ", Age: " + visitor.getAge());
            }
        }
    }


    @Override
    public void runOneCycle() {
        // Check if an operator is assigned
        if (operator == null) {
            System.out.println("Unable to run the ride '" + rideName + "' as no operator is assigned.");
            return;
        }

        // Check if the queue is empty
        if (visitorQueue.isEmpty()) {
            System.out.println("The queue for '" + rideName + "' is empty. Cannot run the ride.");
            return;
        }

        // Run the ride for one cycle
        int riders = 0;
        System.out.println("Starting one cycle for the ride '" + rideName + "'...");

        while (riders < maxRiders && !visitorQueue.isEmpty()) {
            Visitor visitor = visitorQueue.poll();
            if (visitor != null) {
                addVisitorToHistory(visitor);
                System.out.println(visitor.getName() + " is now enjoying the '" + rideName + "' ride.");
                riders++;
            }
        }

        // Increment the cycle counter
        numOfCycles++;
        System.out.println("Cycle completed. Total cycles run for '" + rideName + "': " + numOfCycles);
    }


    @Override
    public void addVisitorToHistory(Visitor visitor) {
        rideHistory.add(visitor);
        System.out.println("Visitor '" + visitor.getName() + "' has been successfully added to the ride history of '" + rideName + "'.");
    }


    @Override
    public boolean checkVisitorFromHistory(Visitor visitor) {
        boolean found = rideHistory.contains(visitor);
        String message = found
                ? visitor.getName() + " has already taken the ride '" + rideName + "'."
                : visitor.getName() + " has not taken the ride '" + rideName + "' yet.";
        System.out.println(message);
        return found;
    }


    @Override
    public int numberOfVisitors() {
        return rideHistory.size();
    }

    @Override
    public void printRideHistory() {
        if (rideHistory.isEmpty()) {
            System.out.println("No visitors have experienced the ride '" + rideName + "' so far.");
        } else {
            System.out.println("Ride history for '" + rideName + "':");
            for (Visitor visitor : rideHistory) {
                System.out.println(visitor.getName() + " | Age: " + visitor.getAge());
            }
        }
    }


    // Sort the ride history
    public void sortRideHistory() {
        Collections.sort(rideHistory, new VisitorComparator());
        System.out.println("Ride history has been sorted.");
    }

    //export the ride to file
    public void exportRideHistory(String filename) {
        // Create a FileWriter and BufferedWriter to write data to the file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            // Write the header row for clarity (optional)
            writer.write("Name,Age,Gender,Ticket ID,Membership ID\n");

            // Iterate over all visitors in the ride history
            for (Visitor visitor : rideHistory) {
                // Write each visitor's information to the file in CSV format
                writer.write(visitor.getName() + "," + visitor.getAge() + ","
                        + visitor.getGender() + "," + visitor.getTicket()
                        + "," + visitor.getVipId() + "\n");
            }
            System.out.println("Ride history has been successfully exported to: " + filename);
        } catch (IOException e) {
            System.err.println("An error occurred while exporting the ride history: " + e.getMessage());
        }
    }


    // Import Ride History from a file
    public void importRideHistory(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;

            // Skip the header row if it exists (optional)
            reader.readLine(); // Assuming the first line is the header

            // Read each line from the file
            while ((line = reader.readLine()) != null) {
                // Split the line into its components
                String[] data = line.split(",");

                if (data.length == 5) {  // Ensure there are 5 fields in the line
                    try {
                        // Extract the fields from the line
                        String name = data[0].trim();
                        int age = Integer.parseInt(data[1].trim());
                        String gender = data[2].trim();
                        String ticketId = data[3].trim();
                        int membershipId = Integer.parseInt(data[4].trim());

                        // Create a new Visitor object
                        Visitor visitor = new Visitor(name, age, gender, ticketId, membershipId);

                        // Add the visitor to the queue
                        visitorQueue.add(visitor);
                        System.out.println("Visitor " + visitor.getName() + " (Age: " + visitor.getAge() + ") has been successfully added to the ride history.");

                    } catch (NumberFormatException e) {
                        System.out.println("Error: Invalid number format in line: " + line);
                    } catch (Exception e) {
                        System.out.println("Error: Unable to process the line: " + line);
                    }
                } else {
                    System.out.println("Skipping invalid data (line does not contain 5 fields): " + line);
                }
            }

            System.out.println("The ride history has been successfully imported from file: " + filename);

        } catch (IOException e) {
            System.out.println("Failed to import ride history from " + filename + ": " + e.getMessage());
        }
    }


}
