package abstractions;

import action.CodeRaceTransitionModel;
import action.TransitionPoint;
import jdbc.JdbcService;
import trivial.CodeRaceState;
import trivial.jdbc.SaveActions;
import trivial.jdbc.transition.SaveDecisions;
import trivial.jdbc.SaveStates;
import trivial.jdbc.transition.SaveTransitions;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CodeRaceTransitionModelStorage {

    JdbcService jdbcService;

    public CodeRaceTransitionModelStorage(JdbcService jdbcService) {
        this.jdbcService = jdbcService;
    }

    public void save(CodeRaceTransitionModel transitionModel)
    {
        try {
            jdbcService.executeBatchUpdate(new SaveActions(transitionModel.getActions().iterator()));

            Set<CodeRaceState> states = new HashSet<>();
            for (Map.Entry<TransitionPoint, Long> entry : transitionModel.getTransitions().entrySet()) {
                states.add(entry.getKey().getState());
                states.add(entry.getKey().getNextState());
            }
            jdbcService.executeBatchUpdate(new SaveStates(states.iterator()));

            jdbcService.executeBatchUpdate(new SaveDecisions(transitionModel.getDecisions().keySet().iterator(), transitionModel.getDecisions()));
            jdbcService.executeBatchUpdate(new SaveTransitions(transitionModel.getTransitions().keySet().iterator(), transitionModel.getTransitions()));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
