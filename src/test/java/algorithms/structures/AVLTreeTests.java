package algorithms.structures;

import algorithms.structures.common.JavaCollectionTest;
import algorithms.structures.common.TreeTest;
import algorithms.structures.common.Utils;
import org.junit.jupiter.api.Test;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AVLTreeTests {

    @Test
    public void testAVLTree() {
        Utils.TestData data = Utils.generateTestData(1000);

        String bstName = "AVL Tree";

        BinarySearchTree<Integer> bst = new AVLTree<Integer>();

        Collection<Integer> bstCollection = bst.toCollection();

        assertTrue(TreeTest.testTree(bst, Integer.class, bstName,
                data.unsorted, data.invalid));

        assertTrue(JavaCollectionTest.testCollection(
                bstCollection, Integer.class, bstName,
                data.unsorted, data.sorted,data.invalid
        ));
    }
}
