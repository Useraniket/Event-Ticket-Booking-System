package EventTicketBookingSystem;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        EventBookingSystem system = new EventBookingSystem();
        system.loadEvents("events.dat");

        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n1. Register Attendee\n2. Add Event\n3. Book Ticket\n4. Show Events\n5. Save & Exit");
            choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    String id = sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    system.registerUser(new Attendee(id, name));
                    break;
                case 2:
                    System.out.print("Enter Event Title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter Tickets: ");
                    int tickets = sc.nextInt();
                    sc.nextLine();
                    system.addEvent(new Event(title, tickets));
                    break;
                case 3:
                    System.out.print("Attendee ID: ");
                    String attId = sc.nextLine();
                    System.out.print("Enter Event Title to Book: ");
                    String evt = sc.nextLine();
                    Attendee att = system.getAttendees().stream()
                        .filter(a -> a.id.equals(attId))
                        .findFirst()
                        .orElse(null);
                    if (att != null) {
                        try {
                            system.bookTicket(att, evt);
                        } catch (InvalidBookingException e) {
                            System.out.println(e.getMessage());
                        }
                    } else {
                        System.out.println("Attendee not found.");
                    }
                    break;
                case 4:
                    system.showEvents();
                    break;
                case 5:
                    system.saveEvents("events.dat");
                    System.out.println("Saved. Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 5);

        sc.close();
    }
}
