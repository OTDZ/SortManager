package com.sparta.controller;

import com.sparta.display.DisplayManager;
import com.sparta.enums.SorterType;
import com.sparta.exceptions.InvalidArrayLengthException;
import com.sparta.exceptions.InvalidInputException;
import com.sparta.logger.LoggerManager;
import com.sparta.sorters.Sorter;
import com.sparta.sorters.SorterFactory;

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
    private int[] sortedArray;
    int algorithmCount;

    public SortManager(int algorithmCount){
        this.sorterFactory = new SorterFactory();
        this.displayManager = new DisplayManager();
        this.algorithmCount = algorithmCount;
    }

    public void runSort(){

        getUserInput();

        sorter = createSorter(algorithmChoice);
        LoggerManager.logger.info("com.sparta.sorters.Sorter created: " + sorter.toString());

        arrayToSort = generateRandomArray(arrayLength);
        LoggerManager.logger.info("Array randomly generated");

        displayManager.displayUnsortedArray(arrayToSort, sorter);
        LoggerManager.logger.info("Unsorted array and sorting algorithm displayed to user");

        long startTime = System.nanoTime();

        sortedArray = sortArray(sorter, arrayToSort);
        LoggerManager.logger.info("Array sorted");

        // Calculating time taken to sort in seconds
        long endTime = System.nanoTime();
        long sortTime = endTime - startTime;
        double sortTimeInSeconds = (double) sortTime / 1_000_000_000;

        displayManager.displayResults(sortedArray, sortTimeInSeconds);
        LoggerManager.logger.info("Sorted array and time taken displayed to user, time taken (seconds): " + sortTimeInSeconds);

    }

    public void getUserInput(){

        boolean validAlgorithm = false;
        boolean validLength = false;

        while (!validAlgorithm){

            try{
                algorithmChoice = getAlgorithmSelection();
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

        while (!validLength){

            try{
                arrayLength = getArrayLengthSelection();
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

    // Getting user input for algorithm
    private int getAlgorithmSelection() throws InvalidInputException {

        Scanner scanner = new Scanner(System.in);

        // Selecting algorithm
        displayManager.displayAlgorithms();
        int num = scanner.nextInt();

        // Throw com.sparta.exceptions.InvalidInputException if selection not valid
        if (num > algorithmCount || num < 1){
            LoggerManager.logger.error("User selected an invalid number: " + num);
            throw new InvalidInputException("Number selected is not valid");
        }

        return num;

    }


    private int getArrayLengthSelection() throws InvalidArrayLengthException {

        Scanner scanner = new Scanner(System.in);

        // Selecting array length
        displayManager.displayArrayLength();
        int len = scanner.nextInt();

        // Throw com.sparta.exceptions.InvalidArrayLengthException if selection not valid
        if (len < 1 || len > Integer.MAX_VALUE - 8){
            LoggerManager.logger.error("User selected an invalid array length: " + len);
            throw new InvalidArrayLengthException("Array length is not valid");
        }

        return len;

    }

    // Creating com.sparta.sorters.Sorter using com.sparta.sorters.SorterFactory
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
