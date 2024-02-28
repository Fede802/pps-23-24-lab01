import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import tdd.CircularList;
import tdd.CircularListImpl;

import java.util.Optional;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {

    private final static int FIRST_ITEM = 0;
    private final static int GENERIC_ITEM = 1;
    private final static int LAST_ITEM = 2;

    private CircularList circularList;

    private int addItems(){
        int itemsAdded = 3;
        circularList.add(FIRST_ITEM);
        circularList.add(GENERIC_ITEM);
        circularList.add(LAST_ITEM);
        return itemsAdded;
    }

    @BeforeEach
    void beforeEach(){
        circularList = new CircularListImpl();
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
    void forwardCyclicIteration(){
        int itemsAdded = addItems();
        for (int i = 0; i < itemsAdded; i++) {
            circularList.next();
        }
        assertEquals(FIRST_ITEM,circularList.next().orElse(GENERIC_ITEM));
    }

    @Test
    void forwardIterationWithEmptyList(){
        assertFalse(circularList.next().isPresent());
    }

    @Test
    void backwardCyclicIteration(){
        int itemsAdded = addItems();
        for (int i = 0; i < itemsAdded; i++) {
            circularList.previous();
        }
        assertEquals(LAST_ITEM,circularList.previous().orElse(GENERIC_ITEM));
    }

    @Test
    void backwardIterationWithEmptyList(){
        assertFalse(circularList.previous().isPresent());
    }

}
