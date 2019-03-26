import java.util.Scanner;

public class ArrayTask {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);          // объявляем сканер
        System.out.println("Введите размер массива");      // появляется строка 1
        int size = scanner.nextInt();                      // вводим размер массива
        int[] array = new int[size];                       // создаем массив с введенным размером
        System.out.println("Введите элементы массива");    // появляется строка 2
        for(int i = 0; i < size; i++){
            array[i] = scanner.nextInt();                  // заполняем массив
        }
        int sum = 0;                                       // вводим переменную sum
        for(int index = 0; index < array.length; index++){ // считаем сумму элементов массива
            sum = sum + array[index];
        }
        double average = 0;                                   // вводим переменную average
        average = (double) sum / size;                              // считаем среднее арифметическое массива
        System.out.println("sum = " + sum);                // выводим на экран сумму
        System.out.println("average = " + average);        // выводим на экран среднюю величину
    }
}
