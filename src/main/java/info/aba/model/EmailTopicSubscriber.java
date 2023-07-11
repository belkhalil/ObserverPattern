package info.aba.model;

import info.aba.interfaces.Publisher;
import info.aba.interfaces.Subscriber;

public class EmailTopicSubscriber implements Subscriber {

    private String name;

    //reference to our publisher
    private Publisher publisherTopic;

    public EmailTopicSubscriber(String name) {
        this.name = name;
    }

    @Override
    public void update() {

        String msg = (String) publisherTopic.getUpdate(this);
        if (msg == null) {
            System.out.println(name + "No new message on this topic");
        } else {
            System.out.println(name = " Retrieving message " + msg);
        }
    }

    @Override
    public void setPublisher(Publisher publisher) {
        this.publisherTopic = publisher;
    }
}
