package EventTicketBookingSystem;

import java.io.Serializable;

public class Ticket implements Serializable {

    private Attendee attendee;
    private Event event;
    private String status;

    public Ticket(Attendee attendee, Event event) {
        this.attendee = attendee;
        this.event = event;
        this.status = "Booked";
    }

    public void cancel() {
        status = "Cancelled";
    }

    public String getStatus() {
        return status;
    }

    public String ticketDetails() {
        return "Attendee: " + attendee + ", Event: " + event + ", Status: " + status;
    }
}
