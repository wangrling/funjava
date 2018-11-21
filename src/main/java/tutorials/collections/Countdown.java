package tutorials.collections;

import java.util.LinkedList;
import java.util.Queue;

public class Countdown {

    public static void main(String[] args) {
        int time = 5000;

        Queue<Integer> queue = new LinkedList<>();

        for (int i = time; i >= 0; i--) {
            ((LinkedList<Integer>) queue).add(i);
        }

        while (!queue.isEmpty()) {
            System.out.println(queue.remove());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
