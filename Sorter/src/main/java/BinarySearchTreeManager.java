import java.util.Arrays;

public class BinarySearchTreeManager {

    public BinarySearchTree generateBinarySearchTree(int[] array){

        BinarySearchTree bst = new BinarySearchTree();

        for (int i : array){
            bst.insertNode(bst.getRoot(), i);
        }

        return bst;
    }

    public int[] treeSort(BinarySearchTree bst, int arrayLength){

        int[] sortedArray = new int[arrayLength];
        int finalIndex = bst.inOrderTraversal(bst.getRoot(), sortedArray, 0);
        return Arrays.copyOfRange(sortedArray, 0, finalIndex);

    }

}
