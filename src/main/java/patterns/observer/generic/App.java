package patterns.observer.generic;

import patterns.observer.HobbitsObserver;
import patterns.observer.OrcsObserver;
import patterns.observer.Weather;

public class App {

    public static void main(String[] args) {
        Weather weather = new Weather();
        weather.addObserver(new OrcsObserver());
        weather.addObserver(new HobbitsObserver());

        weather.timePasses();
        System.out.println();
        weather.timePasses();
    }
}
