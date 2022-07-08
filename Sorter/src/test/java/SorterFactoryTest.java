import com.sparta.sorters.BubbleSorter;
import com.sparta.sorters.MergeSorter;
import com.sparta.enums.SorterType;
import com.sparta.sorters.SorterFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SorterFactoryTest {

    SorterFactory sorterFactory;

    @BeforeEach
    void setUp() {
        sorterFactory = new SorterFactory();
    }

    @Test
    void testSorterFactoryBubble(){
        BubbleSorter bubbleSorter = new BubbleSorter();
        Assertions.assertEquals(bubbleSorter.getClass(), sorterFactory.buildSorter(SorterType.BUBBLE).getClass());
    }

    @Test
    void testSorterFactoryMerge(){
        MergeSorter mergeSorter = new MergeSorter();
        Assertions.assertEquals(mergeSorter.getClass(), sorterFactory.buildSorter(SorterType.MERGE).getClass());
    }

}