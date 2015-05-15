package simulation;

import junit.framework.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.mock;

public class PokerRoundTest {

    @Test
    public void testAllCheck() throws Exception {

        List<ActionCountPokerPlayer> gamblers = Arrays.asList(new CheckPokerPlayer(), new CheckPokerPlayer());
        PokerRound pokerRound = new PokerRound(gamblers, mock(Gambling.class) );

        pokerRound.play();

        for (ActionCountPokerPlayer gambler : gamblers)
            Assert.assertEquals(1, gambler.getCount());
    }

    @Test
    public void testSecondFold() throws Exception {
        List<ActionCountPokerPlayer> gamblers = Arrays.asList(new CheckPokerPlayer(), new FoldPokerPlayer());
        PokerRound pokerRound = new PokerRound(new ArrayList<>(gamblers), mock(Gambling.class));

        pokerRound.play();

        for (ActionCountPokerPlayer gambler : gamblers)
            Assert.assertEquals(1, gambler.getCount());

    }

    @Test
    public void testSecondRaise() throws Exception {

        List<ActionCountPokerPlayer> gamblers = Arrays.asList(new CheckPokerPlayer(), new RaisePokerPlayer());
        PokerRound pokerRound = new PokerRound(new ArrayList<>(gamblers), mock(Gambling.class));

        pokerRound.play();

        Assert.assertEquals(2, gamblers.get(0).getCount());
        Assert.assertEquals(1, gamblers.get(1).getCount());
    }

    @Test
    public void testSecondFoldThirdRaise() throws Exception {
        List<ActionCountPokerPlayer> gamblers = Arrays.asList(new CheckPokerPlayer(), new RaisePokerPlayer(), new FoldPokerPlayer());
        PokerRound pokerRound = new PokerRound(new ArrayList<>(gamblers), mock(Gambling.class));

        pokerRound.play();

        Assert.assertEquals(2, gamblers.get(0).getCount());
        Assert.assertEquals(1, gamblers.get(1).getCount());
        Assert.assertEquals(1, gamblers.get(2).getCount());

    }
}