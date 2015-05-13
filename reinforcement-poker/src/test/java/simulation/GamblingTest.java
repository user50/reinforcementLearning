package simulation;

import junit.framework.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GamblingTest {

    @Test
    public void testAllCheck() throws Exception {
        List<ActionCountGambler> gamblers = Arrays.asList(new CheckGambler(), new CheckGambler());
        Gambling gambling = new Gambling(gamblers);

        gambling.play();

        for (ActionCountGambler gambler : gamblers)
            Assert.assertEquals(1, gambler.getCount());
    }

    @Test
    public void testSecondFold() throws Exception {
        List<ActionCountGambler> gamblers = Arrays.asList(new CheckGambler(), new FoldGambler());
        Gambling gambling = new Gambling(new ArrayList<>(gamblers));

        gambling.play();

        for (ActionCountGambler gambler : gamblers)
            Assert.assertEquals(1, gambler.getCount());

    }

    @Test
    public void testSecondRaise() throws Exception {

        List<ActionCountGambler> gamblers = Arrays.asList(new CheckGambler(), new RaiseGambler());
        Gambling gambling = new Gambling(new ArrayList<>(gamblers));

        gambling.play();

        Assert.assertEquals(2, gamblers.get(0).getCount());
        Assert.assertEquals(1, gamblers.get(1).getCount());
    }

    @Test
    public void testSecondFoldThirdRaise() throws Exception {
        List<ActionCountGambler> gamblers = Arrays.asList(new CheckGambler(), new RaiseGambler(), new FoldGambler());
        Gambling gambling = new Gambling(new ArrayList<>(gamblers));

        gambling.play();

        Assert.assertEquals(2, gamblers.get(0).getCount());
        Assert.assertEquals(1, gamblers.get(1).getCount());
        Assert.assertEquals(1, gamblers.get(2).getCount());

    }
}