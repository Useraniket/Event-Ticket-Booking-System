public class Main {
    public static void main(String[] args) {
        EventBookingSystem system = new EventBookingSystem();
        system.loadEvents();

        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n1. Register Attendee\n2. Add Event\n3. Book Ticket\n4. Show Events\n5. Save & Exit");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

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
                    system.addEvent(new Event(title, tickets));
                    break;
                case 3:
                    System.out.print("Attendee ID: ");
                    String attId = sc.nextLine();
                    System.out.print("Enter Event Title to Book: ");
                    String evt = sc.nextLine();
                    Attendee att = system.attendees.stream().filter(a -> a.id.equals(attId)).findFirst().orElse(null);
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
                    system.saveEvents();
                    System.out.println("Saved. Exiting...");
                    break;
            }
        } while (choice != 5);
    }
}
