package com.sparta.display;

import com.sparta.sorters.Sorter;

import java.util.Arrays;
import java.util.Scanner;

public class DisplayManager {

    // View

    public void displayAlgorithms(){

        // Sort algorithms implemented so far:
        // 1. Bubble Sort
        // 2. Merge Sort
        // 3. Tree Sort

        System.out.println("Choose a sorting algorithm: ");
        System.out.println("1. Bubble Sort");
        System.out.println("2. Merge Sort");
        System.out.println("3. Tree Sort");

    }

    public void displayArrayLength(){
        System.out.print("Enter array length: ");
    }

    public void displayUnsortedArray(int[] unsortedArray, Sorter sorter){
        System.out.println();
        System.out.println("The unsorted array: " + Arrays.toString(unsortedArray));
        System.out.println("The selected sorting algorithm is " + sorter.toString());
    }

    public void displayResults(int[] sortedArray, double timeTaken){
        System.out.println();
        System.out.println("The sorted array: " + Arrays.toString(sortedArray));
        System.out.println("The algorithm took " + timeTaken + " seconds to sort!");
    }

}
