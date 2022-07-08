import com.sparta.sorters.binaryTree.BinarySearchTree;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BinarySearchTreeTest {

    BinarySearchTree bst;

    @BeforeEach
    void setUp(){
        bst = new BinarySearchTree();
    }

    @Test
    void testInsertNodeInEmpty(){
        bst.insertNode(bst.getRoot(), 5);
        Assertions.assertEquals(bst.getRoot().getValue(), 5);
    }

    @Test
    void testInsertNodeSimple(){

        // Visual diagram of BST:
        //         5
        //      3     7

        bst.insertNode(bst.getRoot(), 5);
        bst.insertNode(bst.getRoot(), 7);
        bst.insertNode(bst.getRoot(), 3);
        Assertions.assertEquals(bst.getRoot().getLeft().getValue(), 3);
        Assertions.assertEquals(bst.getRoot().getRight().getValue(), 7);

    }

    @Test
    void testInOrderTraversal(){

        // Visual diagram of BST:
        //           20
        //       8        35
        //    3    12  28    60

        bst.insertNode(bst.getRoot(), 20);
        bst.insertNode(bst.getRoot(), 8);
        bst.insertNode(bst.getRoot(), 12);
        bst.insertNode(bst.getRoot(), 35);
        bst.insertNode(bst.getRoot(), 3);
        bst.insertNode(bst.getRoot(), 28);
        bst.insertNode(bst.getRoot(), 60);


        int[] sortedArray = new int[7];
        int[] expected = {3,8,12,20,28,35,60};
        bst.inOrderTraversal(bst.getRoot(), sortedArray, 0);
        Assertions.assertArrayEquals(expected, sortedArray);
    }

}