/**
 * The Visitor class represents a visitor at the amusement park or ride. It extends the Person class,
 * adding additional attributes such as ticket ID and membership ID to track each visitor's details.
 * This class provides constructors and getter/setter methods to manage these attributes.
 *
 * Author: hpan12
 */
public class Visitor extends Person {
    private String ticket;
    private int vipId;

    public Visitor() {
    }

    public Visitor(String name, int age, String gender, String ticketId, int vipId) {
        super(name, age, gender);
        this.ticket = ticketId;
        this.vipId = vipId;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public int getVipId() {
        return vipId;
    }

    public void setVipId(int vipId) {
        this.vipId = vipId;
    }
}
