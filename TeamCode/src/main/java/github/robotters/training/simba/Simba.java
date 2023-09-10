package github.robotters.training.simba;


import com.arcrobotics.ftclib.command.Robot;
import com.arcrobotics.ftclib.command.Subsystem;
import com.arcrobotics.ftclib.drivebase.MecanumDrive;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

import java.util.Map;

import github.robotters.training.common.init.SubsystemStateContainer;
import github.robotters.training.simba.subsystems.DriveTrain;

// Robot Class Run In Each Op Mode
public class Simba extends Robot {
    private static String hardwaremapkey = "HardwareMap";
    // Type Enum:
    public enum OpModeType {
        TELEOP, AUTO
    }

    public Simba(OpModeType type, HardwareMap map) {
        Map<String, Subsystem> subsystemMap = SubsystemStateContainer.getState();
        InitSubsystems(subsystemMap, map);
        if(type == OpModeType.AUTO) {
            InitAutoScheduler(subsystemMap);
        } else if(type == OpModeType.TELEOP) {
            InitTeleopScheduler(subsystemMap);
        }
    }

    // Initialize The Auto Scheduler Using The Auto Drive Commands
    private void InitAutoScheduler(Map<String, Subsystem> subsystemMap) {

    }

    // Initialize The Teleop Drive Commands
    private void InitTeleopScheduler(Map<String, Subsystem> subsystemMap) {

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
            subsystemMap.put(DriveTrain.key, new DriveTrain(drive));
        }
    }
}
