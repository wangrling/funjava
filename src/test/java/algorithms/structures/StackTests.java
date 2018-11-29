package algorithms.structures;

import algorithms.structures.common.JavaCollectionTest;
import algorithms.structures.common.StackTest;
import algorithms.structures.common.Utils;
import org.junit.jupiter.api.Test;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class StackTests {

    @Test
    public void testArrayStack() {
        Utils.TestData data = Utils.generateTestData(1000);

        String aName = "Stack [array]";

        Stack.ArrayStack<Integer> aStack = new Stack.ArrayStack<Integer>();

        Collection<Integer> aCollection = aStack.toCollection();

        assertTrue(StackTest.testStack(aStack, aName, data.unsorted, data.invalid));

        assertTrue(JavaCollectionTest.testCollection(aCollection, Integer.class,
                aName, data.unsorted, data.sorted, data.invalid));
    }
}
