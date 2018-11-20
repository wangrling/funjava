package tutorials.language;

public interface OperateCar {

    // Constant declarations, if any method signatures.
    enum Direction {
        RIGHT, LEFT
    }


    // An enum with values RIGHT, LEFT
    int turn(Direction direction,
        double radius,
        double startSpeed,
        double endSpeed);

    int changeLanes(Direction direction,
                    double startSpeed,
                    double endSpeed);

    int signalTurn(Direction direction,
                   boolean signalOn);

    int getRadarFront(double distanceToCar,
                      double speedOfCar);

    int getRadarRear(double distanceToCar,
                     double speedOfCar);
}
