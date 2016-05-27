import com.example.montecarlo.Step;
import math.Vector;
import model.*;
import action.CodeRacingAction;
import policy.Policy;
import state.CodeRacingState;

import java.util.*;

import static math.VectorAlgebra.*;

public final class MyStrategy implements Strategy {

    Policy policy;
    int score = 0;
    CodeRacingState preState;
    CodeRacingAction preAction;

    List<Step<CodeRacingState, CodeRacingAction>> steps = new ArrayList<>();

    public MyStrategy(Policy policy) {
        this.policy = policy;
    }

    @Override
    public void move(Car self, World world, Game game, Move move) {
        try {
            Vector me = new Vector(self.getX(), -self.getY());
            Vector mySpeed = new Vector(self.getSpeedX(), -self.getSpeedY());
            Vector nextWayTail = new Vector(self.getNextWaypointX() * 800 + 400, -self.getNextWaypointY() * 800 - 400);

            Vector me2target = difference(nextWayTail, me);
            double targetDistance = length(me2target);
            Vector speedDirection = new Vector(scalarProd(normalise(me2target), normalise(mySpeed) ), vectorProd(normalise(me2target), normalise(mySpeed)));

            CodeRacingState state = new CodeRacingState(targetDistance, speedDirection, self.getEnginePower(), self.getWheelTurn(), me);
            CodeRacingAction action = policy.get(state);

            move.setWheelTurn(self.getWheelTurn() + action.getDeltaWheelTurn());
            move.setEnginePower(self.getEnginePower() + action.getDeltaEnginePower());

            self.getAngularSpeed();
            if (preState != null && world.getTick() > 181) {
                double reward  = world.getTick() < world.getLastTickIndex() ? 0 : getReward(world);
                steps.add(new Step(preState, preAction, state, reward));

            }


            preState = state;
            preAction = action;

        } catch (Exception e) {
            e.printStackTrace();
        }

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

                return score;
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
