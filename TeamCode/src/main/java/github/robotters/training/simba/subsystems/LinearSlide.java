package github.robotters.training.simba.subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;

public class LinearSlide extends SubsystemBase {
    public Position position;
    public enum Position {
        UP,
        DOWN
    }

    private MotorEx slide_motor;

    public LinearSlide(MotorEx slide_motor) {
        this.position = Position.DOWN;
        this.slide_motor = slide_motor;
    }

    public void SetSpeed(double speed) {
        slide_motor.set(speed);
    }
}
