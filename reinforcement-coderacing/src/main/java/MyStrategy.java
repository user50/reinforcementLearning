import math.Vector;
import model.*;
import policy.Action;
import policy.Policy;
import policy.State;

import java.util.*;

import static math.VectorAlgebra.difference;
import static math.VectorAlgebra.length;

public final class MyStrategy implements Strategy {

    Policy policy;
    int score = 0;

    public MyStrategy(Policy policy) {
        this.policy = policy;
    }

    @Override
    public void move(Car self, World world, Game game, Move move) {
        try {
            Vector me = new Vector(self.getX(), -self.getY());
            Vector mySpeed = new Vector(self.getSpeedX(), -self.getSpeedY());
            Action action = policy.get(new State(me, mySpeed, getTarget(self, world), world.getTick()));

            System.out.println(action.getWheelTurn() + " : " + action.getEnginePower());
            move.setWheelTurn(action.getWheelTurn());
            move.setEnginePower(action.getEnginePower());

            for (Player player : world.getPlayers()) {
                if (player.getName().equals(getClass().getName())) {
                    int reward = player.getScore() - score;
                    score = player.getScore();

                    if (reward > 0.01)
                        System.out.println(reward);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

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
