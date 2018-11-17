package patterns.observer.generic;

public interface SubObserver extends Observer<
        GWeatherObservable, SubObserver, WeatherType>  {

}
