package tutorials.language;

public class OperateBMW760i implements OperateCar {
    @Override
    public int turn(Direction direction, double radius, double startSpeed, double endSpeed) {
        return 0;
    }

    @Override
    public int changeLanes(Direction direction, double startSpeed, double endSpeed) {
        return 0;
    }

    @Override
    public int signalTurn(Direction direction, boolean signalOn) {
        // code to turn BMW's LEFT turn indicator lights on
        // code to turn BMW's LEFT turn indicator lights off
        // code to turn BMW's RIGHT turn indicator lights on
        // code to turn BMW's RIGHT turn indicator lights off
        return 0;
    }

    @Override
    public int getRadarFront(double distanceToCar, double speedOfCar) {
        return 0;
    }

    @Override
    public int getRadarRear(double distanceToCar, double speedOfCar) {
        return 0;
    }
}
