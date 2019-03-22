import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Введите имя и фамилию");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.println(name + " - начинающий Java программист!");
    }
}