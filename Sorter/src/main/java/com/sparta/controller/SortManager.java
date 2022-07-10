package com.sparta.controller;

import com.sparta.display.DisplayManager;
import com.sparta.enums.SorterType;
import com.sparta.exceptions.InvalidArrayLengthException;
import com.sparta.exceptions.InvalidInputException;
import com.sparta.logger.LoggerManager;
import com.sparta.sorters.Sorter;
import com.sparta.sorters.SorterFactory;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class SortManager {

    private SorterFactory sorterFactory;
    private Sorter sorter;
    private DisplayManager displayManager;
    private int algorithmChoice;
    private int arrayLength;
    private int[] arrayToSort;
    private int[] arrayToSortCopy;
    private int[] sortedArray;
    int algorithmCount;
    String compareChoice;

    public SortManager(int algorithmCount){
        this.sorterFactory = new SorterFactory();
        this.displayManager = new DisplayManager();
        this.algorithmCount = algorithmCount;
    }

    public void runSort() {

        getAlgorithmChoice();
        getArrayLength();

        sorter = createSorter(algorithmChoice);
        LoggerManager.logger.info("Sorter created: " + sorter.toString());

        arrayToSort = generateRandomArray(arrayLength);
        LoggerManager.logger.info("Array randomly generated");

        displayManager.displayUnsortedArray(arrayToSort, sorter);
        LoggerManager.logger.info("Unsorted array and sorting algorithm displayed to user");

        // Copy of original unsorted array for comparison
        arrayToSortCopy = Arrays.copyOfRange(arrayToSort, 0, arrayToSort.length);

        long startTime = System.nanoTime();

        sortedArray = sortArray(sorter, arrayToSort);
        LoggerManager.logger.info("Array sorted");

        // Calculating time taken to sort in seconds
        long endTime = System.nanoTime();
        long sortTime = endTime - startTime;
        double sortTimeInSeconds = (double) sortTime / 1_000_000_000;

        // Displaying final results
        displayManager.displayResults(sortedArray, sortTimeInSeconds);
        LoggerManager.logger.info("Sorted array and time taken displayed to user, time taken (seconds): " + sortTimeInSeconds);

        // Asking if user wants to compare
        getCompareChoice();

        if (compareChoice.equals("y")){
            runSortCompare(sorter.toString(), sortTimeInSeconds);
        }

    }

    public void runSortCompare(String algorithmOneName, double algorithmOneTime){

        getAlgorithmChoice();

        sorter = createSorter(algorithmChoice);
        LoggerManager.logger.info("Sorter created: " + sorter.toString());

        long startTime = System.nanoTime();

        sortedArray = sortArray(sorter, arrayToSortCopy);
        LoggerManager.logger.info("Array sorted");

        // Calculating time taken to sort in seconds
        long endTime = System.nanoTime();
        long sortTime = endTime - startTime;
        double sortTimeInSeconds = (double) sortTime / 1_000_000_000;

        displayManager.displayComparisonResults(algorithmOneName, algorithmOneTime, sorter.toString(), sortTimeInSeconds, arrayToSortCopy, sortedArray);

    }

    public void getCompareChoice(){

        boolean validChoice = false;

        while (!validChoice){

            try{
                compareChoice = getCompareChoiceInput();
                validChoice = true;
                LoggerManager.logger.info("User selected choice: " + compareChoice);
            }
            catch(InvalidInputException e){
                e.printStackTrace();
                System.out.println();
            }
            catch(InputMismatchException e){
                e.printStackTrace();
                System.out.println();
                LoggerManager.logger.error("User entered a non-integer during algorithm selection");
            }
            catch(Exception e){
                e.printStackTrace();
                System.out.println();
                LoggerManager.logger.error("Exception thrown with trace" + e.getStackTrace());
            }

        }

    }

    public String getCompareChoiceInput() throws InvalidInputException {

        Scanner scanner = new Scanner(System.in);

        displayManager.displayCompareAlgorithms();
        String choice = scanner.nextLine();

        if (choice.equals("y") || choice.equals("n")){
            return choice;
        }
        else{
            LoggerManager.logger.error("User selected an invalid compare option");
            throw new InvalidInputException("Option selected is not valid");
        }
    }

    // Getting user choice for algorithm
    public void getAlgorithmChoice(){

        boolean validAlgorithm = false;

        while (!validAlgorithm){

            try{
                algorithmChoice = getAlgorithmChoiceInput();
                validAlgorithm = true;
                LoggerManager.logger.info("User selected choice: " + algorithmChoice);
            }
            catch(InvalidInputException e){
                e.printStackTrace();
                System.out.println();
            }
            catch(InputMismatchException e){
                e.printStackTrace();
                System.out.println();
                LoggerManager.logger.error("User entered a non-integer during algorithm selection");
            }
            catch(Exception e){
                e.printStackTrace();
                System.out.println();
                LoggerManager.logger.error("Exception thrown with trace" + e.getStackTrace());
            }

        }

    }

    private int getAlgorithmChoiceInput() throws InvalidInputException {

        Scanner scanner = new Scanner(System.in);

        // Selecting algorithm
        displayManager.displayAlgorithms();
        int num = scanner.nextInt();

        // Throw InvalidInputException if selection not valid
        if (num > algorithmCount || num < 1){
            LoggerManager.logger.error("User selected an invalid number: " + num);
            throw new InvalidInputException("Number selected is not valid");
        }

        return num;

    }

    // Getting user choice for array length
    public void getArrayLength(){

        boolean validLength = false;

        while (!validLength){

            try{
                arrayLength = getArrayLengthInput();
                validLength = true;
                LoggerManager.logger.info("User selected array length: " + arrayLength);
            }
            catch(InvalidArrayLengthException e){
                e.printStackTrace();
                System.out.println();
            }
            catch(InputMismatchException e){
                e.printStackTrace();
                System.out.println();
                LoggerManager.logger.error("User entered a non-integer during array length selection");
            }
            catch(Exception e){
                e.printStackTrace();
                System.out.println();
                LoggerManager.logger.error("Exception thrown with trace" + e.getStackTrace());
            }

        }

    }

    // Getting user input for array length
    private int getArrayLengthInput() throws InvalidArrayLengthException {

        Scanner scanner = new Scanner(System.in);

        // Selecting array length
        displayManager.displayArrayLength();
        int len = scanner.nextInt();

        // Throw InvalidArrayLengthException if selection not valid
        if (len < 1 || len > Integer.MAX_VALUE - 8){
            LoggerManager.logger.error("User selected an invalid array length: " + len);
            throw new InvalidArrayLengthException("Array length is not valid");
        }

        return len;

    }

    // Creating Sorter using SorterFactory
    private Sorter createSorter(int algorithmChoice){

        switch (algorithmChoice){
            case 1:
                return sorterFactory.buildSorter(SorterType.BUBBLE);
            case 2:
                return sorterFactory.buildSorter(SorterType.MERGE);
            case 3:
                return sorterFactory.buildSorter(SorterType.TREE);
            default:
                return null;
        }

    }

    // Generating random array - bounds set to -200,200
    private int[] generateRandomArray(int length){

        Random random = new Random();
        int[] randomArray = new int[length];

        for (int i = 0; i < length; i++){
            // Range is -200 to 200
            randomArray[i] = random.nextInt(-200, 200);
        }

        return randomArray;

    }

    private int[] sortArray(Sorter sorter, int[] arrayToSort) {
        return sorter.sortArray(arrayToSort);
    }





}
