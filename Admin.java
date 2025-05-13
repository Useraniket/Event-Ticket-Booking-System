package EventTicketBookingSystem;
import java.util.List;
import java.util.Iterator;
import java.lang.reflect.Method;

class Admin extends User {

    public Admin(String id, String name) {
        super(id, name);
    }

    @Override
    public void showProfile() {
        System.out.println("Admin Profile:");
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
    }

    public void removeEvent(List<Event> events, String title) {
        Iterator<Event> iterator = events.iterator();
        while (iterator.hasNext()) {
            Event event = iterator.next();
            try {
                Method getTitleMethod = Event.class.getMethod("getTitle");
                String eventTitle = (String) getTitleMethod.invoke(event);
                if (eventTitle.equals(title)) {
                    iterator.remove();
                    System.out.println("Event '" + title + "' removed successfully.");
                    return;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("Event '" + title + "' not found.");
    }
}
