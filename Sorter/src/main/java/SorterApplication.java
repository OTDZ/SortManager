import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class SorterApplication {

    public static void main(String[] args) {

        // Sort algorithms implemented so far:
        // 1. Bubble Sort
        // 2. Merge Sort

        BubbleSorter bubbleSorter = new BubbleSorter();
        MergeSorter mergeSorter = new MergeSorter();

        // Getting user input
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose a sorting algorithm: ");
        System.out.println("1. Bubble Sort");
        System.out.println("2. Merge Sort");
        int algorithm = scanner.nextInt();

        System.out.print("Enter array length: ");
        int arrayLength = scanner.nextInt();

        // Initialize arrays
        int[] arrayToSort = new int[arrayLength];
        int[] sortedArray = new int [arrayLength];

        // Randomly generate array
        Random random = new Random() ;
        for (int i = 0; i < arrayLength; i++){
            // Range is -200 to 200
            arrayToSort[i] = random.nextInt(-200, 200);
        }

        // Displaying unsorted array and sort algorithm to user
        System.out.println();
        System.out.println("The unsorted array: " + Arrays.toString(arrayToSort));
        System.out.print("The selected sorting algorithm is ");

        long startTime = System.nanoTime();

        switch (algorithm){
            case 1:
                System.out.println("Bubble Sort");
                sortedArray = bubbleSorter.sortArray(arrayToSort);
            case 2:
                System.out.println("Merge Sort");
                sortedArray = mergeSorter.sortArray(arrayToSort);
        }

        // Calculating time taken to sort in seconds
        long endTime = System.nanoTime();
        long sortTime = endTime - startTime;
        double sortTimeInSeconds = (double) sortTime / 1_000_000_000;

        // Displaying sorted array and time taken to user
        System.out.println();
        System.out.println("The sorted array: " + Arrays.toString(sortedArray));
        System.out.println("The algorithm took " + sortTimeInSeconds + " seconds to sort!");



    }

}
