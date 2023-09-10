package github.robotters.training.simba.subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.qualcomm.robotcore.hardware.DcMotorEx;

public class LinearSlide extends SubsystemBase {
    public Position target_position;
    public enum Position {
        UP,
        DOWN
    }

    private MotorEx slide_motor;

    public LinearSlide(MotorEx slide_motor) {
        target_position = Position.DOWN;
        this.slide_motor = slide_motor;
    }

    public void SetSpeed(double speed) {
        slide_motor.set(speed);
    }

    public int Get_Pos() {
        return slide_motor.getCurrentPosition();
    }
}
