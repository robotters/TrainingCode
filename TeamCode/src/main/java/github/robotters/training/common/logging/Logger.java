package github.robotters.training.common.logging;

import java.util.ArrayList;
import java.util.List;
import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Logger {
  private static Telemetry t;
  private static Logger instance;

  private List<LogTopic> topicList;

  private Logger() {
    topicList = new ArrayList<>(5);
  }

  // Insert Telemetry At The Beginning Of Every Op Mode (Yes, I know it Sucks), and
  // Will Cause a Crash, But At Least Right Away
  public static void addTelemetry(Telemetry tel) {
    t = tel;
  }

  public static synchronized Logger getInstance() {
    if (instance == null) {
      instance = new Logger();
      return instance;
    }

    return instance;
  }

  public void update() {
    for (LogTopic topic : topicList) {
      t.addData(topic.key, topic.value);
    }
  }

  public void send() {
    instance.update();
    t.update();
  }
}
