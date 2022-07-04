public class SorterFactory {

    public Sorter buildSorter(SorterType sorter) {

        switch (sorter){
            case BUBBLE:
                BubbleSorter bubbleSorter = new BubbleSorter();
                return bubbleSorter;
            default:
                // Throw exception
                return null;
        }

    }
}
