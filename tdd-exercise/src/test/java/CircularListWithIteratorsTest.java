import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tdd.iterator.CircularListWithIterators;
import tdd.iterator.CircularListWithIteratorsImpl;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListWithIteratorsTest {

    private final static int FIRST_ITEM = 0;
    private final static int GENERIC_ITEM = 1;
    private final static int LAST_ITEM = 2;

    private CircularListWithIterators circularList;

    private int addElements(){
        int numberOfElementsAdded = 3;
        circularList.add(FIRST_ITEM);
        circularList.add(GENERIC_ITEM);
        circularList.add(LAST_ITEM);
        return numberOfElementsAdded;
    }

    @BeforeEach
    void beforeEach(){
        this.circularList = new CircularListWithIteratorsImpl();
    }
    @Test
    void isInitiallyEmpty(){
        assertTrue(this.circularList.isEmpty());
    }

    @Test
    void addItem(){
        this.circularList.add(FIRST_ITEM);
        assertFalse(this.circularList.isEmpty());
    }

    @Test
    void addMultipleItems(){
        int numberOfElementsAdded = this.addElements();
        assertEquals(numberOfElementsAdded,this.circularList.size());
    }

    @Test
    void testForwardIterator(){
        int numberOfElementsAdded = this.addElements();
        Iterator<Integer> forwardIterator = this.circularList.forwardIterator();
        for (int i = 1; i < numberOfElementsAdded; i++) {
            forwardIterator.next();
        }
        assertEquals(LAST_ITEM,forwardIterator.next());
    }

    @Test
    void testForwardCyclicIterator(){
        int numberOfElementsAdded = this.addElements();

        Iterator<Integer> forwardIterator = this.circularList.forwardIterator();
        for (int i = 0; i < numberOfElementsAdded; i++) {
            forwardIterator.next();
        }
        assertEquals(FIRST_ITEM,forwardIterator.next());
    }

    @Test
    void testForwardCyclicIteratorWithEmptyList(){
        Iterator<Integer> forwardIterator = this.circularList.forwardIterator();
        assertFalse(forwardIterator.hasNext());
    }

    @Test
    void testBackwardIterator(){
        int numberOfElementsAdded = this.addElements();

        Iterator<Integer> backwardIterator = this.circularList.backwardIterator();
        for (int i = 1; i < numberOfElementsAdded; i++) {
            backwardIterator.next();
        }
        assertEquals(FIRST_ITEM,backwardIterator.next());
    }

    @Test
    void testBackwardCyclicIterator(){
        int numberOfElementsAdded = this.addElements();

        Iterator<Integer> backwardIterator = this.circularList.backwardIterator();
        for (int i = 0; i < numberOfElementsAdded; i++) {
            backwardIterator.next();
        }
        assertEquals(LAST_ITEM,backwardIterator.next());
    }

    @Test
    void testBackwardCyclicIteratorWithEmptyList(){
        Iterator<Integer> backwardIterator = this.circularList.backwardIterator();
        assertFalse(backwardIterator.hasNext());
    }
}
