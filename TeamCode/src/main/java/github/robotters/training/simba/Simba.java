package github.robotters.training.simba;


import com.arcrobotics.ftclib.command.Robot;
import com.arcrobotics.ftclib.command.Subsystem;

import java.util.Map;

import github.robotters.training.common.init.State;

// Robot Class Run In Each Op Mode
public class Simba extends Robot {
    // Type Enum:
    public enum OpModeType {
        TELEOP, AUTO
    }

    public Simba(OpModeType type) {
        Map<String, Subsystem> stateMap = State.getState();
        InitSubsystems(stateMap);
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

    private void InitSubsystems(Map<String, Subsystem> stateMap) {

    }
}
