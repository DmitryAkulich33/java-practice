import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {

    private  static final int count = 1000000;

    public static void main(String[] args) {

        List arrayList = new ArrayList();
        List linkedList = new LinkedList();

        long beginTime1 = System.currentTimeMillis();
        addElem(arrayList);
        long beginTime2 = System.currentTimeMillis();
        System.out.println("Скорость заполнения Arraylist равна: " + (beginTime2 - beginTime1));

        long beginTime3 = System.currentTimeMillis();
        addElem(linkedList);
        long beginTime4 = System.currentTimeMillis();
        System.out.println("Скорость заполнения LinkedList равна: " + (beginTime4 - beginTime3));

        System.out.println();

        long beginTime5 = System.currentTimeMillis();
        setElem(arrayList);
        long beginTime6 = System.currentTimeMillis();
        System.out.println("Скорость выборки чисел наугад в ArraiList равна: " + (beginTime6 - beginTime5));

        long beginTime7 = System.currentTimeMillis();
        setElem(linkedList);
        long beginTime8 = System.currentTimeMillis();
        System.out.println("Скорость выборки чисел наугад в LinkedList равна: " + (beginTime8 - beginTime7));
    }

    public static void addElem(List list){
        for(int i = 0; i < count; i++){
            list.add((int)(Math.random() * 100));
        }
    }

    public static void setElem(List list){
        for(int i = 0; i < count; i++){
            list.get((int)(Math.random()* count));
        }
    }
}
