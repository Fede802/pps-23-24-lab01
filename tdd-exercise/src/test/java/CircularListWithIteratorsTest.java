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

    private int addItems(){
        int itemsAdded = 3;
        circularList.add(FIRST_ITEM);
        circularList.add(GENERIC_ITEM);
        circularList.add(LAST_ITEM);
        return itemsAdded;
    }

    @BeforeEach
    void beforeEach(){
        circularList = new CircularListWithIteratorsImpl();
    }
    @Test
    void isInitiallyEmpty(){
        assertTrue(circularList.isEmpty());
    }

    @Test
    void addItem(){
        circularList.add(FIRST_ITEM);
        assertFalse(circularList.isEmpty());
    }

    @Test
    void addMultipleItems(){
        int itemsAdded = addItems();
        assertEquals(itemsAdded,circularList.size());
    }

    @Test
    void testForwardIterator(){
        int itemsAdded = addItems();

        Iterator<Integer> iterator = this.circularList.forwardIterator();
        for (int i = 0; i < itemsAdded-1; i++) {
            iterator.next();
        }
        assertEquals(LAST_ITEM,iterator.next());
    }

    @Test
    void testForwardCyclicIterator(){
        int itemsAdded = addItems();

        Iterator<Integer> iterator = this.circularList.forwardIterator();
        for (int i = 0; i < itemsAdded; i++) {
            iterator.next();
        }
        assertEquals(FIRST_ITEM,iterator.next());
    }
}
