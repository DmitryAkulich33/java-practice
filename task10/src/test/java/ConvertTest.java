import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class ConvertTest {

    @Test
    public void convert() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Иван");
        map.put(2, "Дима");
        map.put(3, "Дима");
        map.put(4, "Сергей");
        map.put(5, "Иван");

        Convert conv = new Convert();
        Map<Integer, String> res = conv.convert(map);
        Assert.assertTrue(res.containsKey("Иван"));



    }
}