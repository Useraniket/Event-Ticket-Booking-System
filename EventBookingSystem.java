package EventTicketBookingSystem;
import java.io.*;
import java.util.*;

class EventBookingSystem {
    private List<Attendee> attendees;
    private List<Organizer> organizers;
    private List<Event> events;
    private List<Ticket> tickets;

    public EventBookingSystem() {
        attendees = new ArrayList<>();
        organizers = new ArrayList<>();
        events = new ArrayList<>();
        tickets = new ArrayList<>();
    }

    public void registerUser(User user) {
        if (user instanceof Attendee) {
            attendees.add((Attendee) user);
            System.out.println("Attendee " + user.getName() + " registered.");
        } else if (user instanceof Organizer) {
            organizers.add((Organizer) user);
            System.out.println("Organizer " + user.getName() + " registered.");
        } else {
            System.out.println("Unknown user type.");
        }
    }

    public void addEvent(Event event) {
        events.add(event);
        System.out.println("Event '" + event.getTitle() + "' added.");
    }

    public void bookTicket(Attendee attendee, String eventTitle) throws InvalidBookingException {
        for (Event event : events) {
            if (event.getTitle().equalsIgnoreCase(eventTitle)) {
                if (event.isAvailable()) {
                    Ticket ticket = new Ticket(attendee, event);
                    tickets.add(ticket);
                    event.setAvailableTickets(event.getAvailableTickets() - 1);
                    System.out.println("Ticket booked for " + attendee.getName() + " for event '" + event.getTitle() + "'.");
                    return;
                } else {
                    throw new InvalidBookingException("No tickets available for event '" + event.getTitle() + "'.");
                }
            }
        }
        throw new InvalidBookingException("Event '" + eventTitle + "' not found.");
    }

    public void showEvents() {
        if (events.isEmpty()) {
            System.out.println("No events available.");
            return;
        }
        System.out.println("Available Events:");
        for (Event event : events) {
            System.out.println("- " + event.getTitle() + " (" + event.getAvailableTickets() + " tickets available)");
        }
    }

    public void saveEvents(String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(events);
            System.out.println("Events saved to " + filename);
        } catch (IOException e) {
            System.out.println("Error saving events: " + e.getMessage());
        }
    }

    public void loadEvents(String filename) {
        File file = new File(filename);
        if (!file.exists()) {
            System.out.println("No saved events to load.");
            return;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            events = (List<Event>) ois.readObject();
            System.out.println("Events loaded from " + filename);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading events: " + e.getMessage());
        }
    }
}
