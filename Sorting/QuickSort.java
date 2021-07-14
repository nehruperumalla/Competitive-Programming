import java.util.*;

public class QuickSort {
    public static int partition(int[] arr, int lb, int ub) {
        int pivot = lb;
        int start = lb;
        int end = ub;
        while (start < end) {
            while (arr[start] <= arr[pivot]) {
                start++;
            }
            while (arr[end] > arr[pivot]) {
                end--;
            }

            if (start < end) {
                swap(arr, start, end);
            }
        }
        swap(arr, pivot, end);
        return end;
    }

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void sort(int[] arr, int lb, int ub) {
        if (ub < lb)
            return;
        int pivot = partition(arr, lb, ub);
        sort(arr, lb, pivot - 1);
        sort(arr, pivot + 1, ub);
    }

    public static int[] sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
        return arr;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the numbers in array:");
        String[] str_numbers = scanner.nextLine().split(", ");
        int[] numbers = new int[str_numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(str_numbers[i]);
        }
        scanner.close();
        int[] sorted_arr = sort(numbers);
        System.out.println(Arrays.toString(sorted_arr));
    }
}
