package github.robotters.training.simba.commands.teleop;

import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import github.robotters.training.simba.logic.DriveLogic;
import github.robotters.training.simba.subsystems.DriveTrain;

// Drive Command Running Every Cycle, Unless Another Command Takes Priority
public class DefaultDriveCommand extends CommandBase {
  private final DriveTrain driveTrain;
  private final GamepadEx gamepadEx;

  public DefaultDriveCommand(DriveTrain driveTrain, GamepadEx gamepadEx) {
    this.driveTrain = driveTrain;
    this.gamepadEx = gamepadEx;
    addRequirements(driveTrain);
  }

  // Runs Every Cycle When Another Command Is Not Using the Drivetrain
  @Override
  public void execute() {
    DriveLogic.RobotOrientedDriveData d =
        DriveLogic.calcDriveInputs(
            gamepadEx.getLeftX(), gamepadEx.getLeftY(), gamepadEx.getRightX());

    driveTrain.DriveFromInputs(d.v, d.h, d.r);
  }
}
