package algorithms.strings;

import java.text.DecimalFormat;

public class StringTiming {

    private static final DecimalFormat FORMAT = new DecimalFormat("#.######");

    public static void main(String[] args) {
        String string = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

        System.out.println("Reversing a string using concatenation.");
        String reverse = StringFunctions.reverseWithStringConcat(string);
        System.out.println(reverse);

        System.out.println("Reversing a string with a StringBuilder.");
        reverse = StringFunctions.reverseWithStringBuilder(string);
        System.out.println(reverse);

        System.out.println("Reversing a string with StringBuilder built-in reverse method.");
        reverse = StringFunctions.reverseWithStringBuilderBuiltinMethod(string);
        System.out.println(reverse);

        System.out.println("Reversing a string with swaps.");
        reverse = StringFunctions.reverseWithSwaps(string);
        System.out.println(reverse);

        System.out.println("Reversing a string with XOR.");
        reverse = StringFunctions.reverseWithXOR(string);
        System.out.println(reverse);

        // REVERSE WORDS IN A STRING
        String words = "Could you pretty please reverse this sentence";

        System.out.println("Reversing a string using additional array.");
        reverse = StringFunctions.reverseWordsByCharWithAdditionalStorage(words);
        System.out.println(reverse);

        System.out.println("Reversing a string in-place.");
        reverse = StringFunctions.reverseWordsInPlace(words);
        System.out.println(reverse);

        // PALINDROME
        System.out.println("Is Palindrome with additional storage?");
        boolean isPalindrome = StringFunctions.isPalindromeWithAdditionalStorage(string);
        System.out.println(isPalindrome);

        System.out.println("Is Palindrome in-place?");
        isPalindrome = StringFunctions.isPalindromeInPlace(string);
        System.out.println(isPalindrome);

        string = "ABCDEFGHIJKLMNOPQRSTUVWXYZZYXWVUTSRQPONMLKJIHGFEDCBA";
        System.out.println("Is Palindrome with additional storage?");
        isPalindrome = StringFunctions.isPalindromeWithAdditionalStorage(string);
        System.out.println(isPalindrome);

        System.out.println("Is Palindrome in-place?");
        isPalindrome = StringFunctions.isPalindromeInPlace(string);
        System.out.println(isPalindrome);

        // COMBINATIONS
        string = "abc";

        String[] collections = StringFunctions.generateSubsets(string);
        for (String coll : collections) {
            System.out.println(coll);
        }

        // Edit Distance
        String string1 = "kitten";
        String string2 = "sitting";
        System.out.println("Edit Distance Recursive.");
        int distance = StringFunctions.levenshteinDistanceRecursive(string1, string2);
        System.out.println(distance);

        string1 = "kitten";
        string2 = "sitting";
        System.out.println("Edit Distance Iterative.");
        distance = StringFunctions.levenshteinDistanceIterative(string1, string2);
        System.out.println(distance);
    }
}
