package github.robotters.training.logic;

import com.qualcomm.hardware.lynx.LynxModule;
import java.util.List;

// Static Logic Module That Initializes Bulk Reads Across All Hubs
public class BulkReads {
  List<LynxModule> modules;

  // Call in Init Method Of Robot
  // This Sets The Bulk Reads To Manual, and Is Important For Correct
  // Implementation
  public BulkReads(List<LynxModule> modules) {
    for (LynxModule m : modules) {
      m.setBulkCachingMode(LynxModule.BulkCachingMode.MANUAL);
    }
    this.modules = modules;
  }

  // Acually Bulk Read.
  // Call Before Each Scheduler Run
  public void BulkRead() {
    for (LynxModule m : modules) {
      m.clearBulkCache();
    }
  }
}
