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

    public SortManager(DisplayManager displayManager){
        this.sorterFactory = new SorterFactory();
        this.displayManager = displayManager;
    }

    public void runSort(){

        algorithmChoice = getAlgorithmSelection();
        arrayLength = getArrayLengthSelection();
        sorter = createSorter(algorithmChoice);
        arrayToSort = generateRandomArray(arrayLength);

        displayManager.displayUnsortedArray(arrayToSort, sorter);

        long startTime = System.nanoTime();

        sortedArray = sortArray(sorter, arrayToSort);

        // Calculating time taken to sort in seconds
        long endTime = System.nanoTime();
        long sortTime = endTime - startTime;
        double sortTimeInSeconds = (double) sortTime / 1_000_000_000;

        displayManager.displayResults(sortedArray, sortTimeInSeconds);

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
