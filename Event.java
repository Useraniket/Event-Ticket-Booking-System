package eventTicketBooking;

public class Event {
	
	String title;
	int availableTickets;
	
	public Event(String title, int availableTickets) {
		this.title = title;
		this.availableTickets = availableTickets;
	}
	
	public boolean isAvailable() {
		return false;
	}
	
	public void setAvailableTickets(int isAvailable) {
		this.availableTickets=availableTickets;
	}

}
