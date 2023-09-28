package github.robotters.training.simba;


import com.arcrobotics.ftclib.command.CommandScheduler;
import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.Robot;
import com.arcrobotics.ftclib.command.Subsystem;
import com.arcrobotics.ftclib.command.button.Button;
import com.arcrobotics.ftclib.drivebase.MecanumDrive;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

import java.util.Map;

import github.robotters.training.common.init.Gamepads;
import github.robotters.training.common.init.SubsystemStateContainer;
import github.robotters.training.simba.commands.teleop.DefaultDriveCommand;
import github.robotters.training.simba.commands.teleop.DefaultLinearSlideCommand;
import github.robotters.training.simba.subsystems.DriveTrain;
import github.robotters.training.simba.subsystems.LinearSlide;
import github.robotters.training.simba.subsystems.LinearSlidePidController;
import static github.robotters.training.common.init.StateContainer.get;

// Robot Class Run In Each Op Mode
public class Simba extends Robot {
    private static String hardwaremapkey = "HardwareMap";
    // Type Enum:
    public enum OpModeType {
        TELEOP, AUTO
    }

    public Simba(OpModeType type, HardwareMap map, Gamepads gamepads) {
        Map<String, Subsystem> subsystemMap = SubsystemStateContainer.getState();
        InitSubsystems(subsystemMap, map);
        if(type == OpModeType.AUTO) {
            InitAutoScheduler(subsystemMap);
        } else if(type == OpModeType.TELEOP) {
            InitTeleopScheduler(subsystemMap, gamepads);
        }
    }

    // Initialize The Auto Scheduler Using The Auto Drive Commands
    private void InitAutoScheduler(Map<String, Subsystem> subsystemMap) {
    }

    // Initialize The Teleop Drive Commands
    private void InitTeleopScheduler(Map<String, Subsystem> subsystemMap, Gamepads gamepads) {
        // Initialize Default Drive Command
        DriveTrain driveTrain = get(DriveTrain.class, DriveTrain.key);
        driveTrain.setDefaultCommand(
                new DefaultDriveCommand(driveTrain, gamepads.driver1));

        LinearSlide slide = get(LinearSlide.class, LinearSlide.key);
        slide.setDefaultCommand(
                new DefaultLinearSlideCommand(slide, get(LinearSlidePidController.class, LinearSlidePidController.key)));

        // Set the Target Position To Up, When X Is Pressed
        gamepads.driver2.getGamepadButton(GamepadKeys.Button.X)
                .whenPressed(new InstantCommand(() -> slide.target_position = LinearSlide.Position.UP));

        // When Y is pressed, Set Position to Down
        gamepads.driver2.getGamepadButton(GamepadKeys.Button.Y)
                .whenPressed(new InstantCommand(() -> slide.target_position = LinearSlide.Position.DOWN));
    }

    private void InitSubsystems(Map<String, Subsystem> subsystemMap, HardwareMap map) {
        if (!subsystemMap.containsKey(DriveTrain.key)) {
            // Initialize Drivetrain Object
            Motor.GoBILDA drivetrain_motor_type = Motor.GoBILDA.RPM_312;
            MecanumDrive drive = new MecanumDrive(
                    new MotorEx(map, HardwareDef.frontleft, drivetrain_motor_type),
                    new MotorEx(map, HardwareDef.frontright, drivetrain_motor_type),
                    new MotorEx(map, HardwareDef.backleft, drivetrain_motor_type),
                    new MotorEx(map, HardwareDef.backright, drivetrain_motor_type)
            );
            DriveTrain driveTrain = new DriveTrain(drive);
            subsystemMap.put(DriveTrain.key, driveTrain);
        }
        if (!subsystemMap.containsKey(LinearSlidePidController.key)) {
            LinearSlidePidController controller = new LinearSlidePidController(1, 1, 1, 1);
            subsystemMap.put(LinearSlidePidController.key, controller);
        }
        if (!subsystemMap.containsKey(LinearSlide.key)) {
            LinearSlide slide = new LinearSlide(new MotorEx(map, HardwareDef.slide_motor, Motor.GoBILDA.RPM_312));
            subsystemMap.put(LinearSlide.key, slide);
        }
    }
}
