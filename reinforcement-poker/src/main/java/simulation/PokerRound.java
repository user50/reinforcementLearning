package simulation;

import java.util.List;

/**
 * Created by user50 on 08.05.2015.
 */
public class PokerRound {

    private List<? extends Gambler> pokerPlayers;
    private Gambling gambling;

    public PokerRound(List<? extends Gambler> pokerPlayers, Gambling gambling) {
        this.pokerPlayers = pokerPlayers;
        this.gambling = gambling;
    }

    public void play()
    {
        int raisedPlayer = 0;
        int turn = 0;

        do {
            Gambler gambler = pokerPlayers.get(turn % pokerPlayers.size());
            Action action = gambler.makeDecision();

            switch (action)
            {
                case fold:
                    pokerPlayers.remove(turn % pokerPlayers.size());
                    gambling.onFold(gambler);
                    break;

                case check:
                    turn++;
                    gambling.onCheck(gambler);
                    break;

                case raise:
                    raisedPlayer = turn % pokerPlayers.size();
                    turn++;
                    gambling.onRaise(gambler);
                    break;

                case bet:
                    raisedPlayer = turn % pokerPlayers.size();
                    turn++;
                    gambling.onBet(gambler);
                    break;

                case call:
                    turn++;
                    gambling.onCall(gambler);
                    break;

                default:
                    throw new IllegalArgumentException("Not supported action "+action);
            }

        }while ( turn % pokerPlayers.size() != raisedPlayer );
    }

}
