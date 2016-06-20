package trivial.jdbc.utility;

import jdbc.BatchUpdate;
import trivial.CodeRaceState;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Map;

public class SaveUtility implements BatchUpdate {

    private Iterator<CodeRaceState> iterator;
    private Map<CodeRaceState,Double> values;

    public SaveUtility(Iterator<CodeRaceState> iterator, Map<CodeRaceState, Double> values) {
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
        return "INSERT INTO `utility`(`state_id`, value)\n" +
                "SELECT state.id, ? FROM reinforcement.state\n" +
                "WHERE state.target_direction = ? AND state.wheel_turn = ? AND left_wall = ? AND right_wall = ?\n" +
                "ON duplicate key update `value` =  ?";
    }

    @Override
    public void prepare(PreparedStatement statement) throws SQLException {
        int i = 0;
        CodeRaceState state = iterator.next();

        statement.setDouble(++i, values.get(state));
        statement.setInt(++i, state.getTargetDirection());
        statement.setInt(++i, state.getWheelTurn());
        statement.setInt(++i, state.getLeftWall());
        statement.setInt(++i, state.getRightWall());
        statement.setDouble(++i, values.get(state));
    }
}
