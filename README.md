# SortManager

## **Bubble Sort**
### Bubble Sort is the simplest sorting algorithm that works by repeatedly swapping the adjacent elements if they are in the wrong order.

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

### I used a nested for loop and a temp variable to allow me to swap elements in the array.
