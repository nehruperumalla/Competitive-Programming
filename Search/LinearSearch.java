import java.util.Scanner;

class LinearSearch {
    public static int search(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return ++i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the numbers in array:");
        String[] str_numbers = scanner.nextLine().split(", ");
        int[] numbers = new int[str_numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(str_numbers[i]);
        }
        System.out.println("Please enter the element to search:");
        int target = scanner.nextInt();
        scanner.close();
        int pos = search(numbers, target);
        System.out.printf("Your target found at %dth place", pos);
    }
}