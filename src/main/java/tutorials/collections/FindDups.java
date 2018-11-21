package tutorials.collections;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class FindDups {

    public static void main(String[] args) {
        Set<String> distinctWords = Arrays.asList("i", "came",
                "i", "saw", "i", "left").stream()
                .collect(Collectors.toSet());

        System.out.println(distinctWords.size()+
                " distinct words: " +
                distinctWords);
    }
}
