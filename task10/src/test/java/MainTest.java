import org.junit.Assert;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class MainTest {

    @Test
    public void reverse() {
        Map<Integer, String> map = new HashMap<>();

        map.put(1, "Dima");
        map.put(2, "Kate");
        map.put(3, "Dima");
        map.put(4, "Anna");
        map.put(5, "Stas");

        Main main = new Main();
        Map<String, Collection<Integer>> result = Main.reverse(map);
        Assert.assertTrue(result.containsKey("Dima"));
        Assert.assertTrue(result.containsKey("Kate"));
        Assert.assertTrue(result.containsKey("Anna"));
        Assert.assertTrue(result.containsKey("Stas"));
        Assert.assertTrue(result.containsValue(Collections.singletonList(2)));
        Assert.assertTrue(result.containsValue(Collections.singletonList(4)));
        Assert.assertTrue(result.containsValue(Collections.singletonList(5)));
        Assert.assertTrue(result.containsValue(Arrays.asList(1,3)));
    }
}