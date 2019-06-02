import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Integer, String> map = new Convert<>();
        map.put(1, "Иван");
        map.put(2, "Дима");
        map.put(3, "Дима");
        map.put(4, "Сергей");
        map.put(5, "Иван");
        ((Convert<Integer, String>) map).convert(map);
    }


}
