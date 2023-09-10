package github.robotters.training.common.init;

import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.qualcomm.robotcore.hardware.Gamepad;

public class Gamepads {
    public GamepadEx driver1;
    public GamepadEx driver2;

    public Gamepads(Gamepad driver1, Gamepad driver2) {
        this.driver1 = new GamepadEx(driver1);
        this.driver2 = new GamepadEx(driver2);
    }
}
