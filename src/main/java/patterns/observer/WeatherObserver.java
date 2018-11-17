package patterns.observer;

/**
 * Observer interface.
 */

public interface WeatherObserver {

    public void update(WeatherType currentWeather);
}
