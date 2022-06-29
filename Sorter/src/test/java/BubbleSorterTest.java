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

    @Test
    void testBubbleSortEmpty(){
        int[] sort = {};
        int[] expected = {};
        Assertions.assertArrayEquals(expected, bubbleSorter.sortArray(sort));
    }

    @Test
    void testBubbleSortOne(){
        int[] sort = {10};
        int[] expected = {10};
        Assertions.assertArrayEquals(expected, bubbleSorter.sortArray(sort));
    }

    @Test
    void testBubbleSortLarge(){
        int[] sort = {9,1,2,5,76,12,3006,124,51241,64320,1241204,4643,4574574,235,6436};
        int[] expected = {1,2,5,9,12,76,124,235,3006,4643,6436,51241,64320,1241204,4574574};
        Assertions.assertArrayEquals(expected, bubbleSorter.sortArray(sort));
    }

    @Test
    void testBubbleSortNegative(){
        int[] sort = {-200,-15,-650,-1,-0};
        int[] expected = {-650,-200,-15,-1,-0};
        Assertions.assertArrayEquals(expected, bubbleSorter.sortArray(sort));
    }

    @Test
    void testBubbleSortNegativeAndPositive(){
        int[] sort = {-2,6,-0,12,0,300,-110};
        int[] expected = {-110,-2,-0,0,6,12,300};
        Assertions.assertArrayEquals(expected, bubbleSorter.sortArray(sort));
    }



}