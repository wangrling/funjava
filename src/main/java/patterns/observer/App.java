package patterns.observer;

/**
 *
 * The Observer pattern is a software design pattern in which an object, called the subject,
 * maintains a list of its dependents, called observers, and notifies them automatically of any
 * state changes, usually by calling one of their methods. It is mainly used to implement
 * distributed event handling systems. The Observer pattern is also a key part in the familiar
 * model–view–controller (MVC) architectural pattern. The Observer pattern is implemented in
 * numerous programming libraries and systems, including almost all GUI toolkits.
 * <p>
 * In this example {@link Weather} has a state that can be observed. The {@link OrcsObserver} and
 * {@link HobbitsObserver} register as observers and receive notifications when the {@link Weather} changes.
 *
 */

public class App {

    public static void main(String[] args) {
        Weather weather = new Weather();

        weather.addObserver(new OrcsObserver());
        weather.addObserver(new HobbitsObserver());

        weather.timePasses();
        System.out.println();
        weather.timePasses();
        System.out.println();
        weather.timePasses();
        System.out.println();
    }
}
