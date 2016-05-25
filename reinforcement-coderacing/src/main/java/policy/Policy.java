package policy;

public interface Policy {

    Action get(State state);
}
