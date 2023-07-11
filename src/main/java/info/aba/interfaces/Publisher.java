package info.aba.interfaces;

public interface Publisher {

    public void register(Subscriber subscriber);
    public void unregister(Subscriber subscriber);
    public void notifySubscribers();
    public Object getUpdate(Subscriber subscriber);
}
