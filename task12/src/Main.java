public class Main {

    public static void main(String[] args) {
        int length = 1000000;
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

    private static void parallelMergeSort(int[] array, int start, int end, int count){
        if(end - start > 0){
            if (count <= 1){
                mergeSort(array, start, end);
            } else {
                Thread leftArray = new Thread(){
                    public void run(){
                        parallelMergeSort(array, start, end/2, count - 1);
                    }
                };
                Thread rightArray = new Thread(){
                    public void run(){
                        parallelMergeSort(array, (end/2 + 1), end, count - 1);
                    }
                };
                leftArray.start();
                rightArray.start();

                try {
                    leftArray.join();
                    rightArray.join();
                } catch (InterruptedException e){
                    e.printStackTrace();
                }

                merge(array, start, end/2, end);
            }
        }
    }

    private static void mergeSort(int[] array, int start, int end) {
        if (start == end) {
            return;
        }
        if (end - start > 0) {
            mergeSort(array, start, (start + end) / 2);
            mergeSort(array, (start + end) / 2 + 1, end);
            merge(array, start, (start + end) / 2, end);
        }
    }

    private static void merge(int[] array, int start, int mid, int end) {
        int[] newArray = new int[array.length];
        int begin1 = start;
        int begin2 = mid + 1;
        int index = start;
        while(begin1 <= mid && begin2 <= end)
        {
            if(array[begin1]<array[begin2])
            {
                newArray[index] = array[begin1];
                begin1 = begin1 + 1;
            }
            else
            {
                newArray[index] = array[begin2];
                begin2 = begin2+1;
            }
            index++;
        }
        if(begin1 > mid)
        {
            while(begin2 <= end)
            {
                newArray[index] = array[begin2];
                index++;
                begin2++;
            }
        }
        else
        {
            while(begin1 <= mid)
            {
                newArray[index] = array[begin1];
                index++;
                begin1++;
            }
        }
        int k = start;
        while(k < index)
        {
            array[k] = newArray[k];
            k++;
        }
    }
}


