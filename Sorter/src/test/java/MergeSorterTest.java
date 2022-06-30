import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MergeSorterTest {

    MergeSorter mergeSorter;

    @BeforeEach
    void setUp() {
        mergeSorter = new MergeSorter();
    }


    @Test
    void testSimpleMergeSort(){
        int[] sort = {3,1,2,4};
        int[] expected = {1,2,3,4};
        Assertions.assertArrayEquals(expected, mergeSorter.sortArray(sort));
    }

}