package com.sparta.sorters;

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
