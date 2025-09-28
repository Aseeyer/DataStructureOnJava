import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StackStructureTest {

    @Test
    void testStackInitiallyEmpty() {
        StackStructure stack = new StackStructure();
        assertTrue(stack.isEmpty());
        assertEquals(0, stack.getCount());
    }

    @Test
    void testPushIncreasesCount() {
        StackStructure stack = new StackStructure();
        stack.pushElement(10);
        stack.pushElement(20);
        assertEquals(2, stack.getCount());
        assertFalse(stack.isEmpty());
    }

    @Test
    void testPopDecreasesCount() {
        StackStructure stack = new StackStructure();
        stack.pushElement(10);
        stack.pushElement(20);
        stack.popElement();
        assertEquals(1, stack.getCount());
    }

    @Test
    void testPopOnEmptyStackThrows() {
        StackStructure stack = new StackStructure();
        assertThrows(RuntimeException.class, stack::popElement);
    }
}
