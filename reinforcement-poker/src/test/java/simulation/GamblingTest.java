package simulation;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

public class GamblingTest {


    @Test
    public void testOnCheck() throws Exception {
        Gambling gambling = new Gambling(new HashMap<>(), 10);
        Gambler gambler = new TestGambler(100);

        gambling.onCheck(gambler);

        Assert.assertEquals(gambler.getMoney(), 100);
        Assert.assertEquals(gambling.getBank(), 0);
    }

    @Test
    public void testOnFold() throws Exception {
        Gambling gambling = new Gambling(new HashMap<>(), 10);
        Gambler gambler = new TestGambler(100);

        gambling.onFold(gambler);

        Assert.assertEquals(gambler.getMoney(), 100);
        Assert.assertEquals(gambling.getBank(), 0);
    }

    @Test
    public void testOnBet() throws Exception {
        Gambling gambling = new Gambling(new HashMap<>(), 10);
        Gambler gambler = new TestGambler(100);

        gambling.onBet(gambler);

        Assert.assertEquals(gambler.getMoney(), 100 - 10);
        Assert.assertEquals(gambling.getBank(), 10);
    }

    @Test
    public void testOnRaise() throws Exception {
        Gambling gambling = new Gambling(new HashMap<>(), 10);
        Gambler firstGambler = new TestGambler(100);
        Gambler secondGambler = new TestGambler(100);

        gambling.onBet(firstGambler);
        gambling.onRaise(secondGambler);

        Assert.assertEquals(firstGambler.getMoney(), 100 - 10);
        Assert.assertEquals(secondGambler.getMoney(), 100 - 20);
        Assert.assertEquals(gambling.getBank(), 30);

    }

    @Test
    public void testOnCall() throws Exception {
        Gambling gambling = new Gambling(new HashMap<>(), 10);
        Gambler firstGambler = new TestGambler(100);
        Gambler secondGambler = new TestGambler(100);

        gambling.onBet(firstGambler);
        gambling.onCall(secondGambler);

        Assert.assertEquals(firstGambler.getMoney(), 100 - 10);
        Assert.assertEquals(secondGambler.getMoney(), 100 - 10);
        Assert.assertEquals(gambling.getBank(), 20);

    }

    @Test
    public void testOnRaiseTwoTimes() throws Exception {
        Gambling gambling = new Gambling(new HashMap<>(), 10);
        Gambler firstGambler = new TestGambler(100);
        Gambler secondGambler = new TestGambler(100);
        Gambler thirdGambler = new TestGambler(100);

        gambling.onBet(firstGambler);
        gambling.onRaise(secondGambler);
        gambling.onRaise(thirdGambler);

        Assert.assertEquals(firstGambler.getMoney(), 100 - 10);
        Assert.assertEquals(secondGambler.getMoney(), 100 - 20);
        Assert.assertEquals(thirdGambler.getMoney(), 100 - 30);
        Assert.assertEquals(gambling.getBank(), 60);

    }

    private static class TestGambler extends Gambler
    {

        public TestGambler(int money) {
            super(money);
        }

        @Override
        public Action makeDecision() {
            return null;
        }
    }
}


