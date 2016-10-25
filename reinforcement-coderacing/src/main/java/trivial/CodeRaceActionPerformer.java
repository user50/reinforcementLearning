package trivial;

import abstractions.ActionPerformer;
import com.coderacing.model.Car;
import com.coderacing.model.Game;
import com.coderacing.model.Move;
import com.coderacing.model.World;

public class CodeRaceActionPerformer implements ActionPerformer<CodeRaceAction> {
    @Override
    public void perform(Car self, World world, Game game, Move move, CodeRaceAction action) {
        move.setWheelTurn(self.getWheelTurn() + action.getDeltaWheelTurn());
        move.setEnginePower(0.1);
    }
}
