package com.coderacing.rl;

import com.coderacing.model.Car;
import com.coderacing.model.Game;
import com.coderacing.model.Move;
import com.coderacing.model.World;
import com.coderacing.rl.action.CodeRaceAction;

public class MyController implements CodeRaceController {

    private CodeRacingStateBuilder stateBuilder = new CodeRacingStateBuilder();
    private Policy policy = new Policy();

    @Override
    public void move(Car self, World world, Game game, Move move) {
        CodeRaceState codeRaceState = stateBuilder.build(self, world, game, move);
        CodeRaceAction action = policy.get(codeRaceState);

        move.setEnginePower(self.getEnginePower() + action.getDeltaEnginePower());
        move.setWheelTurn(self.getWheelTurn() + action.getDeltaEnginePower());
    }
}
