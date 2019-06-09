import java.util.*;
import java.util.function.BiFunction;


public class Main {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Dima");
        map.put(2, "Kate");
        map.put(3, "Dima");
        map.put(4, "Anna");
        map.put(5, "Stas");

        System.out.println(map);
        System.out.println(reverse(map));
    }

    public static <K, V> HashMap<V, Collection<K>> reverse(Map<? extends K, ? extends V> map) {
        HashMap<V, Collection<K>> rev = new HashMap<>();
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            rev.compute(entry.getValue(), new BiFunction<V, Collection<K>, Collection<K>>() {
                @Override
                public Collection<K> apply(V v, Collection<K> ks) {
                    if (ks == null) {
                        ks = new ArrayList<>();
                    }
                    ks.add(entry.getKey());
                    return ks;
                }
            });
        }
        return rev;
    }
}
