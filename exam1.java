import java.util.Scanner;

public class NumberListImproved {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = new int[5]; // Initial size of the array
        int index = 0;

        while (true) {
            System.out.print("Number (enter 'q' to stop): ");
            String userInput = scanner.next();

            if (userInput.equalsIgnoreCase("q")) {
                break;
            }

            try {
                int number = Integer.parseInt(userInput);
                if (index == numbers.length) {
                    numbers = resizeArray(numbers);
                }
                numbers[index] = number;
                index++;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number or 'q' to stop.");
            }
        }

        displayEnteredNumbers(numbers, index);
        scanner.close();
    }

    private static int[] resizeArray(int[] oldArray) {
        int newSize = oldArray.length * 2;
        int[] newArray = new int[newSize];
        System.arraycopy(oldArray, 0, newArray, 0, oldArray.length);
        return newArray;
    }

    private static void displayEnteredNumbers(int[] numbers, int size) {
        System.out.println("\nEntered numbers:");
        for (int i = 0; i < size; i++) {
            System.out.print(numbers[i] + " ");
        }
    }
}
