public class BubbleSorter implements Sorter{

    @Override
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

    @Override
    public String toString(){
        return "bubble sort";
    }

}
