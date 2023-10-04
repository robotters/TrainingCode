package github.robotters.training.strafer.opmodes;

import com.qualcomm.hardware.lynx.LynxModule;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import github.robotters.training.logic.BulkReads;
import github.robotters.training.strafer.Strafer;

@Autonomous(name = "SimbaBasicDriveForwards")
public class Auto extends LinearOpMode {
    Strafer robot;
    BulkReads reads;
    @Override
    public void runOpMode() throws InterruptedException {
        reads = new BulkReads(hardwareMap.getAll(LynxModule.class));
        Strafer.OpModeType type = Strafer.OpModeType.AUTO;
        robot = new Strafer(type, hardwareMap, null);
        waitForStart();
        while (opModeIsActive() && !isStopRequested()) {
            reads.BulkRead();
            robot.run();
        }
        robot.reset();
    }
}
