package algorithms.structures;

/**
 * An AVL tree is a self-balancing binary search tree, and it was the first such
 * data structure to be invented. In an AVL tree, the heights of the two child
 * subtrees of any node differ by at most one. AVL trees are often compared with
 * red-black trees because they support the same set of operations and because
 * red-black trees also take O(log n) time for the basic operations. Because AVL
 * trees are more rigidly balanced, they are faster than red-black trees for
 * lookup intensive applications. However, red-black trees are faster for
 * insertion and removal.
 * <p>
 * @see <a href="https://en.wikipedia.org/wiki/AVL_tree">AVL Tree (Wikipedia)</a>
 * <br>
 * @author Justin Wetherell <phishman3579@gmail.com>
 */

//　必須保證每個節點的左右節點最大高度差小於某個值。

public class AVLTree<T extends Comparable<T>> extends BinarySearchTree<T> {

    private enum Balance {
        LEFT_LEFT, LEFT_RIGHT, RIGHT_LEFT, RIGHT_RIGHT
    }

    public AVLTree() {
        this.creator = new BinarySearchTree.INodeCreator<T>() {
            @Override
            public Node<T> createNewNode(Node<T> parent, T id) {
                return (new )
            }
        }
    }

    protected static class AVLNode<T extends Comparable<T>> extends Node<T> {

        protected int height = 1;
        /**
         * Node constructor.
         *
         * @param parent Parent link in tree. parent can be NULL.
         * @param id
         *              Value of the node in the tree.
         */
        protected AVLNode(Node<T> parent, T id) {
            super(parent, id);
        }
    }
}
