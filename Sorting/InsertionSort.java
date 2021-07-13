import java.util.*;

class InsertionSort {
    public static int[] sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = i;
            int j = i - 1;
            while (j >= 0) {
                if (arr[j] > arr[key]) {
                    int temp = arr[j];
                    arr[j] = arr[key];
                    arr[key] = temp;
                    key = j;
                }
                j--;
            }
        }
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
