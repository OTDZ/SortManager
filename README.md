# SortManager

## **Sorting Algorithms**
### **Bubble Sort**
##### Bubble Sort is the simplest sorting algorithm that works by repeatedly swapping the adjacent elements if they are in the wrong order. I implemented Bubble Sort using a nested for loop and a temp variable to allow me to swap adjacent elements in the array.

```java
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
```

### **Merge Sort**
##### Merge Sort is a divide and conquer sorting algorithm which works by dividing the array into equal halves and then merging them in a sorted manager. I implemented Merge Sort using recursion and multiple while loops to implement the merge sort.

```java
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
```
