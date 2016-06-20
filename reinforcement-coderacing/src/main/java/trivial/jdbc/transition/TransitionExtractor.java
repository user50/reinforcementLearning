package trivial.jdbc.transition;

import action.CodeRaceTransitionModel;
import action.DecisionPoint;
import action.TransitionPoint;
import jdbc.ResultSetExtractor;
import trivial.CodeRaceAction;
import trivial.CodeRaceState;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class TransitionExtractor implements ResultSetExtractor<CodeRaceTransitionModel> {
    @Override
    public CodeRaceTransitionModel read(ResultSet resultSet) throws SQLException {
        Map<TransitionPoint, Long> transitions = new HashMap<>();
        Map<DecisionPoint, Long> decisions = new HashMap<>();
        Map<DecisionPoint, Set<CodeRaceState>> possibleStates = new HashMap<>();

        int count = 0;
        while (resultSet.next())
        {
            int targetDirection = resultSet.getInt("state.target_direction");
            int wheelTurn = resultSet.getInt("state.wheel_turn");
            int leftWall = resultSet.getInt("state.left_wall");
            int rightWall = resultSet.getInt("state.right_wall");
            int nextTargetDirection = resultSet.getInt("nextState.target_direction");
            int nextWheelTurn = resultSet.getInt("nextState.wheel_turn");
            int nextLeftWall= resultSet.getInt("nextState.left_wall");
            int nextRightWall= resultSet.getInt("nextState.right_wall");

            double deltaWheelTurn = resultSet.getDouble("action.delta_wheel_turn");
            long value = resultSet.getLong("value");

            CodeRaceState state = new CodeRaceState(targetDirection, wheelTurn, leftWall, rightWall);
            CodeRaceState nextState = new CodeRaceState(nextTargetDirection, nextWheelTurn, nextLeftWall, nextRightWall);
            CodeRaceAction action = new CodeRaceAction(deltaWheelTurn);

            if (transitions.containsKey(new TransitionPoint(state, action, nextState)))
                System.out.println("something wrong");

            transitions.put(new TransitionPoint(state, action, nextState), value);

            decisions.merge(new DecisionPoint(state, action), value, (oV, nV) -> oV + nV);
            possibleStates.merge(new DecisionPoint(state, action), new HashSet<>(Arrays.asList(nextState)), (oV,nV) -> {oV.addAll(nV); return oV;} );

            System.out.println("total "+(++count));
        }

        return new CodeRaceTransitionModel(transitions, decisions, possibleStates);
    }
}
