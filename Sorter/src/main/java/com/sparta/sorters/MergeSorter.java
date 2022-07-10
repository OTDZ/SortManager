package com.sparta.sorters;

public class MergeSorter implements Sorter {

    @Override
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

    @Override
    public String toString(){
        return "Merge sort";
    }

}
