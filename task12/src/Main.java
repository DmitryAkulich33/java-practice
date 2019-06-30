public class Main {

    public static void main(String[] args) {
        int length = 10000000;
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = (int) (Math.random() * 50);
        }
        int countsOfThreads = 8;
        long startTime1 = System.currentTimeMillis();
        parallelMergeSort(arr, 0, length - 1, countsOfThreads);
        long endTime1 = System.currentTimeMillis();
        System.out.println(endTime1 - startTime1);

    }

    private static void parallelMergeSort(int[] array, int start, int end, int count) {
        if (end - start > 0) {
            if (count <= 1) {
                mergeSort(array, start, end);
            } else {
                Thread leftArray = new Thread() {
                    public void run() {
                        parallelMergeSort(array, start, end / 2, count / 2);
                    }
                };
                Thread rightArray = new Thread() {
                    public void run() {
                        parallelMergeSort(array, (end / 2 + 1), end, count / 2);
                    }
                };
                leftArray.start();
                rightArray.start();

                try {
                    leftArray.join();
                    rightArray.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                merge(array, start, end / 2, end);
            }
        }
    }

    public static void mergeSort(int[] array, int start, int end) {
        if (start < end) {
//            int mid = (start + end) / 2;
            mergeSort(array, start, (start + end) / 2);
            mergeSort(array, (start + end) / 2 + 1, end);
            merge(array, start, (start + end) / 2, end);
        }
    }

    private static void merge(int[] array, int start, int mid, int end) {

        int n = end - start + 1;
        int[] Temp = new int[n];

        int i = start;
        int j = mid + 1;
        int k = 0;

        while (i <= mid || j <= end) {
            if (i > mid)
                Temp[k++] = array[j++];
            else if (j > end)
                Temp[k++] = array[i++];
            else if (array[i] < array[j])
                Temp[k++] = array[i++];
            else
                Temp[k++] = array[j++];
        }
        for (j = 0; j < n; j++)
            array[start + j] = Temp[j];
    }
}


