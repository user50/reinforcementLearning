package simulation;

import com.google.common.collect.Iterables;

import java.util.Iterator;
import java.util.List;

/**
 * Created by lozov on 13.05.15.
 */
public class CircularList<T> {
    private final Iterator<T> iterator;
    private int size;

    public CircularList(List<T> list) {
        this.size = list.size();
        this.iterator = Iterables.cycle(list).iterator();
    }

    public int getSize() {
        return size;
    }

    public T getOne() {
        final T element = this.iterator.next();
        return element;
    }

    public void cycleAndRemove(Condition<T> condition){
        while (size > 1){
            T nextElement = iterator.next();
            if (condition.isCondition(nextElement)){
                iterator.remove();
                size--;
            }
        }
    }

    public void print() {
        for(int i = 0; i < size; i++)
            System.out.println(iterator.next());
    }
}
