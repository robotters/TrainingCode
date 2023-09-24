package github.robotters.training.common.init;

import com.arcrobotics.ftclib.command.Subsystem;
import java.util.HashMap;
import java.util.Map;

// State Map, Allowing Data to Be Shared Between Auto And Teleop
// This Should Contain Everything that Should Be Shared
// Each Inserted Op Mode Should Expose a Static Shared Key
public class SubsystemStateContainer {
  private static Map<String, Subsystem> state;

  // Make State A Singleton Instance of Map<String, Subsystem>
  public static synchronized Map<String, Subsystem> getState() {
    if (state == null) {
      state = initialize();
      return state;
    }
    return state;
  }

  // Insert State Into The Normal Map
  private static Map<String, Subsystem> initialize() {
    Map<String, Subsystem> state = new HashMap<>();

    return state;
  }
}
