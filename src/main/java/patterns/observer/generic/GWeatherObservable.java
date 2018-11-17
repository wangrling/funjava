package patterns.observer.generic;

public class GWeatherObservable extends Observable<
        GWeatherObservable, SubObserver, WeatherType> {

    private WeatherType currentWeather;

    public GWeatherObservable() {
        currentWeather = WeatherType.SUNNY;
    }

    public void timePasses() {
        WeatherType[] enumValues = WeatherType.values();

        currentWeather = enumValues[(currentWeather.ordinal() + 1) % (enumValues).length];

        System.out.format("The weather changed to {%s}.%n", currentWeather);
        notifyObservers(currentWeather);
    }
}
