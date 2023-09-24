package github.robotters.training.simba.subsystems;

import github.robotters.training.common.subsystem.SingleMotorPid;

public class LinearSlidePidController extends SingleMotorPid {
  public static String key = "LinearSlidePidController";

  public LinearSlidePidController(double kP, double kI, double kD, double kF) {
    super(kP, kI, kD, kF);
  }
}
