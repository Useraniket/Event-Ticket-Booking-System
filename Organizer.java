package EventTicketBookingSystem;

public class Organizer extends User {
	public Organizer(String id, String name) {
		super(id, name);
	}

	private boolean active = true;

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public void showProfile() {
		System.out.println("Organizer ID:" + id + ",Name:" + name + ",active:" + active);
	}
}
