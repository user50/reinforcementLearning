package trivial.jdbc.transition;

import jdbc.SqlOperation;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class GetTransition implements SqlOperation {
    @Override
    public String getRawSql() {
        return "SELECT state.*, action.*, nextState.*, value FROM reinforcement.transition\n" +
                "JOIN action ON action.id = transition.action_id\n" +
                "JOIN state ON state.id = transition.state_id\n" +
                "JOIN state as nextState ON nextState.id = transition.next_state_id ";
    }

    @Override
    public void prepare(PreparedStatement statement) throws SQLException {

    }
}
