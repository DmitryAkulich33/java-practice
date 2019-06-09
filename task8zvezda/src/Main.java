import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        ArrayList<Integer> list2 = new ArrayList<Integer>();

        int count;                                        // номер группы, в которую следует отнести работника
        int x;                                            // вспомогательная переменная для расчетов
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите количество сотрудников");
        int worker = scanner.nextInt();

        System.out.println("Введите входные данные для каждого сотрудника");
        for (int i = 0; i < worker; i++) {
            list1.add(scanner.nextInt());
        }

        for (int i = 0; i < list1.size(); i++) {
            count = 0;
            x = i;
            do {
                x = list1.get(x);
                x--;
                count++;
            } while (x >= 0);
            list2.add(count);                            // заполняем аррайлист номерами групп
        }

        int answer = list2.get(0);
        for (int i = 1; i < list2.size() - 1; i++) {     // находим максимальное значение
            if (answer < list2.get(i)) {
                answer = list2.get(i);
            }
        }
        System.out.println("Ответ: " + answer);
    }
}
