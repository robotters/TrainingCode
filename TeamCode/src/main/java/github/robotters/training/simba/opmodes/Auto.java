package github.robotters.training.simba.opmodes;

import com.qualcomm.hardware.lynx.LynxModule;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import github.robotters.training.common.init.Gamepads;
import github.robotters.training.logic.BulkReads;
import github.robotters.training.simba.Simba;

@Autonomous(name = "SimbaBasicDriveForwards")
public class Auto extends LinearOpMode {
    Simba robot;
    BulkReads reads;
    @Override
    public void runOpMode() throws InterruptedException {
        reads = new BulkReads(hardwareMap.getAll(LynxModule.class));
        Simba.OpModeType type = Simba.OpModeType.AUTO;
        robot = new Simba(type, hardwareMap, null);
        waitForStart();
        while (opModeIsActive() && !isStopRequested()) {
            reads.BulkRead();
            robot.run();
        }
        robot.reset();
    }
}
