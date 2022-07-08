package com.sparta.sorters;

import com.sparta.sorters.binaryTree.BinarySearchTree;
import com.sparta.sorters.binaryTree.BinarySearchTreeManager;

public class TreeSorter implements Sorter {

    @Override
    public int[] sortArray(int[] arrayToSort) {

        BinarySearchTreeManager bstManager = new BinarySearchTreeManager();
        BinarySearchTree bst = bstManager.generateBinarySearchTree(arrayToSort);
        int[] sortedArray = bstManager.treeSort(bst, arrayToSort.length);

        return sortedArray;

    }

    @Override
    public String toString(){
        return "tree sort";
    }

}
