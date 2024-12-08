import java.util.List;
/**
 * The RideInterface defines the essential operations for managing a ride,
 * including adding/removing visitors from the queue, running a ride cycle,
 * tracking ride history, and checking the status of visitors. Any class implementing
 * this interface is expected to provide concrete implementations of these methods.
 *
 * Author: hpan12
 */
public interface RideInterface {
    void addVisitorToQueue(Visitor visitor);

    void removeVisitorFromQueue();

    void printQueue();

    void runOneCycle();

    void addVisitorToHistory(Visitor visitor);

    boolean checkVisitorFromHistory(Visitor visitor);

    int numberOfVisitors();

    void printRideHistory();
}
