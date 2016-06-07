package policy;

import trivial.CodeRacingAction;
import trivial.CodeRaceState;

public interface Policy {

    CodeRacingAction get(CodeRaceState state);
}
