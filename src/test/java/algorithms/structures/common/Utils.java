package algorithms.structures.common;

import java.util.Arrays;
import java.util.Random;

public class Utils {

    public static final <T> T parseT(final Integer value, final Class<T> type) {
        T returnValue = null;

        if (type == null) {
            throw new NullPointerException("Type can not be null");
        } else if (Integer.class.equals(type)) {
            returnValue = type.cast(value);
        } else if (String.class.equals(type)) {
            returnValue = type.cast(String.valueOf(value));
        } else {
            throw new IllegalArgumentException("Unsupported type " + type.getName());
        }

        return returnValue;
    }

    public static void handleError(Object obj) {
        System.err.println("Object={\n" + obj.toString() + "\n}");
        throw new RuntimeException("Error in test.");
    }

    public static void handleError(Object data, Object obj) {
        System.err.println("Data = {" + data + "}");
        System.err.println("Object = {\n" + obj.toString() + "\n}");
        throw new RuntimeException("Error in test.");
    }

    public static void handleError(Object[] data, Object obj) {
        System.err.println("Data = { " + data + "}");
        System.err.println("Object={\n" + obj.toString() + "\n}");
        throw new RuntimeException("Error in test.");
    }

    private static final Random RANDOM = new Random();

    public static TestData testData(int... integers) {
        TestData data = new TestData(integers.length);

        StringBuilder builder = new StringBuilder();
        data.unsorted = new Integer[integers.length];
        java.util.Set<Integer> set = new java.util.HashSet<>();
        builder.append("Array = ");
        for (int i = 0; i < integers.length; i++) {
            Integer j = integers[i];
            data.unsorted[i] = j;

            if (i != integers.length - 1)
                builder.append(j).append(',');
        }

        set.clear();
        set = null;

        builder.append('\n');
        data.string = builder.toString();

        data.sorted = Arrays.copyOf(data.unsorted, data.unsorted.length);

        Arrays.sort(data.sorted);

        return data;
    }


    public static class TestData {
        public int randomSize = 0;
        public Integer invalid = 0;

        public Integer[] unsorted = null;
        public Integer[] sorted = null;
        public String string = null;

        public TestData(int size) {
            this.randomSize = 1000 * size;
            this.invalid = randomSize + 10;
        }

        public TestData(Integer[] unsorted) {
            this(unsorted.length);
            unsorted = unsorted;
            sorted = unsorted.clone();
            Arrays.sort(sorted);
            setString(unsorted);
        }

        private static final String setString(Integer[] unsorted) {
            StringBuilder builder = new StringBuilder();
            builder.append("Array = ");

            for (int i = 0; i < unsorted.length; i++) {
                Integer d = unsorted[i];
                if (i != unsorted.length - 1)
                    builder.append(d).append(',');
            }
            builder.append('\n');

            return builder.toString();
        }
    }
}
