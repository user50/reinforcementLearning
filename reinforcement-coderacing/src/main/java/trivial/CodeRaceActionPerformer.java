package trivial;

import abstractions.ActionPerformer;
import model.Car;
import model.Game;
import model.Move;
import model.World;

public class CodeRaceActionPerformer implements ActionPerformer<CodeRaceAction> {
    @Override
    public void perform(Car self, World world, Game game, Move move, CodeRaceAction action) {
        move.setWheelTurn(self.getWheelTurn() + action.getDeltaWheelTurn());
        move.setEnginePower(0.1);
    }
}
