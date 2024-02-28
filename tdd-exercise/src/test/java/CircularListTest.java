import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import tdd.CircularList;
import tdd.CircularListImpl;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {

    private final static int FIRST_ITEM = 0;

    private final static int GENERIC_ITEM = 1;
    private final static int LAST_ITEM = 2;
    private CircularList circularList;

    private void addItems(){
        circularList.add(FIRST_ITEM);
        circularList.add(GENERIC_ITEM);
        circularList.add(LAST_ITEM);
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
        addItems();
        assertFalse(circularList.isEmpty());
    }
}
