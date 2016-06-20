package trivial.jdbc.utility;

import jdbc.ResultSetExtractor;
import trivial.CodeRaceState;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class ExtractUtility implements ResultSetExtractor<Map<CodeRaceState,Double>> {
    @Override
    public Map<CodeRaceState, Double> read(ResultSet resultSet) throws SQLException {
        Map<CodeRaceState, Double> utility = new HashMap<>();

        while (resultSet.next())
        {
            int targetDirection = resultSet.getInt("target_direction");
            int wheelTurn = resultSet.getInt("wheel_turn");
            int leftWall = resultSet.getInt("left_wall");
            int rightWall = resultSet.getInt("right_wall");
            double value = resultSet.getDouble("value");

            utility.put(new CodeRaceState(targetDirection, wheelTurn, leftWall, rightWall), value);
        }

        return utility;
    }
}
