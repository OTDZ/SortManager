# SortManager

## **Run Instructitons**
#### Navigate to SorterDemo class in the com.sparta.start package and run the main method

## **Sorting Algorithms**
### **Bubble Sort**
##### Bubble Sort is the simplest sorting algorithm that works by repeatedly swapping the adjacent elements if they are in the wrong order. I implemented Bubble Sort using a nested for loop and a temp variable to allow me to swap adjacent elements in the array.

```java
    public int[] sortArray(int[] arrayToSort) {

        for (int i = 0; i < arrayToSort.length-1; i++){
            for (int j = 0; j < arrayToSort.length-i-1; j++){
                if (arrayToSort[j] > arrayToSort[j + 1]) {
                    int temp = arrayToSort[j];
                    arrayToSort[j] = arrayToSort[j + 1];
                    arrayToSort[j + 1] = temp;
                }
            }
        }

        return arrayToSort;
    }
```

### **Merge Sort**
##### Merge Sort is a divide and conquer sorting algorithm which works by dividing the array into equal halves and then merging them in a sorted manner. I implemented Merge Sort using recursion and multiple while loops.

```java
    public int[] sortArray(int[] arrayToSort) {

        if (arrayToSort.length > 1){

            // Midpoint
            int mid = arrayToSort.length/2;

            // Left half
            int[] left = new int[mid];
            for (int i = 0; i < mid; i++){
                left[i] = arrayToSort[i];
            }

            // Right half
            int[] right = new int[arrayToSort.length - mid];
            for (int i = mid; i < arrayToSort.length; i++){
                right[i - mid] = arrayToSort[i];
            }

            sortArray(left);
            sortArray(right);

            // Index counter for left
            int i = 0;
            // Index counter for right
            int j = 0;
            // Index counter for initial array
            int k = 0;

            while (i < left.length && j < right.length){

                if (left[i] < right[j]){
                    arrayToSort[k] = left[i];
                    i++;
                }
                else{
                    arrayToSort[k] = right[j];
                    j++;
                }
                k++;

            }

            while (i < left.length){

                arrayToSort[k] = left[i];
                i++;
                k++;

            }

            while (j < right.length){

                arrayToSort[k] = right[j];
                j++;
                k++;

            }

        }

        return arrayToSort;

    }
```

### **Tree Sort**
##### Tree Sort uses a binary search tree structure to store elements and then traverses through the tree to return the elements in a sorted order.
##### I used the recursive function insertNode to add elements to the binary tree.
```java
    public Node insertNode(Node current, int newValue){

        // If BST is empty
        if (root == null){
            root = new Node(newValue);
            return root;
        }

        if (current == null){
            return new Node(newValue);
        }

        if (newValue < current.value){
            current.left = insertNode(current.left, newValue);
        }
        else if (newValue > current.value){
            current.right = insertNode(current.right, newValue);
        }

        return current;

    }
```

##### I used the recursive function inOrderTraversal to retrieve the elements in the binary tree in a sorted manner.
```java
    public int inOrderTraversal(Node current, int[] sortedArray, int index){
        if (current != null){
            index = inOrderTraversal(current.left, sortedArray, index);
            sortedArray[index++] = current.value;
            index = inOrderTraversal(current.right, sortedArray, index);
        }
        return index;
    }
```

## **Design Patterns**
### **Factory**
##### I created a SorterFactory which creates Sorters using the buildSorter function based on the enum that is passed into it.
```java
    public Sorter buildSorter(SorterType sorter) {

        switch (sorter){
            case BUBBLE:
                BubbleSorter bubbleSorter = new BubbleSorter();
                return bubbleSorter;
            case MERGE:
                MergeSorter mergeSorter = new MergeSorter();
                return mergeSorter;
            case TREE:
                TreeSorter treeSorter = new TreeSorter();
                return treeSorter;
            default:
                // Throw exception
                return null;
        }

    }
```

### **Model View Controller**
#### DisplayManager (View) - Manages the messages that are printed to console
```java
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
```

#### SortManager (Controller) - Interacts with the DisplayManager and Sorters (Model)
```java
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
```

### **Facade**
##### I used a class named BinarySearchTreeManager as a middle-man between the TreeSorter and BinarySearchTree in order to hide the complexity of the BinarySearchTree.
```java
public class BinarySearchTreeManager {

    public BinarySearchTree generateBinarySearchTree(int[] array){

        BinarySearchTree bst = new BinarySearchTree();

        for (int i : array){
            bst.insertNode(bst.getRoot(), i);
        }

        return bst;
    }

    public int[] treeSort(BinarySearchTree bst, int arrayLength){

        int[] sortedArray = new int[arrayLength];
        int finalIndex = bst.inOrderTraversal(bst.getRoot(), sortedArray, 0);
        return Arrays.copyOfRange(sortedArray, 0, finalIndex);

    }

}
```
