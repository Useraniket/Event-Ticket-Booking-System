package eventTicketBooking;

public class Ticket {
	
	Attendee attendee;
	Event event;
	String status;
	
	public Ticket(Attendee attendee, Event event, String status) {
		this.attendee = attendee;
		this.event = event;
		this.status = "Booked";
	}
	
	public void cancel() {
		status="Cancelled";
	}
	
	public String getStatus() {
		return status;
	}
	
	public String ticketDetails() {
		return "Attendee:" + attendee +", event:"+event+", status:"+status;
	}

}
