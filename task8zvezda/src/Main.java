import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> dataAboutWorkers = new ArrayList<Integer>();
        ArrayList<Integer> listOfGroups = new ArrayList<Integer>();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите количество сотрудников");
        int worker = scanner.nextInt();

        System.out.println("Введите входные данные для каждого сотрудника");
        for (int i = 0; i < worker; i++) {
            dataAboutWorkers.add(scanner.nextInt());
        }

        for (int i = 0; i < dataAboutWorkers.size(); i++) {
            int group = 0;
            int x = i;
            do {
                x = dataAboutWorkers.get(x);
                x--;
                group++;
            } while (x >= 0);
            listOfGroups.add(group);
        }

        int answer = listOfGroups.get(0);
        for (int i = 1; i < listOfGroups.size() - 1; i++) {
            if (answer < listOfGroups.get(i)) {
                answer = listOfGroups.get(i);
            }
        }
        System.out.println("Ответ: " + answer);
    }
}
