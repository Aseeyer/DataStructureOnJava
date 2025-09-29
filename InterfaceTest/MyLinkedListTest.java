import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MyLinkedListTest {

    @Test
    void testListInitiallyEmpty() {
        MyLinkedList linkedList = new MyLinkedList();
        assertTrue(linkedList.isEmpty());
        assertEquals(0, linkedList.size());
    }

    @Test
    void testAddAppendsElements() {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.add(10);
        linkedList.add(20);
        assertEquals(2, linkedList.size());
        assertEquals(10, linkedList.get(0));
        assertEquals(20, linkedList.get(1));
    }

    @Test
    void testGetInvalidIndexThrows() {
        MyLinkedList linkedList = new MyLinkedList();
        assertThrows(IndexOutOfBoundsException.class, () -> linkedList.get(0));
    }

    @Test
    void testRemoveAtIndexShiftsElements() {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.add(10);
        linkedList.add(20);
        linkedList.add(30);
        linkedList.removeAt(1);
        assertEquals(2, linkedList.size());
        assertEquals(10, linkedList.get(0));
        assertEquals(30, linkedList.get(1));
    }

    @Test
    void testSetReplacesValueAtIndex() {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.add(10);
        linkedList.add(20);
        linkedList.set(1, 50);
        assertEquals(50, linkedList.get(1));
    }

    @Test
    void testClearRemovesAllElements() {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.add(10);
        linkedList.add(20);
        linkedList.clear();
        assertTrue(linkedList.isEmpty());
    }
}
