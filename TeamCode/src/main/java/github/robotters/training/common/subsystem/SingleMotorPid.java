package github.robotters.training.common.subsystem;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.controller.PIDFController;

// Single Motor Pid Controller Stateful Subsystem
public class SingleMotorPid extends SubsystemBase {
  private PIDFController controller;

  public SingleMotorPid(double kP, double kI, double kD, double kF) {
    this.controller = new PIDFController(kP, kI, kD, kF);
  }

  public double GetOutput(int pos, int target) {
    return controller.calculate(pos, target);
  }

  public void Reset() {
    controller.reset();
  }
}
