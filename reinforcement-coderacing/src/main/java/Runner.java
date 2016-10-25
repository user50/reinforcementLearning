import trivial.CodeRaceController;
import com.coderacing.model.Car;
import com.coderacing.model.Game;
import com.coderacing.model.Move;
import com.coderacing.model.PlayerContext;

import java.io.IOException;

public final class Runner {
    private final RemoteProcessClient remoteProcessClient;
    private final String token;
    private CodeRaceController strategy;

    public Runner(String[] args, CodeRaceController strategy) throws IOException {
        remoteProcessClient = new RemoteProcessClient(args[0], Integer.parseInt(args[1]));
        token = args[2];
        this.strategy = strategy;
    }

    public void run() throws IOException {
        try {
            remoteProcessClient.writeToken(token);
            int teamSize = remoteProcessClient.readTeamSize();
            remoteProcessClient.writeProtocolVersion();
            Game game = remoteProcessClient.readGameContext();

            CodeRaceController[] strategies = new CodeRaceController[teamSize];

            for (int strategyIndex = 0; strategyIndex < teamSize; ++strategyIndex) {
                strategies[strategyIndex] = strategy;
            }

            PlayerContext playerContext;

            while ((playerContext = remoteProcessClient.readPlayerContext()) != null) {
                Car[] playerCars = playerContext.getCars();
                if (playerCars == null || playerCars.length != teamSize) {
                    break;
                }

                Move[] moves = new Move[teamSize];

                for (int carIndex = 0; carIndex < teamSize; ++carIndex) {
                    Car playerCar = playerCars[carIndex];

                    Move move = new Move();
                    moves[carIndex] = move;
                    strategies[playerCar.getTeammateIndex()].move(
                            playerCar, playerContext.getWorld(), game, move
                    );
                }

                remoteProcessClient.writeMoves(moves);
            }
        } finally {
            remoteProcessClient.close();
        }
    }
}
