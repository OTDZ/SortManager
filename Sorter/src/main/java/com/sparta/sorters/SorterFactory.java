package com.sparta.sorters;

import com.sparta.enums.SorterType;
import com.sparta.sorters.*;

public class SorterFactory {

    public Sorter buildSorter(SorterType sorter) {

        switch (sorter){
            case BUBBLE:
                BubbleSorter bubbleSorter = new BubbleSorter();
                return bubbleSorter;
            case MERGE:
                MergeSorter mergeSorter = new MergeSorter();
                return mergeSorter;
            case TREE:
                TreeSorter treeSorter = new TreeSorter();
                return treeSorter;
            default:
                // Throw exception
                return null;
        }

    }
}
