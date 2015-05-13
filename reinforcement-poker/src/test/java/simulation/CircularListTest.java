package simulation;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;

import static junit.framework.Assert.*;

/**
 * Created by lozov on 13.05.15.
 */
public class CircularListTest {

    @Test
    public void testIntegerList() throws Exception {
        List<Integer> list = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        CircularList<Integer> circularList = new CircularList<>(list);

        circularList.cycleAndRemove(new HeadsAndTailsCondition());

        assertEquals(circularList.getSize(), 1);
    }
}
