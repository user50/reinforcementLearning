package simulation;

import com.google.common.collect.Maps;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class GamblingTest {


    @Test
    public void testOnCheck() throws Exception {
        Gambler gambler = new TestGambler(100);
        Gambling gambling = new Gambling(createTestGamblers(gambler), 10);

        gambling.onCheck(gambler);

        Assert.assertEquals(gambler.getMoney(), 100);
        Assert.assertEquals(gambling.getBank(), 0);
    }

    @Test
    public void testOnFold() throws Exception {
        Gambler gambler = new TestGambler(100);
        Gambling gambling = new Gambling(createTestGamblers(gambler), 10);

        gambling.onFold(gambler);

        Assert.assertEquals(gambler.getMoney(), 100);
        Assert.assertEquals(gambling.getBank(), 0);
    }

    @Test
    public void testOnBet() throws Exception {
        Gambler gambler = new TestGambler(100);
        Gambling gambling = new Gambling(createTestGamblers(gambler), 10);

        gambling.onBet(gambler);

        Assert.assertEquals(gambler.getMoney(), 100 - 10);
        Assert.assertEquals(gambling.getBank(), 10);
    }

    @Test
    public void testOnRaise() throws Exception {
        Gambler firstGambler = new TestGambler(100);
        Gambler secondGambler = new TestGambler(100);
        Gambling gambling = new Gambling(createTestGamblers(firstGambler, secondGambler), 10);

        gambling.onBet(firstGambler);
        gambling.onRaise(secondGambler);

        Assert.assertEquals(firstGambler.getMoney(), 100 - 10);
        Assert.assertEquals(secondGambler.getMoney(), 100 - 20);
        Assert.assertEquals(gambling.getBank(), 30);

    }

    @Test
    public void testOnCall() throws Exception {
        Gambler firstGambler = new TestGambler(100);
        Gambler secondGambler = new TestGambler(100);
        Gambling gambling = new Gambling(createTestGamblers(firstGambler, secondGambler), 10);

        gambling.onBet(firstGambler);
        gambling.onCall(secondGambler);

        Assert.assertEquals(firstGambler.getMoney(), 100 - 10);
        Assert.assertEquals(secondGambler.getMoney(), 100 - 10);
        Assert.assertEquals(gambling.getBank(), 20);

    }

    @Test
    public void testOnRaiseTwoTimes() throws Exception {
        Gambler firstGambler = new TestGambler(100);
        Gambler secondGambler = new TestGambler(100);
        Gambler thirdGambler = new TestGambler(100);
        Gambling gambling = new Gambling(createTestGamblers(firstGambler, secondGambler, thirdGambler), 10);

        gambling.onBet(firstGambler);
        gambling.onRaise(secondGambler);
        gambling.onRaise(thirdGambler);

        Assert.assertEquals(firstGambler.getMoney(), 100 - 10);
        Assert.assertEquals(secondGambler.getMoney(), 100 - 20);
        Assert.assertEquals(thirdGambler.getMoney(), 100 - 30);
        Assert.assertEquals(gambling.getBank(), 60);

    }

    @Test(expected = IllegalStateException.class)
    public void testOnCheckValidation() throws Exception {
        Gambler gambler = new TestGambler(100);
        Map<Gambler, Integer> gamblersMap = new HashMap<>();
        gamblersMap.put(gambler, 10);
        Gambling gambling = new Gambling(gamblersMap, 10);

        gambling.onCheck(gambler);
    }

    private Map<Gambler, Integer> createTestGamblers(Gambler... gamblers){
        Map<Gambler, Integer> gamblersMap = new HashMap<>();
        for (Gambler gambler : gamblers) {
            gamblersMap.put(gambler, 0);
        }

        return gamblersMap;
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


