package algorithms.structures.common;

import java.util.Collection;

public class JavaCollectionTest {

    public static <T extends Comparable<T>> boolean testCollection(
            Collection<T> collection, Class<T> type, String name, Integer[] unsorted, Integer[] sorted,
            Integer _invalid) {

        // Make sure the collection is empty.
        if (!collection.isEmpty()) {
            System.err.println(name + " initial isEmpty() failed.");
            Utils.handleError(collection);
            return false;
        }


        if (collection.size() != 0) {
            System.err.println(name + " initial size() failed.");
            Utils.handleError(collection);
            return false;
        }

        // type是Integer.class.
        addAndRemoveInOrder(collection, type, name, unsorted, _invalid);



        return true;
    }

    private static <T extends Comparable<T>> boolean addAndRemoveInOrder(
            Collection<T> collection, Class<T> type, String name,
            Integer[] data, Integer _invalid) {

        T invalid = Utils.parseT(_invalid, type);

        // Add and remove in order (from index zero to length)
        for (int i = 0; i < data.length; i++) {
            Integer value = data[i];
            T item = Utils.parseT(value, type);
            boolean added = collection.add(item);
            if (!added) {
                System.err.println(name+" addAndRemoveInOrder add failed.");
                Utils.handleError(data,collection);
                return false;
            }
        }

        for (int i = 0; i < data.length; i++) {
            Integer value = data[i];
            T item = Utils.parseT(value, type);
            boolean contains = collection.contains(item);
            if (!contains) {
                System.err.println(name+" addAndRemoveInOrder contains failed.");
                Utils.handleError(data,collection);
                return false;
            }
        }

        boolean contains = collection.contains(invalid);
        boolean removed = collection.remove(invalid);
        if (contains || removed) {
            System.err.println(name+" invalidity check. contains=" + contains + " removed=" + removed);
            Utils.handleError(_invalid,collection);
            return false;
        }

        for (int i = 0; i < data.length; i++) {
            Integer value = data[i];
            T item = Utils.parseT(value, type);
            removed = collection.remove(item);

            if (!removed) {
                System.err.println(name+" addAndRemoveInOrder remove failed.");
                Utils.handleError(data,collection);
                return false;
            }
        }

        if (!collection.isEmpty()) {
            System.err.println(name + " addAndRemoveInOrder isEmpty() failed.");
            Utils.handleError(data, collection);
        }

        if (collection.size() != 0) {
            System.err.println(name + " addAndRemoveInOrder size() failed.");
            Utils.handleError(data, collection);
            return false;
        }

        // tree不會走這個if語句。
        if (collection instanceof java.util.List &&
                (!ListIteratorTest.testListIterator(
                        ((java.util.List<T>) collection).listIterator(), type, data,
                        data.length))) {
            System.err.println(name+" addAndRemoveInOrder list iterator failed.");
            Utils.handleError(data,collection);
            return false;
        }

        return true;
    }
}
