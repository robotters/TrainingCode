package github.robotters.training.simba.subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.drivebase.MecanumDrive;

public class DriveTrain extends SubsystemBase {
  public static String key = "DriveTrain";

  MecanumDrive drive;

  public DriveTrain(MecanumDrive drive) {
    this.drive = drive;
  }

  public void DriveFromInputs(double strafe, double forwards, double rotation) {
    drive.driveRobotCentric(strafe, forwards, rotation);
  }
}
