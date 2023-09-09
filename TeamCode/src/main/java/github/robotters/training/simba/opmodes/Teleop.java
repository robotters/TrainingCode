package github.robotters.training.simba.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import github.robotters.training.simba.Simba;

// Simba Basic TeleopMode
@TeleOp(name = "SimbaBasicTeleopMode")
public class Teleop extends LinearOpMode {
    Simba robot;
    @Override
    public void runOpMode() throws InterruptedException {
        Simba.OpModeType type = Simba.OpModeType.TELEOP;
        robot = new Simba(type);
        waitForStart();
        while (opModeIsActive() && !isStopRequested()) {
            robot.run();
        }
        robot.reset();
    }
}
