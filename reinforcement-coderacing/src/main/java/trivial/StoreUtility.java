package trivial;

import jdbc.JdbcService;
import trivial.jdbc.SaveStates;
import trivial.jdbc.utility.SaveUtility;

import java.sql.SQLException;
import java.util.Map;

public class StoreUtility {

    JdbcService jdbcService;

    public StoreUtility(JdbcService jdbcService) {
        this.jdbcService = jdbcService;
    }

    public void save(Map<CodeRaceState,Double> utility)
    {
        try {
            jdbcService.executeBatchUpdate(new SaveStates(utility.keySet().iterator()));
            jdbcService.executeBatchUpdate(new SaveUtility(utility.keySet().iterator(), utility));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

}
