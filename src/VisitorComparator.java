import java.util.Comparator;
/**
 * The VisitorComparator class is used to compare two Visitor objects based on their age.
 * If the visitors have the same age, the comparison is done based on their name in alphabetical order.
 * This comparator is useful for sorting collections of Visitor objects.
 *
 * Author: hapan12
 */
public class VisitorComparator implements Comparator<Visitor> {
    @Override
    public int compare(Visitor v1, Visitor v2) {
        // Compare by age, and if equal, compare by name
        int ageComparison = Integer.compare(v1.getAge(), v2.getAge());
        if (ageComparison != 0) {
            return ageComparison;
        }
        return v1.getName().compareTo(v2.getName());
    }
}
