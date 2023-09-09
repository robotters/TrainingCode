package github.robotters.training.simba.opmodes;

import com.qualcomm.hardware.lynx.LynxModule;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import github.robotters.training.simba.Simba;

@Autonomous(name = "SimbaBasicDriveForwards")
public class Auto extends LinearOpMode {
    Simba robot;
    @Override
    public void runOpMode() throws InterruptedException {
        Simba.OpModeType type = Simba.OpModeType.AUTO;
        robot = new Simba(type);
        waitForStart();
        while (opModeIsActive() && !isStopRequested()) {
            robot.run();
        }
        robot.reset();
    }
}
