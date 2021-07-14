import java.util.*;

public class CountSort {
    public static int[] sort(int[] arr) {
        int len = arr.length;
        int k = -1;
        for (int i = 0; i < len; i++) {
            if (k < arr[i]) {
                k = arr[i];
            }
        }
        int[] count = new int[k + 1];
        for (int i = 0; i < len; i++) {
            ++count[arr[i]];
        }

        for (int i = 1; i <= k; i++) {
            count[i] = count[i] + count[i - 1];
        }

        int[] sorted_arr = new int[len];
        for (int i = len - 1; i >= 0; i--) {
            sorted_arr[--count[arr[i]]] = arr[i];
        }
        return sorted_arr;
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
