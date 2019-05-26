import java.util.ArrayList;
import java.util.function.Predicate;

public class Queuelmpl<T> implements Queue<T> {
    private ArrayList<T> myList;
    private final int CAPACITY = 5;
    private int beginIndex = 0;

    Queuelmpl() {
        myList = new ArrayList<>(CAPACITY);
    }

    Queuelmpl(int size) {
        myList = new ArrayList<>(size);
    }

    @Override
    public void add(T elem) {
        myList.add(elem);
    }

    @Override
    public T peek() {
        if (beginIndex == myList.size()) {
            return null;
        } else {
            return myList.get(beginIndex);
        }
    }

    @Override
    public T pop() {
        if (beginIndex == myList.size()) {
            return null;
        } else {
            T elem = myList.get(beginIndex);
            myList.set(beginIndex, null);
            beginIndex++;
            return elem;
        }
    }

    void addAll(Queuelmpl<? extends T> other) {
        for (int i = other.beginIndex; i < other.myList.size(); i++) {
            myList.add(other.myList.get(i));
        }
    }

    int indexOf(Predicate<T> predicate) {
        for (int i = beginIndex; i < myList.size(); i++) {
            if (predicate.test(myList.get(i))) {
                return i - beginIndex;
            }
        }
        return -1;
    }
}
