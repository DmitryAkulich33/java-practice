public class Main {

    public static void main(String[] args) {
        int[][] array = {{1, 2, 1}, {3, 4, 5}, {6, 7, 8}};
        System.out.println("Элементы главной диагонали матрицы:");
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (i == j) {
                    System.out.print(array[i][j] + " ");
                }
            }
        }
        System.out.println();
        System.out.println("Все элементы матрицы:");
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("Элементы побочной диагонали, которые больше суммы индексов:");
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (j == array.length - i - 1 && array[i][j] > i + j) {
                    System.out.print(array[i][j] + " ");
                }
            }
        }
    }
}
