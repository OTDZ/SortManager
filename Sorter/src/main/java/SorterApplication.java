import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class SorterApplication {

    public static void main(String[] args) {

        // Sort algorithms implemented so far:
        // 1. Bubble Sort


        // Getting user input
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose a sorting algorithm: ");
        System.out.println("1. Bubble Sort");
        System.out.println();
        int algorithm = scanner.nextInt();

        System.out.print("Enter array length: ");
        int arrayLength = scanner.nextInt();

        // Randomly generate array
        int[] array = new int[arrayLength];
        Random random = new Random() ;
        for (int i = 0; i < arrayLength; i++){
            // Range is -200 to 200
            array[i] = random.nextInt(-200, 200);
        }



    }

}
