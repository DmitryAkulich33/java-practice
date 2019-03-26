public class Main {

    public static void main(String[] args) {
        int[] array = {1, 3, -4, -5};
        int x = 0;
        for(int index = 0; index < array.length; index++){
            if (array[index] < 0){
                x = x + 1;
            }
        }
        System.out.println("Количество отрицательных элементов = " + x);


    }
}
