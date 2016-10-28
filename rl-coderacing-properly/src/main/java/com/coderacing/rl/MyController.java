package com.coderacing.rl;

import com.coderacing.model.Car;
import com.coderacing.model.Game;
import com.coderacing.model.Move;
import com.coderacing.model.World;
import com.coderacing.rl.action.CodeRaceAction;
import com.coderacing.transition.TransitionModel;
import com.coderacing.transition.TransitionModelProvider;

public class MyController implements CodeRaceController {

    private CodeRacingStateBuilder stateBuilder = new CodeRacingStateBuilder();
    private Policy policy = new Policy();
    private TransitionModel transitionModel = new TransitionModelProvider().get();

    @Override
    public void move(Car self, World world, Game game, Move move) {
        CodeRaceState codeRaceState = stateBuilder.build(self, world, game, move);
        CodeRaceAction action = policy.get(codeRaceState);

        move.setEnginePower(self.getEnginePower() + action.getDeltaEnginePower());
        move.setWheelTurn(self.getWheelTurn() + action.getDeltaWheelTurn());

        transitionModel.apply(codeRaceState, action);
    }
}
