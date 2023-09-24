package github.robotters.training.simba.commands.teleop;

import com.arcrobotics.ftclib.command.CommandBase;
import github.robotters.training.simba.subsystems.LinearSlide;
import github.robotters.training.simba.subsystems.LinearSlidePidController;

// Linear Slide Command Run On Every Scheduler Cycle
public class DefaultLinearSlideCommand extends CommandBase {
  private static int down_pos = 0;
  private static int up_pos = 100;

  private final LinearSlide slide;
  private final LinearSlidePidController controller;

  public DefaultLinearSlideCommand(LinearSlide slide, LinearSlidePidController controller) {
    this.slide = slide;
    this.controller = controller;
    addRequirements(controller, slide);
  }

  @Override
  public void execute() {
    int target = 0;
    switch (slide.target_position) {
      case UP:
        target = up_pos;

      case DOWN:
        target = down_pos;
    }

    double power = controller.GetOutput(slide.Get_Pos(), target);
    slide.SetSpeed(power);
  }
}
