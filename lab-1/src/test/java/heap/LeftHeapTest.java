package heap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.itmo.heap.LeftHeap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LeftHeapTest {

    private LeftHeap heap;

    @BeforeEach
    void setUp() {
        heap = new LeftHeap();
    }

    @Test
    void testIsEmptyWhenHeapIsEmpty() {
        assertTrue(heap.isEmpty());
    }

    @Test
    void testIsEmptyWhenHeapIsNotEmpty() {
        heap.insert(10);
        assertFalse(heap.isEmpty());
    }

    @Test
    void testClear() {
        heap.insert(20);
        heap.clear();
        assertTrue(heap.isEmpty());
    }

    @Test
    void testInsertAndDelSingleElement() {
        heap.insert(30);
        assertEquals(30, heap.del());
        assertTrue(heap.isEmpty());
    }

    @Test
    void testInsertAndDelMultipleElements() {
        heap.insert(40);
        heap.insert(10);
        heap.insert(15);
        assertEquals(10, heap.del());
        assertEquals(15, heap.del());
        assertEquals(40, heap.del());
        assertTrue(heap.isEmpty());
    }

    @Test
    void testDelWhenHeapIsEmpty() {
        assertEquals(-1, heap.del());
    }

    @Test
    void testMergeWithEmptyHeap() {
        LeftHeap newHeap = new LeftHeap();
        newHeap.insert(50);
        heap.merge(newHeap);
        assertEquals(50, heap.del());
        assertTrue(heap.isEmpty());
    }

    @Test
    void testMergeWithNonEmptyHeaps() {
        heap.insert(20);
        LeftHeap newHeap = new LeftHeap();
        newHeap.insert(10);
        heap.merge(newHeap);
        assertEquals(10, heap.del());
        assertEquals(20, heap.del());
        assertTrue(heap.isEmpty());
    }
}
