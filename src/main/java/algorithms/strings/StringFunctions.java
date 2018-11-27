package algorithms.strings;

/**
 * This class contains methods for modifying text.
 * <p>
 * @author Justin Wetherell <phishman3579@gmail.com>
 */

public class StringFunctions {

    private static final char SPACE = ' ';

    public static final String reverseWithStringConcat(String string) {
        String output = new String();
        for (int i = (string.length() - 1); i >= 0; i--) {
            output += (string.charAt(i));
        }

        return output;
    }

    public static final String reverseWithStringBuilder(String string) {
        final StringBuilder builder = new StringBuilder();
        for (int i = (string.length() - 1); i >= 0; i--) {
            builder.append(string.charAt(i));
        }

        return builder.toString();
    }

    public static final String reverseWithStringBuilderBuiltinMethod(String string) {
        final StringBuilder builder = new StringBuilder(string);

        return builder.reverse().toString();
    }

    public static final String reverseWithSwaps(String string) {
        final char[] array = string.toCharArray();
        final int length = array.length - 1;
        final int half = (int) Math.floor(array.length / 2);

        char c;
        for (int i = length; i >= half; i--) {
            c = array[length - i];
            array[length - i] = array[i];
            array[i] = c;
        }

        return String.valueOf(array);
    }

    // 這是什麼操作？
    public static final String reverseWithXOR(String string) {
        final char[] array = string.toCharArray();
        final int length = array.length;
        final int half = (int) Math.floor(array.length / 2);

        // 通過三次與或操作兩個數據進行交換。
        for (int i = 0; i < half; i++) {
            array[i] ^= array[length - i - 1];
            array[length - i - 1] ^= array[i];
            array[i] ^= array[length - i - 1];
        }

        return String.valueOf(array);
    }

    public static final String reverseWordsByCharWithAdditionalStorage(String string) {
        final StringBuilder builder = new StringBuilder();
        final int length = string.length() - 1;
        final StringBuilder temp = new StringBuilder();
    }
}
