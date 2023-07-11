package info.aba.model;

import info.aba.interfaces.Publisher;
import info.aba.interfaces.Subscriber;

import java.util.ArrayList;
import java.util.List;

public class EmailTopic implements Publisher {

    private List<Subscriber> subscribers;
    private String message;

    public EmailTopic() {
        this.subscribers = new ArrayList<>();
    }

    @Override
    public void register(Subscriber subscriber) {
        if (subscriber == null)
            throw new NullPointerException("Null Subscriber");
        if (!subscribers.contains(subscriber))
            subscribers.add(subscriber);

    }

    @Override
    public void unregister(Subscriber subscriber) {
        this.subscribers.remove(subscriber);
    }

    @Override
    public void notifySubscribers() {
        for (Subscriber subscriber : subscribers) {
            subscriber.update();
        }
    }

    @Override
    public Object getUpdate(Subscriber subscriber) {
        return message;
    }

    public void postMessage(String message) {
        System.out.println("Message Posted to my topic : " + message);
        this.message = message;
        notifySubscribers();
    }
}
