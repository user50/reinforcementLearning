import com.example.common.*;
import com.example.montecarlo.Step;
import math.LogScale;
import math.Vector;
import model.*;
import action.CodeRacingAction;
import policy.Policy;
import state.CodeRacingState;

import java.util.*;

import static math.VectorAlgebra.*;

public final class MyStrategy implements Strategy {

    com.example.common.Strategy<CodeRacingState, CodeRacingAction> policy;
    int score = 0;
    CodeRacingState preState;
    CodeRacingAction preAction;

    List<Step<CodeRacingState, CodeRacingAction>> steps = new ArrayList<>();

    public MyStrategy(com.example.common.Strategy<CodeRacingState, CodeRacingAction> policy) {
        this.policy = policy;
    }

    @Override
    public void move(Car self, World world, Game game, Move move) {
        int x = (int)self.getX()/400;
        int y = (int)self.getY()/400;
        int speedX = LogScale.index(self.getSpeedX(), 0.05, 10, 4);
        int speedY = LogScale.index(self.getSpeedY(), 0.05, 10, 4);

        CodeRacingState state = new CodeRacingState(x, y, speedX, speedY);
        CodeRacingAction action = policy.generate(state);

        move.setWheelTurn(self.getWheelTurn() + action.getDeltaWheelTurn());
        move.setEnginePower(self.getEnginePower() + action.getDeltaEnginePower());

        if (preState != null && world.getTick() > 181) {
            double reward  = getReward(world);
            steps.add(new Step(preState, preAction, state, reward));
        }

        preState = state;
        preAction = action;
    }

    public List<Step<CodeRacingState, CodeRacingAction>> getSteps() {
        return steps;
    }

    private double getReward(World world)
    {
        for (Player player : world.getPlayers()) {
            if (player.getName().equals(getClass().getName())) {
                int reward = player.getScore() - score;
                score = player.getScore();

                if (reward>0)
                    System.out.println(player.getScore());

                return ((double)reward);
            }
        }

        throw new RuntimeException("Unable to find player: "+getClass().getName());
    }

    private Vector getTarget(Car self, World world)
    {
        Map<String, TileType> tiles = getTailMap(world);
        int x = (int)self.getX()/800;
        int y = (int)self.getY()/800;

        List<Vector> possibleTiles = new ArrayList<>();
        if (tiles.containsKey((x+1)+":"+y))
            possibleTiles.add(new Vector( (x+1) * 800 + 400, -y * 800 - 400 ));

        if (tiles.containsKey((x-1)+":"+y))
            possibleTiles.add(new Vector( (x-1) * 800 + 400, -y * 800 - 400 ));

        if (tiles.containsKey(x+":"+(y+1)))
            possibleTiles.add(new Vector(  x * 800 + 400, -(y+1) * 800 - 400));

        if (tiles.containsKey(x+":"+(y-1)))
            possibleTiles.add(new Vector(  x * 800 + 400, -(y-1) * 800 - 400));

        Vector nextWayTail = new Vector(self.getNextWaypointX() * 800 + 400, -self.getNextWaypointY() * 800 - 400);

        Collections.sort(possibleTiles, (v1,v2) -> new Double(length(difference(nextWayTail, v1))).compareTo(length(difference(nextWayTail, v2)))   );

        return possibleTiles.get(0);
    }



    private Map<String, TileType> getTailMap(World world)
    {
        Map<String, TileType> tiles = new HashMap<>();

        int x = 0;
        for (TileType[] tileTypes : world.getTilesXY()) {
            int y = 0;
            for (TileType tileType : tileTypes) {
                if (tileType != TileType.EMPTY)
                    tiles.put(x+":"+y, tileType);
                y++;
            }
            x++;
        }

        return tiles;
    }


}
