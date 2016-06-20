package trivial.jdbc.transition;

import action.DecisionPoint;
import jdbc.BatchUpdate;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Map;

public class SaveDecisions implements BatchUpdate {

    private Iterator<DecisionPoint> iterator;
    private Map<DecisionPoint,Long> values;

    public SaveDecisions(Iterator<DecisionPoint> iterator, Map<DecisionPoint, Long> values) {
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
        return "INSERT INTO `decision`(`state_id`,`action_id`, value)\n" +
                "SELECT state.id, `action`.id, ? FROM reinforcement.state\n" +
                "JOIN `action` ON `action`.delta_wheel_turn = ?\n" +
                "WHERE state.target_direction = ? AND state.wheel_turn = ? AND state.left_wall = ? AND state.right_wall = ?\n" +
                "ON duplicate key update `value` = `value` + ?";
    }

    @Override
    public void prepare(PreparedStatement statement) throws SQLException {
        int i = 0;
        DecisionPoint point = iterator.next();

        statement.setLong(++i, values.get(point));
        statement.setDouble(++i, point.getAction().getDeltaWheelTurn());
        statement.setInt(++i, point.getState().getTargetDirection());
        statement.setInt(++i, point.getState().getWheelTurn());
        statement.setInt(++i, point.getState().getLeftWall());
        statement.setInt(++i, point.getState().getRightWall());
        statement.setLong(++i, values.get(point));
    }
}
