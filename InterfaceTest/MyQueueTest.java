import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MyQueueTest {

    @Test
    void testQueueInitiallyEmpty() {
        MyQueue queue = new MyQueue();
        assertTrue(queue.isEmpty());
        assertEquals(0, queue.size());
    }

    @Test
    void testEnqueueIncreasesSize() {
        MyQueue queue = new MyQueue();
        queue.enqueue(10);
        queue.enqueue(20);
        assertEquals(2, queue.size());
        assertFalse(queue.isEmpty());
    }

    @Test
    void testDequeueReturnsFrontElement() {
        MyQueue queue = new MyQueue();
        queue.enqueue(10);
        queue.enqueue(20);
        int firstRemoved = queue.dequeue();
        assertEquals(10, firstRemoved);
        assertEquals(1, queue.size());
    }

    @Test
    void testPeekReturnsFrontWithoutRemoving() {
        MyQueue queue = new MyQueue();
        queue.enqueue(10);
        queue.enqueue(20);
        assertEquals(10, queue.peek());
        assertEquals(2, queue.size());
    }

    @Test
    void testDequeueOnEmptyThrows() {
        MyQueue queue = new MyQueue();
        assertThrows(RuntimeException.class, queue::dequeue);
    }

    @Test
    void testPeekOnEmptyThrows() {
        MyQueue queue = new MyQueue();
        assertThrows(RuntimeException.class, queue::peek);
    }

    @Test
    void testLazyShiftOccursOnlyWhenFull() {
        MyQueue queue = new MyQueue(3);
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.dequeue();
        queue.enqueue(40);
        assertEquals(3, queue.size());
        assertEquals(20, queue.peek());
    }
}
