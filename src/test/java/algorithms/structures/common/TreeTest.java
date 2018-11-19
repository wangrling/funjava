package algorithms.structures.common;

import algorithms.structures.interfaces.ITree;

public class TreeTest {

    public static <T extends Comparable<T>> boolean testTree(ITree<T> tree,
                          Class<T> type, String name, Integer[] data, Integer invalid) {
        for (int i = 0; i < data.length; i++) {
            Integer value = data[i];
            T item = Utils.parseT(value, type);
            boolean added = tree.add(item);

            if (!tree.validate() || (tree.size() != i+1)) {
                System.err.println(name + " YIKES!! " + item + " caused a size mismatch.");
                Utils.handleError(data, tree);

                return false;
            }

            if (!added || !tree.contains(item)) {
                System.err.println(name+" YIKES!! " + item + " doesn't exists but has been added.");
                Utils.handleError(data,tree);
                return false;
            }
        }


        T invalidItem = Utils.parseT(invalid, type);
        boolean contains = tree.contains(invalidItem);
        T removed = tree.remove(invalidItem);

        if (contains || removed != null) {
            System.err.println(name+" invalidity check. contains=" + contains + " removed=" + removed);
            Utils.handleError(invalid,tree);
            return false;
        }

        int size = tree.size();
        for (int i = 0; i < size; i++) {
            Integer value = data[i];
            T item = Utils.parseT(value, type);
            removed = tree.remove(item);
            if (!tree.validate() || (tree.size() != data.length - (i+1))) {
                System.err.println(name+" YIKES!! " + item.toString() + " caused a size mismatch.");
                Utils.handleError(data,tree);
                return false;
            }

            if (removed==null || tree.contains(item)) {
                System.err.println(name+" YIKES!! " + item + " still exists but it has been removed.");

                Utils.handleError(data,tree);
                return false;
            }
        }

        // Add half, remove a quarter, and three-quarters.
        int quarter = data.length / 4;
        int half = data.length / 2;

        for (int i = 0; i < half; i++) {
            Integer value = data[i];
            T item = Utils.parseT(value, type);
            boolean added = tree.add(item);

            if (!tree.validate() || (tree.size() != i + 1)) {
                System.err.println(name+" YIKES!! " + item + " caused a size mismatch.");
                Utils.handleError(data,tree);
                return false;
            }

            if (!added || !tree.contains(item)) {
                System.err.println(name+" YIKES!! " + item + " doesn't exists but has been added.");
                Utils.handleError(data,tree);
                return false;
            }
        }

        return true;

    }
}
