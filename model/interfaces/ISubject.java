package model.interfaces;

public interface ISubject {
    void registerObserver(IObserver o);
    void notifyObservers();
}
