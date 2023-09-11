package github.robotters.training.simba.logic;

public class DriveLogic {
    // Data Class (I yearn for Kotlin)
    public static class RobotOrientedDriveData {
        public double v, h, r;

        public RobotOrientedDriveData(double v, double h, double r) {
            this.v = v;
            this.h = h;
            this.r = r;
        }
    }

    // Calculate Drive Inputs From Joystick Inputs
    public static RobotOrientedDriveData calcDriveInputs(double v, double h, double r) {
        return new RobotOrientedDriveData(-v, h, r);
    }
}
