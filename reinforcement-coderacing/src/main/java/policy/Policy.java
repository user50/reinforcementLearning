package policy;

import trivial.CodeRaceAction;
import trivial.CodeRaceState;

public interface Policy {

    CodeRaceAction get(CodeRaceState state);
}
