import org.junit.Assert;
import org.junit.Test;

import java.util.function.Predicate;

import static org.junit.Assert.*;

public class QueuelmplTest {

    @Test
    public void add() {
        Queuelmpl<Integer> queuelmpl = new Queuelmpl<>();
        queuelmpl.add(3);
        queuelmpl.add(4);

        Assert.assertEquals(3, (int)queuelmpl.peek());
    }

    @Test
    public void peek() {
        Queuelmpl<Integer> queuelmpl = new Queuelmpl<>();
        queuelmpl.add(1);
        queuelmpl.add(2);
        queuelmpl.add(3);

        Assert.assertEquals(1, (int)queuelmpl.peek());
    }

    @Test
    public void pop() {
        Queuelmpl<Integer> queuelmpl = new Queuelmpl<>();

        Assert.assertNull(queuelmpl.pop());

        queuelmpl.add(1);
        queuelmpl.add(2);


        Assert.assertEquals(1, (int)queuelmpl.pop());
        Assert.assertEquals(2, (int)queuelmpl.pop());
        Assert.assertNull(queuelmpl.pop());
    }

    @Test
    public void addAll() {
        Queuelmpl<Integer> queuelmpl = new Queuelmpl<>();
        queuelmpl.add(1);
        queuelmpl.add(2);
        queuelmpl.add(3);

        Queuelmpl<Integer> queuelmpl2 = new Queuelmpl<>();
        queuelmpl2.add(4);
        queuelmpl2.add(5);

        queuelmpl.addAll(queuelmpl2);

        queuelmpl.pop();
        queuelmpl.pop();
        queuelmpl.pop();

        Assert.assertEquals(4, (int)queuelmpl.peek());
        queuelmpl.pop();
        queuelmpl.pop();

        Assert.assertNull(queuelmpl.peek());
    }

    @Test
    public void indexOf() {
        Queuelmpl<Integer> queuelmpl = new Queuelmpl<>();
        Predicate<Integer> predicate = new Predicate<Integer>() {
            @Override
            public boolean test(Integer x) {
                return x > 0;
            }
        };

        queuelmpl.add(1);
        queuelmpl.add(-1);

        Assert.assertEquals(0, queuelmpl.indexOf(predicate));
        queuelmpl.pop();
        Assert.assertEquals(-1, queuelmpl.indexOf(predicate));
    }
}