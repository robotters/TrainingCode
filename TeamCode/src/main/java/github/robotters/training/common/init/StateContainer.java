package github.robotters.training.common.init;

import java.util.HashMap;
import java.util.Map;

// The State Container Is Used To Contain Internal Robot State
public class StateContainer {
    // The Actual State Object
    private Map<String, Object> state;

    public synchronized Map<String, Object> GetInstance() {
        if(state == null) {
            state = new HashMap<>();
            return state;
        }
        return state;
    }

    // Get Any Value
    public <T> T get(Class<? extends T> c, String key) {
        return c.cast(state.get(key));
    }
}
