package patterns.callback;

/**
 *
 * This example generates the exact same output as {@link App} however the callback has been
 * defined as a Lambdas expression.
 *
 */

public class LambdaApp {

    public static void main(String[] args) {
        Task task = new SimpleTask();

        Callback c = () -> System.out.println("I'm done now.");

        task.executeWith(c);
    }
}
