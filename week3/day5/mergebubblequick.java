import java.util.Random;

public class SortingComparison {

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) L[i] = arr[left + i];
        for (int j = 0; j < n2; j++) R[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2)
            arr[k++] = (L[i] <= R[j]) ? L[i++] : R[j++];

        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high], i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int tmp = arr[i]; arr[i] = arr[j]; arr[j] = tmp;
            }
        }
        int tmp = arr[i + 1]; arr[i + 1] = arr[high]; arr[high] = tmp;
        return i + 1;
    }

    public static int[] generateData(int size) {
        Random rand = new Random();
        int[] data = new int[size];
        for (int i = 0; i < size; i++)
            data[i] = rand.nextInt(size * 10);
        return data;
    }

    public static void testSorting(int size) {
        System.out.println("Dataset Size: " + size);

        int[] data1 = generateData(size);
        int[] data2 = data1.clone();
        int[] data3 = data1.clone();

        if (size <= 10000) {
            long start = System.nanoTime();
            bubbleSort(data1);
            long time = System.nanoTime() - start;
            System.out.println("Bubble Sort: " + time / 1_000_000.0 + " ms");
        } else {
            System.out.println("Bubble Sort: Skipped (Too slow)");
        }

        long start = System.nanoTime();
        mergeSort(data2, 0, data2.length - 1);
        long mergeTime = System.nanoTime() - start;
        System.out.println("Merge Sort: " + mergeTime / 1_000_000.0 + " ms");

        start = System.nanoTime();
        quickSort(data3, 0, data3.length - 1);
        long quickTime = System.nanoTime() - start;
        System.out.println("Quick Sort: " + quickTime / 1_000_000.0 + " ms");

        System.out.println();
    }

    public static void main(String[] args) {
        testSorting(1000);
        testSorting(10000);
        testSorting(1000000);
    }
}