package trivial.jdbc;

import jdbc.BatchUpdate;
import trivial.CodeRaceAction;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;

public class SaveActions implements BatchUpdate {

    private Iterator<CodeRaceAction> iterator;

    public SaveActions(Iterator<CodeRaceAction> iterator) {
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
        return "INSERT IGNORE INTO `reinforcement`.`action` (`delta_wheel_turn`) VALUES (?)";
    }

    @Override
    public void prepare(PreparedStatement statement) throws SQLException {
        CodeRaceAction action = iterator.next();
        statement.setDouble(1, action.getDeltaWheelTurn());
    }
}
