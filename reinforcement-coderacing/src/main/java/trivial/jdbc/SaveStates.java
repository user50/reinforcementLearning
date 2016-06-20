package trivial.jdbc;

import jdbc.BatchUpdate;
import trivial.CodeRaceState;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;

public class SaveStates implements BatchUpdate {

    private Iterator<CodeRaceState> iterator;

    public SaveStates(Iterator<CodeRaceState> iterator) {
        this.iterator = iterator;
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
        return "INSERT IGNORE INTO `reinforcement`.`state` (`target_direction`, `wheel_turn`, left_wall, right_wall) VALUES (?, ?, ?, ?)";
    }

    @Override
    public void prepare(PreparedStatement statement) throws SQLException {
        int i = 0;
        CodeRaceState state = iterator.next();

        statement.setInt(++i, state.getTargetDirection());
        statement.setInt(++i, state.getWheelTurn());
        statement.setInt(++i, state.getLeftWall());
        statement.setInt(++i, state.getRightWall());
    }
}
