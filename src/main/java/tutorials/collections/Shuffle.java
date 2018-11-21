package tutorials.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Shuffle {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        String[] strs = {"i", "came", "i", "saw", "i", "left"};

        for (String s : strs) {
            list.add(s);
        }

        Collections.shuffle(list, new Random());

        System.out.println(list);
    }
}
