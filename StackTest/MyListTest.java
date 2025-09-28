import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MyListTest {

    @Test
    void testAddAndGet() {
        MyList list = new MyList();
        list.add(10);
        list.add(20);
        assertEquals(10, list.get(0));
        assertEquals(20, list.get(1));
    }

    @Test
    void testSize() {
        MyList list = new MyList();
        list.add(5);
        list.add(15);
        assertEquals(2, list.size());
    }

    @Test
    void testRemove() {
        MyList list = new MyList();
        list.add(10);
        list.add(20);
        list.remove(0);
        assertEquals(20, list.get(0));
        assertEquals(1, list.size());
    }

    @Test
    void testGetInvalidIndexThrows() {
        MyList list = new MyList();
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(0));
    }
}
