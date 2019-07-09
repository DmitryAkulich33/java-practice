import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите количество сотрудников");
        int[] dataAboutWorkers = new int[scanner.nextInt()];

        System.out.println("Введите входные данные для каждого сотрудника");
        for (int i = 0; i < dataAboutWorkers.length; i++) {
            dataAboutWorkers[i] = scanner.nextInt();
        }

        int answer = 0;


        for (int i = 0; i < dataAboutWorkers.length; i++) {
            int group = 0;
            int temp = i;
            do {
                temp = dataAboutWorkers[temp] - 1;
                group++;

            } while (temp >= 0);
            if (answer <= group) {
                answer = group;
            }
        }
        System.out.println("Ответ: " + answer);
    }
}
