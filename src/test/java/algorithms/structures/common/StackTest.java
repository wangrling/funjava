package algorithms.structures.common;

import algorithms.structures.interfaces.IStack;

public class StackTest {

    // 測試棧
    public static <T extends Comparable<T>> boolean testStack(IStack<T> stack,

                                                              String name, T[] data, T invalid) {

        // 將數組加入到堆棧中。
        for (int i = 0; i < data.length; i++) {
            T item = data[i];
            boolean added = stack.push(item);
            // validate測試棧有麼有空的情況。
            if (!stack.validate() || stack.size() != i+1) {
                System.err.println(name+" YIKES!! " + item + " caused a size mismatch.");
                Utils.handleError(data,stack);
                return false;
            }

            if (!added || item == null || !stack.contains(item))
                return false;
        }

        if (stack.contains(invalid) || stack.remove(invalid))
            return false;

        int size = stack.size();
        for (int i = 0; i < size; i++) {
            T item = stack.pop();
            T correct = data[data.length - (i+1)];
            if (item.compareTo(correct) != 0) {
                return false;
            }

            if (!stack.validate() || (stack.size() != data.length - (i+1)))
                return false;

            // 上面已經將它移除。
            if (stack.contains(item))
                return false;
        }

        // Add half, remove a quarter, add three-quarters, remove all.
        int quarter = data.length / 4;
        int half = data.length / 2;

        // 增加一半
        for (int i = 0; i < half; i++) {
            T item = data[i];
            boolean added = stack.push(item);

            if (!stack.validate() || stack.size() != (i+1))
                return false;

            if (!added || item == null || !stack.contains(item))
                return false;
        }

        // 移除1/4
        for (int i = (half - 1); i >= quarter; i--) {
            T item = stack.pop();
            T correct = data[i];

            if (item.compareTo(correct) != 0)
                return false;

            if (!stack.validate() || stack.size() != i)
                return false;

            if (stack.contains(item))
                return false;
        }

        // 增加3/4
        for (int i = quarter; i < data.length; i++) {
            T item = data[i];
            boolean added = stack.push(item);
            if (!stack.validate() || stack.size() != i+1)
                return false;

            if (!added || item == null || !stack.contains(item))
                return false;
        }

        // 全部移除
        for (int i = data.length -1; i >= 0; i--) {
            T item = stack.pop();
            T correct = data[i];

            if (item.compareTo(correct) != 0)
                return false;

            if (!stack.validate() || stack.size() != i)
                return false;
        }

        if (stack.size() != 0)
            return false;

        return true;
    }
}
