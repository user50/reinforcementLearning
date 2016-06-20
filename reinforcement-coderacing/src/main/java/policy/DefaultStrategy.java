package policy;

import action.*;
import com.example.common.Strategy;
import trivial.CodeRaceAction;
import trivial.CodeRaceState;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;

public class DefaultStrategy implements Strategy<CodeRaceState, CodeRaceAction> {

    List<CodeRaceAction> actions = Actions.getActions();

    @Override
    public double calculate(CodeRaceState state, CodeRaceAction action) {
        throw new NotImplementedException();
    }

    @Override
    public CodeRaceAction generate(CodeRaceState state) {
        return new CodeRaceAction(0.0);
    }

    @Override
    public void update(CodeRaceState state, CodeRaceAction action) {
        throw new NotImplementedException();
    }
}
