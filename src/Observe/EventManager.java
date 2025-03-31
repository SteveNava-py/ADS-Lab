package Observe;

import java.io.File;
import java.util.*;


public class EventManager {
    private Map<String, List<EventListener>> listeners = new HashMap<>();

    /**
     * Constructor for Event Manager
     * @param operations
     */

    public EventManager(String... operations) {
        for(String operation : operations) {
            this.listeners.put(operation, new ArrayList<>());
        }
    }

    /**
     * Method to subscribe a listener to a specific event type
     * @param eventType
     * @param listener
     */

    public void subscribe(String eventType, EventListener listener) {
        List<EventListener> users = listeners.get(eventType);
        users.add(listener);
    }

    public void unsubscribe(String eventType,  EventListener listener) {
        List<EventListener> users = listeners.get(eventType);
        users.remove(listener);
    }

    /**
     * Method to notify all listeners to event type
     * @param eventType
     * @param file
     */

    public void notify(String eventType, File file) {
        List<EventListener> users = listeners.get(eventType);

        // iterate through the list of users and call the update method for each listener
        for(EventListener listener : users) {
            listener.update(eventType, file);
        }
    }
}
