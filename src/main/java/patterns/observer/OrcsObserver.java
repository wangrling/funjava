package patterns.observer;

public class OrcsObserver implements WeatherObserver {
    @Override
    public void update(WeatherType currentWeather) {
        switch (currentWeather) {
            case COLD:
                System.out.println("The orcs are freezing cold.");
                break;
            case RAINY:
                System.out.println("The orcs are dripping wet.");
                break;
            case SUNNY:
                System.out.println("The Sun hurts the orcs' eyes");
                break;
            case WINDY:
                System.out.println("The orcs smell almost vanished in the wind");
                break;
            default:
                break;
        }
    }
}
