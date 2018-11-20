package tutorials.language;

public class GenericMethods {

    public static <K, V> boolean compare(Pair<K, V> p1, Pair<K, V> p2) {
        return p1.getKey().equals(p2.getKey()) &&
                p1.getValue().equals(p2.getValue());
    }

    public static void main(String[] args) {
        Pair<Integer, String> p1 = new OrderedPair<>(1, "apple");
        Pair<Integer, String> p2 = new OrderedPair<>(2, "pear");

        boolean same = GenericMethods.<Integer, String>compare(p1, p2);

        System.out.println("same = " + same);
    }
}
