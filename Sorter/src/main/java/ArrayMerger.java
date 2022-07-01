public class ArrayMerger {

    public int[] mergeArrays(int[] array1, int[] array2){

        // Combine the arrays
        int[] concatArrays = new int[array1.length + array2.length];
        System.arraycopy(array1, 0, concatArrays, 0, array1.length);
        System.arraycopy(array2, 0, concatArrays, array1.length, array2.length);

        // Sort using Merge Sort
        MergeSorter mergeSorter = new MergeSorter();
        return mergeSorter.sortArray(concatArrays);

    }

}
