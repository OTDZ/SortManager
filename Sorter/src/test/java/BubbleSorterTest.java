import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BubbleSorterTest {

    BubbleSorter bubbleSorter;

    @BeforeEach
    void setUp() {
        bubbleSorter = new BubbleSorter();
    }

    @Test
    void testSimpleBubbleSort(){
        int[] sort = {3,1,2,4};
        int[] expected = {1,2,3,4};
        Assertions.assertArrayEquals(expected, bubbleSorter.sortArray(sort));
    }


}