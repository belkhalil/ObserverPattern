package info;

import info.aba.interfaces.Subscriber;
import info.aba.model.EmailTopic;
import info.aba.model.EmailTopicSubscriber;

public class Main {
    public static void main(String[] args) {

        /**
         *
         */
        EmailTopic emailTopic = new EmailTopic();

        //create Subscribers (Observers)
        Subscriber subscriber_1 = new EmailTopicSubscriber("firstSubscriber");
        Subscriber subscriber_2 = new EmailTopicSubscriber("secondSubscriber");
        Subscriber subscriber_3 = new EmailTopicSubscriber("thirdSubscriber");
        //Register them
        emailTopic.register(subscriber_1);
        emailTopic.register(subscriber_2);
        emailTopic.register(subscriber_3);

        //attaching subscribers to publisher   (or observer to subject)
        subscriber_1.setPublisher(emailTopic);
        subscriber_2.setPublisher(emailTopic);
        subscriber_3.setPublisher(emailTopic);

        // Check for updates
        subscriber_1.update();

        //Provider / Subject / broadcaster / publisher
        emailTopic.postMessage("Hello Subscribers");

    }
}