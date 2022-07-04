import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SorterFactoryTest {

    SorterFactory sorterFactory;

    @BeforeEach
    void setUp() {
        sorterFactory = new SorterFactory();
    }

    @Test
    void testSorterFactoryBubble(){
        BubbleSorter bubbleSorter = new BubbleSorter();
        Assertions.assertEquals(bubbleSorter, sorterFactory.buildSorter(SorterType.BUBBLE));
    }

}