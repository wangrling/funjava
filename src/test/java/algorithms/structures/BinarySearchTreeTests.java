package algorithms.structures;

import algorithms.structures.common.JavaCollectionTest;
import algorithms.structures.common.TreeTest;
import algorithms.structures.common.Utils;
import org.junit.jupiter.api.Test;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;
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

        assertTrue(JavaCollectionTest.testCollection(bstCollection, Integer.class, bstName,
                data.unsorted, data.sorted, data.invalid));
    }

    /** 4 2 5 1 3 */
    @Test
    public void testBSF() {
        final Integer[] inOrder = testBST.getBFS();
        final Integer[] expectation = new Integer[]{4, 2, 5, 1, 3};
        for (int i = 0; i < inOrder.length; i++) {
            assertEquals(inOrder[i], expectation[i]);
        }
    }

    //　從上往下打印。
    @Test
    public void testLargePreOrderDFS() {
        Utils.TestData data = Utils.generateTestData(1000);

        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();

        for (int i : data.unsorted) {
            bst.add(i);
            bst.getDFS(BinarySearchTree.DepthFirstSearchOrder.preOrder);
        }
    }

    /**
     * 1 2 3 4 5
     */
    @Test
    public void testInOrderDFS() {
        final Integer[] inOrder = testBST.getDFS(BinarySearchTree.DepthFirstSearchOrder.inOrder);
        final Integer[] expectation = new Integer[]{
                1, 2, 3, 4, 5
        };

        for (int i = 0; i < inOrder.length; i++) {
            assertEquals(inOrder[i], expectation[i]);
        }
    }

    @Test
    public void testLargeInOrderDFS() {
        Utils.TestData data = Utils.generateTestData(1000);
        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
        for (int i : data.unsorted) {
            bst.add(i);
        }
        bst.getDFS(BinarySearchTree.DepthFirstSearchOrder.inOrder);
    }

    /**
     * 1 3 2 5 4
     */
    @Test
    public void testPostOrderDFS() {
        final Integer[] inOrder = testBST.getDFS(BinarySearchTree.DepthFirstSearchOrder.postOrder);
        final Integer[] expectation = new Integer[]{1, 3, 2, 5, 4};

        for (int i = 0; i < inOrder.length; i++) {
            assertEquals(inOrder[i], expectation[i]);
        }
    }

    @Test
    public void testLargePostOrderDFS() {
        Utils.TestData data = Utils.generateTestData(1000);

        BinarySearchTree<Integer> bst = new BinarySearchTree<>();

        for (int i : data.unsorted) {
            bst.add(i);
        }

        bst.getDFS(BinarySearchTree.DepthFirstSearchOrder.postOrder);
    }


}
