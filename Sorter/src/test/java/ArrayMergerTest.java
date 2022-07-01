import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayMergerTest {

    ArrayMerger arrayMerger;

    @BeforeEach
    void setUp() {
        arrayMerger = new ArrayMerger();
    }

    @Test
    void simpleMergeArray(){
        int[] array1 = {6,1,3};
        int[] array2 = {5,4,2};
        int[] expected = {1,2,3,4,5,6};
        Assertions.assertArrayEquals(expected, arrayMerger.mergeArrays(array1, array2));
    }

}