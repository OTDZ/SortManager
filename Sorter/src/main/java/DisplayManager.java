import java.util.Arrays;
import java.util.Scanner;

public class DisplayManager {

    // View

    public void displayAlgorithms(){

        // Sort algorithms implemented so far:
        // 1. Bubble Sort
        // 2. Merge Sort

        System.out.println("Choose a sorting algorithm: ");
        System.out.println("1. Bubble Sort");
        System.out.println("2. Merge Sort");

    }

    public void displayArrayLength(){
        System.out.print("Enter array length: ");
    }

    public void displayUnsortedArray(int[] unsortedArray, Sorter sorter){
        System.out.println("The unsorted array: " + Arrays.toString(unsortedArray));
        System.out.print("The selected sorting algorithm is " + sorter.toString());
    }

    public void displayResults(int[] sortedArray, double timeTaken){
        System.out.println("The sorted array: " + Arrays.toString(sortedArray));
        System.out.println("The algorithm took " + timeTaken + " seconds to sort!");
    }

}
