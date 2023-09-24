package github.robotters.training.simba.opmodes;

import com.qualcomm.hardware.lynx.LynxModule;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import github.robotters.training.common.init.Gamepads;
import github.robotters.training.logic.BulkReads;
import github.robotters.training.simba.Simba;

// Simba Basic TeleopMode
@TeleOp(name = "SimbaBasicTeleopMode")
public class Teleop extends LinearOpMode {
  Simba robot;
  BulkReads reads;

  @Override
  public void runOpMode() throws InterruptedException {
    Gamepads gamepads = new Gamepads(gamepad1, gamepad2);
    Simba.OpModeType type = Simba.OpModeType.TELEOP;
    reads = new BulkReads(hardwareMap.getAll(LynxModule.class));
    robot = new Simba(type, hardwareMap, gamepads);
    waitForStart();
    while (opModeIsActive() && !isStopRequested()) {
      reads.BulkRead();
      robot.run();
    }
    robot.reset();
  }
}
