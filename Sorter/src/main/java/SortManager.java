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

    public SortManager(){
        this.sorterFactory = new SorterFactory();
        this.displayManager = new DisplayManager();
    }

    public void runSort(){

        algorithmChoice = getAlgorithmSelection();
        LoggerManager.logger.info("User selected choice: " + algorithmChoice);

        arrayLength = getArrayLengthSelection();
        LoggerManager.logger.info("User selected array length: " + arrayLength);

        sorter = createSorter(algorithmChoice);
        LoggerManager.logger.info("Sorter created: " + sorter.toString());

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

    private int[] sortArray(Sorter sorter, int[] arrayToSort) {
        return sorter.sortArray(arrayToSort);
    }

    // Getting user input for algorithm
    private int getAlgorithmSelection(){

        Scanner scanner = new Scanner(System.in);

        // Selecting algorithm
        displayManager.displayAlgorithms();
        return scanner.nextInt();

    }


    private int getArrayLengthSelection(){

        Scanner scanner = new Scanner(System.in);

        // Selecting array length
        displayManager.displayArrayLength();
        return scanner.nextInt();

    }

    // Creating Sorter using SorterFactory
    private Sorter createSorter(int algorithmChoice){

        switch (algorithmChoice){
            case 1:
                return sorterFactory.buildSorter(SorterType.BUBBLE);
            case 2:
                return sorterFactory.buildSorter(SorterType.MERGE);
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





}
