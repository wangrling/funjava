package tutorials.language;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class RosterTest {
    interface CheckPerson {
        boolean test(Person p);
    }

    /**
     * Approach 1: Create Methods that search for persons that match one
     * characteristic.
     */
    public static void printPersonsOlderThan(List<Person> roster, int age) {
        for (Person p : roster) {
            if (p.getAge() >= age) {
                p.printPerson();
            }
        }
    }

    /**
     * Approach 2: Create more generalized search methods.
     */
    public static void printPersonsWithinAgeRange(
            List<Person> roster, int low, int high) {
        for (Person p : roster) {
            if (low <= p.getAge() && p.getAge() < high) {
                p.printPerson();
            }
        }
    }

    // Approach 3: Specify search criteria code in a local class.
    // Approach 4: Specify search criteria code in an anonymous class.
    // Approach 5: Specify search criteria code with a lambda expression.

    public static void printPersons(
            List<Person> roster, CheckPerson tester) {
        for (Person p : roster) {
            if (tester.test(p)) {
                p.printPerson();
            }
        }
    }

    // Approach 6: Use standard functional interfaces with Lambda expressions.
    // Predicate正好含有test函数。
    public static void printPersonsWithPredicate(
            List<Person> roster, Predicate<Person> tester) {
        for (Person p : roster) {
            if (tester.test(p)) {
                p.printPerson();
            }
        }
    }

    // Approach 7: Use lambda expressions throughout your application.
    public static void processPersons(
            List<Person> roster, Predicate<Person> tester,
            Consumer<Person> block) {
        for (Person p : roster) {
            if (tester.test(p)) {
                block.accept(p);
            }
        }
    }

    // Approach7, second example.
    public static void processPersonsWithFunction(
            List<Person> roster, Predicate<Person> tester,
            Function<Person, String> mapper,
            Consumer<String> block) {
        for (Person p : roster) {
            if (tester.test(p)) {
                String data = mapper.apply(p);
                block.accept(data);
            }
        }
    }

    // Approach 8: Use generics more extensively.
    public static <X, Y> void processElements(
            Iterable<X> source,
            Predicate<X> tester,
            Function<X, Y> mapper,
            Consumer<Y> block) {
        for (X p : source) {
            if (tester.test(p)) {
                Y data = mapper.apply(p);
                block.accept(data);
            }
        }
    }

    public static void main(String... args) {
        List<Person> roster = Person.createRoster();

        for (Person p : roster) {
            p.printPerson();
        }
        System.out.println();

        // Approach 1: Create methods that search for person that match one characteristic.
        System.out.println("Persons older than 20: ");
        printPersonsOlderThan(roster, 20);
        System.out.println();

        // Approach 2: Create more Generalized search methods.
        System.out.println("Person between the ages of 14 and 30: ");
        printPersonsWithinAgeRange(roster, 14, 30);
        System.out.println();

        // Approach 3: Specify search criteria code in a local class.
        System.out.println("Person who are eligible for selective service: ");
        class CheckPersonEligibleForSelectiveService implements CheckPerson {

            @Override
            public boolean test(Person p) {
                return p.getGender() == Person.Sex.MALE
                        && p.getAge() >= 18
                        && p.getAge() <= 25;
            }
        }
        printPersons(roster, new CheckPersonEligibleForSelectiveService());
        System.out.println();

        // Approach 4: Specify search criteria code in an anonymous class.
        System.out.println("Persons who are eligible for selective service " +
                "(anonymous class): ");
        printPersons(roster, new CheckPerson() {
            @Override
            public boolean test(Person p) {
                return p.getGender() == Person.Sex.MALE
                        && p.getAge() >= 18
                        && p.getAge() <= 25;
            }
        });
        System.out.println();

        // Approach 5: Specify search criteria code with a lambda expression.
        System.out.println("Persons who are eligible for selective service " +
                "(lambda expression): ");
        printPersons(
                roster, (Person p) -> p.getGender() == Person.Sex.MALE
                && p.getAge() >= 18
                && p.getAge() <= 25);
        System.out.println();

        // Approach 6: Use standard functional interfaces with lambda expressions.
        System.out.println("Persons who are eligible for selective service " +
                "(with Predicate parameter): ");
        printPersonsWithPredicate(
                roster,
                p -> p.getGender() == Person.Sex.MALE
                        && p.getAge() >= 18
                        && p.getAge() <= 25);
        System.out.println();

        // Approach 7: Use lambda expressions throughout your application.
        System.out.println("Persons who are eligible for selective service " +
                "(with Predicate and Consumer parameters): ");
        processPersons(roster,
                p -> p.getGender() == Person.Sex.MALE
                        && p.getAge() >= 18 && p.getAge() <= 25,
                p -> p.printPerson());
        System.out.println();

        // Approach 7, second example
        System.out.println("Persons who are eligible for selective service " +
                "(generic version): ");
        processElements(
                roster,
                p -> p.getGender() == Person.Sex.MALE &&
                        p.getAge() >= 18 &&
                        p.getAge() <= 25,
                p -> p.getEmailAddress(),
                email -> System.out.println(email)
        );
        System.out.println();

        // Approach 9: Use bulk data operations that accept lambda expressions
        // as parameters.
        System.out.println("Persons who are eligible for selective service " +
                "(with bulk data operation): ");

        roster.stream()
                .filter(
                        p -> p.getGender() == Person.Sex.MALE &&
                                p.getAge() >= 18 &&
                                p.getAge() <= 25)
                .map(p -> p.getEmailAddress())
                .forEach(email -> System.out.println(email));

    }


}
