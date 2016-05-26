package policy;

public class NaivePolicy implements Policy {
    @Override
    public CodeRacingAction get(CodeRacingState state) {
        double enginePower = state.getTargetDistance() < 600 ? 0.1 : 0.5;
        double wheelTurn = 3 * Math.acos(state.getSpeedDirection().getX()) * Math.signum(state.getSpeedDirection().getY())/2;

        return new CodeRacingAction(enginePower, wheelTurn);
    }
}
