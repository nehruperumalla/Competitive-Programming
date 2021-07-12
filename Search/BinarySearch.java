import java.util.*;

public class BinarySearch {
    public static int binarySearch(int[] arr, int target) {
        int hi = arr.length;
        int lo = 0;
        while (lo < hi) {
            int mid = (hi + lo) / 2;
            if (arr[mid] < target) {
                lo = mid + 1;
            } else if (arr[mid] > target) {
                hi = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the numbers in array in increasing order:");
        String[] str_numbers = scanner.nextLine().split(", ");
        int[] numbers = new int[str_numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(str_numbers[i]);
        }
        System.out.println("Please enter the element to search:");
        int target = scanner.nextInt();
        scanner.close();
        int pos = binarySearch(numbers, target);
        System.out.printf("Your target found at %dth place", pos);
    }
}
