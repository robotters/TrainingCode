package github.robotters.training.simba;


import com.arcrobotics.ftclib.command.Robot;
import com.arcrobotics.ftclib.command.Subsystem;
import com.arcrobotics.ftclib.drivebase.MecanumDrive;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

import java.util.Map;

import github.robotters.training.common.init.State;
import github.robotters.training.simba.subsystems.DriveTrain;

// Robot Class Run In Each Op Mode
public class Simba extends Robot {
    private static String hardwaremapkey = "HardwareMap";
    // Type Enum:
    public enum OpModeType {
        TELEOP, AUTO
    }

    public Simba(OpModeType type, HardwareMap map) {
        Map<String, Subsystem> stateMap = State.getState();
        InitSubsystems(stateMap, map);
        if(type == OpModeType.AUTO) {
            InitAutoScheduler(stateMap);
        } else if(type == OpModeType.TELEOP) {
            InitTeleopScheduler(stateMap);
        }
    }

    // Initialize The Auto Scheduler Using The Auto Drive Commands
    private void InitAutoScheduler(Map<String, Subsystem> stateMap) {

    }

    // Initialize The Teleop Drive Commands
    private void InitTeleopScheduler(Map<String, Subsystem> stateMap) {

    }

    private void InitSubsystems(Map<String, Subsystem> stateMap, HardwareMap map) {
        if (!stateMap.containsKey(DriveTrain.key)) {
            // Initialize Drivetrain Object
            Motor.GoBILDA drivetrain_motor_type = Motor.GoBILDA.RPM_312;
            MecanumDrive drive = new MecanumDrive(
                    new MotorEx(map, HardwareDef.frontleft, drivetrain_motor_type),
                    new MotorEx(map, HardwareDef.frontright, drivetrain_motor_type),
                    new MotorEx(map, HardwareDef.backleft, drivetrain_motor_type),
                    new MotorEx(map, HardwareDef.backright, drivetrain_motor_type)
            );
            stateMap.put(DriveTrain.key, new DriveTrain(drive));
        }
    }
}
