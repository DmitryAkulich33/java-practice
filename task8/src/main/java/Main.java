import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {
        Queuelmpl<Integer> queuelmpl = new Queuelmpl<>(6);
        Queuelmpl<Integer> queuelmpl2 = new Queuelmpl<>(3);
        Predicate<Integer> predicate = new Predicate<Integer>() {
            @Override
            public boolean test(Integer x) {
                return x > 0;
            }
        };

        queuelmpl.add(1);
        queuelmpl.add(2);
        queuelmpl.add(3);
        queuelmpl.add(4);
        queuelmpl.add(5);
        queuelmpl.add(6);

        queuelmpl2.add(7);
        queuelmpl2.add(8);
        queuelmpl2.add(9);

        queuelmpl.addAll(queuelmpl2);

        queuelmpl.peek();
        queuelmpl.pop();

        queuelmpl.indexOf(predicate);
    }


}
