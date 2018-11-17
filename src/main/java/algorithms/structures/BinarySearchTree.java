package algorithms.structures;

/**
 * A binary search tree (BST), which may sometimes also be called an ordered or
 * sorted binary tree, is a node-based binary tree data structure which has the
 * following properties: 1) The left subtree of a node contains only nodes with
 * keys less than the node's key. 2) The right subtree of a node contains only
 * nodes with keys greater than the node's key. 3) Both the left and right
 * subtrees must also be binary search trees.
 * <p>
 * @see <a href="https://en.wikipedia.org/wiki/Binary_search_tree">Binary Search Tree (Wikipedia)</a>
 * <br>
 * @author Justin Wetherell <phishman3579@gmail.com>
 */


import algorithms.structures.interfaces.ITree;

import java.util.Collection;
import java.util.Random;


@SuppressWarnings("unchecked")
public class BinarySearchTree<T extends Comparable<T>> implements ITree<T> {

    private int modifications = 0;

    protected static final Random RANDOM = new Random();

    protected  Node<T> root = null;
    protected int size = 0;
    protected INodeCreator<T> creator = null;

    //　三种查询方式。
    public enum DepthFirstSearchOrder {
        inOrder, preOrder, postOrder
    }

    public BinarySearchTree() {
        // 还是调用的Node构建。
        this.creator = new INodeCreator<T>() {
            @Override
            public Node<T> createNewNode(Node<T> parent, T id) {
                return (new Node<T>(parent, id));
            }
        };
    }

    /**
     * Constructor with external Node creator.
     */
    public BinarySearchTree(INodeCreator<T> creator) {
        this.creator = creator;
    }


    @Override
    public boolean add(T value) {
        Node<T> nodeAdded = this.addValue(value);
        return (nodeAdded != null);
    }

    protected Node<T> addValue(T value) {
        Node<T> newNode = this.creator.createNewNode(null, value);
        // If root is null, assign.
        if (root == null) {
            // newNode作为根节点。
            root = newNode;
            size++;
            return newNode;
        }

        Node<T> node = root;
        while (node != null) {
            if (newNode.id.compareTo(node.id) <= 0) {
                // Less than or equal to goes left.
                if (node.lesser == null) {
                    // New left node.
                    // 当做末节点。
                    node.lesser = newNode;
                    newNode.parent = node;
                    size++;
                    return newNode;
                }
                // 继续和它的左节点作比较。
                node = node.lesser;
            } else {
                // Greater than goes right
                if (node.greater == null) {
                    // New right node.
                    node.greater = newNode;
                    newNode.parent = node;
                    size++;
                    return newNode;
                }
                // 继续和它的右节点作比较。
                node = node.greater;
            }
        }
        return newNode;
    }

    @Override
    public boolean contains(T value) {
        Node<T> node = getNode(value);
        return (node != null);
    }

    /**
     * Locate T in the tree.
     *
     * @param value T to locate in the tree.
     * @return  Node<T> representing first reference of value in tree or NULL if not found.
     */
    protected Node<T> getNode(T value) {
        Node<T> node = root;

        while (node != null && node.id != null) {
            if (value.compareTo(node.id) < 0) {
                node = node.lesser;
            } else if (value.compareTo(node.id) > 0) {
                node = node.greater;
            } else if (value.compareTo(node.id) == 0) {
                return node;
            }
        }

        return null;
    }

    /**
     * rotateLeft, rotateRight方向比较不好理解。
     * 就是指把传入的节点放在Subtree的左边还是右边。
     * 主要是换了六个指向，记得变量在走边是指向，在右边是节点。
     * 通常会增加层数。
     */
    /**
     * Rotate tree left at sub-tree rooted at node.
     * @param node Root of tree to rotate left.
     */
    // 意思是把节点放到父节点的左边。
    protected void rotateLeft(Node<T> node) {
        Node<T> parent = node.parent;
        Node<T> greater = node.greater;
        Node<T> lesser = greater.lesser;

        // 两者相互指向对方。
        greater.lesser = node;
        node.parent = greater;

        node.greater = lesser;

        if (lesser != null) {
            lesser.parent = node;
        }

        if (parent != null) {
            if (node == parent.lesser) {
                parent.lesser = greater;
            } else if (node == parent.greater) {
                parent.greater = greater;
            } else {
                throw new RuntimeException("Yikes! I'm not related to my parent. " + node.toString());
            }
            greater.parent = parent;
        } else {
            root = greater;
            root.parent = null;
        }
    }

    protected void rotateRight(Node<T> node) {
        Node<T> parent = node.parent;
        Node<T> lesser = node.lesser;
        Node<T> greater = lesser.greater;

        // 放置在右边。
        lesser.greater = node;
        node.parent = lesser;

        node.lesser = greater;
        if (greater != null) {
            greater.parent = node;
        }

        if (parent != null) {
            if (node == parent.lesser) {
                parent.lesser = lesser;
            } else if (node == parent.greater) {
                parent.greater = lesser;
            } else {
                throw new RuntimeException("Yikes! I'm not related to my parent. " + node.toString());
            }
        } else {
            // 变成根节点。
            root = lesser;
            root.parent = null;
        }
    }

    @Override
    public T remove(T value) {
        return null;
    }

    @Override
    public void clear() {

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean validate() {
        return false;
    }

    @Override
    public Collection<T> toCollection() {
        return null;
    }

    protected static class Node<T extends Comparable<T>> {
        protected T id = null;
        protected Node<T> parent = null;
        protected Node<T> lesser = null;
        protected Node<T> greater = null;

        // 可以把id想成一个数字。

        /**
         * Node constructor
         * @param parent Parent link in tree. Parent can be NULL.
         * @param id    T representing the node in the tree.
         */
        protected Node(Node<T> parent, T id) {
            this.parent = parent;
            this.id = id;
        }

        @Override
        public String toString() {
            return "id=" + id + " parent=" + ((parent != null) ? parent.id : "NULL") + " lesser="
                    + ((lesser != null) ? lesser.id : "NULL") + " greater=" + ((greater != null) ? greater.id : "NULL");
        }
    }

    // T是Comparable类型。
    protected static interface INodeCreator<T extends Comparable<T>> {
        /**
         * Create a new Node with the following parameters.
         *
         * @param parent    of this node.
         * @param id    of this node.
         * @return  new Node;
         */
        public Node<T> createNewNode(Node<T> parent, T id);
    }
}
