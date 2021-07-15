import java.util.*;

public class HeapSort {
    public static int[] sort(int[] arr) {
        for (int i = (arr.length - 1) / 2; i >= 1; i--) {
            heapify(arr, arr.length, i);
        }
        System.out.println(Arrays.toString(arr));
        for (int i = arr.length - 1; i >= 1; i--) {
            swap(arr, 1, i);
            heapify(arr, i - 1, 1);
        }
        return arr;
    }

    public static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int l = (2 * i);
        int r = (2 * i) + 1;
        if (l <= n && arr[l] > arr[largest]) {
            largest = l;
        }
        if (r <= n && arr[r] > arr[largest]) {
            largest = r;
        }
        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, n, largest);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the numbers in array:");
        String[] str_numbers = scanner.nextLine().split(", ");
        int[] numbers = new int[str_numbers.length + 1];
        for (int i = 1; i <= str_numbers.length; i++) {
            numbers[i] = Integer.parseInt(str_numbers[i - 1]);
        }
        scanner.close();
        int[] sorted_arr = sort(numbers);
        System.out.println(Arrays.toString(sorted_arr));
    }
}
