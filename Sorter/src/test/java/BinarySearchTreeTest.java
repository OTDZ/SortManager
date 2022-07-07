import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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

}