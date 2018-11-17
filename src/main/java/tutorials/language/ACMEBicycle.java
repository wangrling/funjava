package tutorials.language;

public class ACMEBicycle implements IBicycle {

    int cadence = 0;
    int speed = 0;
    int gear = 1;

    // The compiler will now require that methods
    // changeCadence, changeGear, speedUp, and applyBrakes
    // all be implemented. Compilation will fail if those
    // methods are missing from this class.

    @Override
    public void changeCadence(int newValue) {
        cadence = newValue;
    }

    @Override
    public void changeGear(int newValue) {
        gear = newValue;
    }

    @Override
    public void speedUp(int increment) {
        speed = increment;
    }

    @Override
    public void applyBrakes(int decrement) {
        speed = speed - decrement;
    }

    void printStates() {
        System.out.println("cadence:" +
                cadence + " speed:" +
                speed + " gear:" + gear);
    }
}
