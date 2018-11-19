package algorithms.structures;

import algorithms.structures.common.TreeTest;
import algorithms.structures.common.Utils;
import org.junit.jupiter.api.Test;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BinarySearchTreeTests {

    /**
     .....4.... <br>
     ..2.....5. <br>
     1...3..... <br>
     */
    private static final BinarySearchTree<Integer> testBST = new BinarySearchTree<Integer>();
    static {
        testBST.add(4);
        testBST.add(2);
        testBST.add(5);
        testBST.add(1);
        testBST.add(3);
    }

    @Test
    public void testBST() {
        Utils.TestData data = Utils.generateTestData(1000);

        String bstName = "BST";

        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        Collection<Integer> bstCollection = bst.toCollection();

        assertTrue(TreeTest.testTree(bst, Integer.class, bstName,
                data.unsorted, data.invalid));

    }
}
