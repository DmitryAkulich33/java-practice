import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int length = 10000000;
        int[] arr = new int[length];
        for(int i = 0; i < length; i++){
            arr[i] = (int)(Math.random() * 50);
        }

        int countsOfThreads1 = 1;
        int countsOfThreads2 = 2;
        int countsOfThreads3 = 8;

        long startTime1 = System.currentTimeMillis();
        parallelSortArray(arr, countsOfThreads1);
        long endTime1 = System.currentTimeMillis();
        System.out.println(endTime1 - startTime1);

        long startTime2 = System.currentTimeMillis();
        parallelSortArray(arr, countsOfThreads2);
        long endTime2 = System.currentTimeMillis();
        System.out.println(endTime2 - startTime2);

        long startTime3 = System.currentTimeMillis();
        parallelSortArray(arr, countsOfThreads3);
        long endTime3 = System.currentTimeMillis();
        System.out.println(endTime3 - startTime3);
    }

    private static void parallelSortArray(int[] array, int count) {
        if (count <= 1) {
            sortArray(array);
        } else if (array.length >= 2) {
            int[] arrayLeft = Arrays.copyOfRange(array, 0, array.length / 2);
            int[] arrayRight = Arrays.copyOfRange(array, array.length / 2, array.length);

            Thread leftThread = new Thread() {
                public void run() {
                    parallelSortArray(arrayLeft, count / 2);
                }
            };
            Thread rightThread = new Thread() {
                public void run() {
                    parallelSortArray(arrayRight, count / 2);
                }
            };

            leftThread.start();
            rightThread.start();

            try {
                leftThread.join();
                rightThread.join();
            } catch (InterruptedException e) {

            }
            mergeArray(arrayLeft, arrayRight);
        }
    }

    private static int[] sortArray(int[] array){
        if(array.length < 2){
            return array;
        }
        int middle = array.length/2;
        int[] arrayLeft = Arrays.copyOfRange(array, 0, middle);
        int[] arrayRight = Arrays.copyOfRange(array, middle, array.length);
        System.arraycopy(array, array.length/2, arrayRight, 0, array.length - array.length/2);
        arrayLeft = sortArray(arrayLeft);
        arrayRight = sortArray(arrayRight);
        return mergeArray(arrayLeft, arrayRight);
    }

    private static int[] mergeArray(int[] arrayA, int[] arrayB){
        int [] arrayC = new int[arrayA.length + arrayB.length];
        int positionA = 0;
        int positionB = 0;
        for (int i = 0; i < arrayC.length; i++) {
            if (positionA == arrayA.length){
                arrayC[i] = arrayB[positionB++];
            } else if (positionB == arrayB.length) {
                arrayC[i] = arrayA[positionA++];
            } else if (arrayA[positionA] < arrayB[positionB]) {
                arrayC[i] = arrayA[positionA++];
            } else {
                arrayC[i] = arrayB[positionB++];
            }
        }
        return arrayC;
    }
}

