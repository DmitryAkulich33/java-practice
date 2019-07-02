import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    private static int length = 10000000;
    private static int[] arr = new int[length];

    public static void main(String[] args) {
        int countsOfThreads = 8;
        for (int i = 0; i < length; i++) {
            arr[i] = (int) (Math.random() * 50);
        }
        long startTime1 = System.currentTimeMillis();
        parallelMergeSort(arr, countsOfThreads);
        long endTime1 = System.currentTimeMillis();
        System.out.println(endTime1 - startTime1);
    }

    private static void parallelMergeSort(int[] array, int count) {
        ArrayList<Thread> threads = new ArrayList<>();
        for(int i = 0; i < count; i++){
            int left = i * length / count;
            int right = (i + 1) * length / count - 1;
            threads.add(new Thread(){
                public void run(){
                    mergeSort(array, left, right);
                }
            });
            threads.get(i).start();
        }
        try {
            threads.get(0).join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 1; i < count; i++){
            int left = i * length / count - 1;
            int right = (i + 1) * length / count - 1;
            try {
                threads.get(i).join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            merge(array, 0, left, right);
        }
    }

    private static void mergeSort(int[] array, int start, int end) {
        if (start < end) {
            mergeSort(array, start, (start + end) / 2);
            mergeSort(array, (start + end) / 2 + 1, end);
            merge(array, start, (start + end) / 2, end);
        }
    }

    private static void merge(int[] array, int start, int mid, int end) {
        int n = end - start + 1;
        int[] temp = new int[n];

        int i = start;
        int j = mid + 1;
        int k = 0;

        while (i <= mid || j <= end) {
            if (i > mid)
                temp[k++] = array[j++];
            else if (j > end)
                temp[k++] = array[i++];
            else if (array[i] < array[j])
                temp[k++] = array[i++];
            else
                temp[k++] = array[j++];
        }
        for (j = 0; j < n; j++)
            array[start + j] = temp[j];
    }
}


