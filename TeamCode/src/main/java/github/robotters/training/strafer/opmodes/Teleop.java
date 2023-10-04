package github.robotters.training.strafer.opmodes;

import com.qualcomm.hardware.lynx.LynxModule;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import github.robotters.training.common.init.Gamepads;
import github.robotters.training.logic.BulkReads;
import github.robotters.training.strafer.Strafer;

// Simba Basic TeleopMode
@TeleOp(name = "SimbaBasicTeleopMode")
public class Teleop extends LinearOpMode {
    Strafer robot;
    BulkReads reads;
    @Override
    public void runOpMode() throws InterruptedException {
        Gamepads gamepads = new Gamepads(gamepad1, gamepad2);
        Strafer.OpModeType type = Strafer.OpModeType.TELEOP;
        reads = new BulkReads(hardwareMap.getAll(LynxModule.class));
        robot = new Strafer(type, hardwareMap, gamepads);
        waitForStart();
        while (opModeIsActive() && !isStopRequested()) {
            reads.BulkRead();
            robot.run();
        }
        robot.reset();
    }
}
