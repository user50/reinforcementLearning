package policy;

public interface Policy {

    CodeRacingAction get(CodeRacingState state);
}
