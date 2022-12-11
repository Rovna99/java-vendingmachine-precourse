package vendingmachine.domain;

import java.util.Map;

public class MachineState {
    private Map<Integer, Integer> changes;
    private Products products;

    public void saveChanges(Map<Integer, Integer> changes) {
        this.changes = changes;
    }

    public Map<Integer, Integer> getChanges() {
        return changes;
    }
}
