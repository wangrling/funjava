package tutorials.language;

public class MountainBikeClass extends BicycleClass {

    // the MountainBike subclass has
    // one field
    public int seatHeight;

    // the MountainBike subclass has
    // one constructor
    public MountainBikeClass(int startHeight, int startCadence,
                        int startSpeed, int startGear) {
        // 首先初始化父类。
        super(startCadence, startSpeed, startGear);
        seatHeight = startHeight;
    }

    // the MountainBike subclass has
    // one method
    public void setHeight(int newValue) {
        seatHeight = newValue;
    }
}
