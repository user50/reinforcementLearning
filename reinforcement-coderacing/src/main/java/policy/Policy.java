package policy;

import action.CodeRacingAction;
import state.CodeRacingState;

public interface Policy {

    CodeRacingAction get(CodeRacingState state);
}
