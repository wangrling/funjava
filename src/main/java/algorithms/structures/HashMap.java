package algorithms.structures;

import algorithms.structures.interfaces.IMap;

import java.util.List;
import java.util.Map;

/**
 * Hash Map using either chaining or probing. hash map is a data structure that
 * uses a hash function to map identifying values, known as keys, to their
 * associated values.
 * <p>
 * @see <a href="https://en.wikipedia.org/wiki/Hash_table">Hash Map/Table (Wikipedia)</a>
 * <br>
 * @author Justin Wetherell <phishman3579@gmail.com>
 */

@SuppressWarnings("unchecked")
public class HashMap<K, V> implements IMap<K, V> {

    public static enum Type {
        CHAINING, PROBING
    }

    private static class ChainingHashMap<K, V> extends HashMap<K, V> {
        private float loadFactor = 10.0f;
        private int minimumSize = 1024;
        private int initialListSize = 10;

        // array裏面的元素是List, list裏面是Pair.
        private List<Pair<K, V>>[] array = null;

        private int size = 0;

        /**
         * Create a hash map with K as the hashing key.
         *
         * @param size  initial size.
         */
        public ChainingHashMap(int size) {
            initializeMap(size);
        }

        /**
         * Create a hash map with the default hashing key.
         */
        public ChainingHashMap() {
            initializeMap(minimumSize);
        }

        @Override
        public V put(K key, V value) {
            return put(new Pair<K, V>(key, value));
        }

        public V put(Pair<K, V> newPair) {

            // hash = hashfunc(key)
            //index = hash % array_size
            int index = indexOf(newPair.key.hashCode());

            List<Pair<K, V>> list = array[index];

            V prev = null;

            boolean exist = false;

            // Do not add duplicates
            // 重複值會被覆蓋，並且返回原來的值。
            for (Pair<K, V> p : list) {
                if (p.key.equals(newPair.key)) {
                    prev = p.value;
                    p.value = newPair.value;
                    exist = true;
                    break;
                }
            }

            if (!exist) {
                list.add(newPair);
            }

            size++;

            // If size is greater than threshold.
            int maxSize = (int)(loadFactor * array.length);
            if (size >= maxSize)
                increase();

            return prev;
        }

        @Override
        public V get(K key) {
            int index = indexOf(key.hashCode());
            List<Pair<K, V>> list = array[index];

            for (Pair<K, V> p : list) {
                if (p.key.equals(key)) {
                    return p.value;
                }
            }

            return null;
        }

        @Override
        public boolean contains(K key) {
            return get(key) != null;
        }

        @Override
        public V remove(K key) {
            int index = indexOf(key.hashCode());
        }
    }

    @Override
    public V put(K key, V value) {
        return null;
    }

    @Override
    public V get(K key) {
        return null;
    }

    @Override
    public V remove(K key) {
        return null;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean contains(K key) {
        return false;
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
    public Map<K, V> toMap() {
        return null;
    }

    private static final class Pair<K, V> {
        private K key = null;
        private V value = null;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }


        @Override
        public int hashCode() {
            return 31 * this.key.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null)
                return false;

            if (!(obj instanceof Pair))
                return false;

            Pair<K, V> pair = (Pair<K, V>) obj;

            return key.equals(pair.key);
        }
    }
}
