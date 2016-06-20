package trivial.jdbc.utility;

import jdbc.SqlOperation;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class GetUtility implements SqlOperation {
    @Override
    public String getRawSql() {
        return "SELECT * FROM reinforcement.utility\n" +
                "JOIN state ON state.id = utility.state_id";
    }

    @Override
    public void prepare(PreparedStatement statement) throws SQLException {

    }
}
