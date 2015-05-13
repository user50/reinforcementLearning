package simulation;

/**
 * Created by lozov on 13.05.15.
 */
public class HeadsAndTailsCondition implements Condition<Integer> {
    @Override
    public boolean isCondition(Integer integer) {
        return Math.random() > 0.5;
    }
}
