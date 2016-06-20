package trivial.jdbc.transition;

import action.TransitionPoint;
import jdbc.BatchUpdate;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Map;

public class SaveTransitions implements BatchUpdate {

    private Iterator<TransitionPoint> iterator;
    private Map<TransitionPoint, Long> values;

    public SaveTransitions(Iterator<TransitionPoint> iterator, Map<TransitionPoint, Long> values) {
        this.iterator = iterator;
        this.values = values;
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public int executeBatchEvery() {
        return 1000;
    }

    @Override
    public String getRawSql() {
        return "INSERT INTO `transition`(`state_id`, `next_state_id`,`action_id`, value)\n" +
                "  SELECT state.id, nextState.id, `action`.id, ? FROM reinforcement.state\n" +
                "    JOIN state as nextState ON nextState.target_direction = ? AND nextState.wheel_turn = ? AND nextState.left_wall = ? AND nextState.right_wall = ?\n" +
                "    JOIN `action` ON `action`.delta_wheel_turn = ?\n" +
                "  WHERE state.target_direction = ? AND state.wheel_turn = ? AND state.left_wall = ? AND state.right_wall = ?\n" +
                "ON duplicate key update `value` = `value` + ?";
    }

    @Override
    public void prepare(PreparedStatement statement) throws SQLException {
        int i = 0;
        TransitionPoint point = iterator.next();

        statement.setLong(++i, values.get(point));
        statement.setInt(++i, point.getNextState().getTargetDirection());
        statement.setInt(++i, point.getNextState().getWheelTurn());
        statement.setInt(++i, point.getNextState().getLeftWall());
        statement.setInt(++i, point.getNextState().getRightWall());
        statement.setDouble(++i, point.getAction().getDeltaWheelTurn());
        statement.setDouble(++i, point.getState().getTargetDirection());
        statement.setDouble(++i, point.getState().getWheelTurn());
        statement.setDouble(++i, point.getState().getLeftWall());
        statement.setDouble(++i, point.getState().getRightWall());
        statement.setLong(++i, values.get(point));
    }
}
