import java.util.*;

public class RadixSort {
    // Complexity is O(d*(n+k))
    public static int[] sort(int[] arr) {
        int max = getMax(arr);
        for (int pos = 1; max / pos > 0; pos *= 10) {
            arr = countSort(arr, pos);
        }
        return arr;
    }

    public static int[] countSort(int[] arr, int pos) {
        int len = arr.length;
        int k = 10;

        int[] count = new int[k];

        for (int i = 0; i < len; i++) {
            ++count[(arr[i] / pos) % 10];
        }

        for (int i = 1; i < k; i++) {
            count[i] = count[i] + count[i - 1];
        }

        int[] sorted_arr = new int[len];
        for (int i = len - 1; i >= 0; i--) {
            sorted_arr[--count[(arr[i] / pos) % 10]] = arr[i];
        }
        return sorted_arr;
    }

    public static int getMax(int[] arr) {
        int max = -1;

        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        return max;
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
