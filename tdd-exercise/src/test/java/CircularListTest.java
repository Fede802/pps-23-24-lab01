import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tdd.CircularList;
import tdd.CircularListImpl;
import tdd.filtered.CircularListFiltered;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {

    private final static int FIRST_ITEM = 0;
    private final static int GENERIC_ITEM = 1;
    private final static int LAST_ITEM = 2;

    private CircularList circularList;

    protected void setCircularList(CircularListFiltered circularList) {
        this.circularList = circularList;
    }
    private int addElements(){
        int numberOfElementsAdded = 3;
        this.circularList.add(FIRST_ITEM);
        this.circularList.add(GENERIC_ITEM);
        this.circularList.add(LAST_ITEM);
        return numberOfElementsAdded;
    }

    @BeforeEach
    void beforeEach(){
        this.circularList = new CircularListImpl();
    }
    @Test
    void isInitiallyEmpty(){
        assertTrue(this.circularList.isEmpty());
    }
    @Test
    void addElement(){
        this.circularList.add(FIRST_ITEM);
        assertFalse(this.circularList.isEmpty());
    }
    @Test
    void addMultipleElements(){
        int numberOfElementsAdded = this.addElements();
        assertEquals(numberOfElementsAdded,this.circularList.size());
    }
    @Test
    void forwardIteration(){
        int numberOfElementsAdded = this.addElements();
        for (int i = 1; i < numberOfElementsAdded; i++) {
            this.circularList.next();
        }
        assertEquals(LAST_ITEM,this.circularList.next().orElse(GENERIC_ITEM));
    }
    @Test
    void forwardCyclicIteration(){
        int numberOfElementsAdded = this.addElements();
        for (int i = 0; i < numberOfElementsAdded; i++) {
            this.circularList.next();
        }
        assertEquals(FIRST_ITEM,this.circularList.next().orElse(GENERIC_ITEM));
    }

    @Test
    void forwardIterationWithEmptyList(){
        assertFalse(this.circularList.next().isPresent());
    }

    @Test
    void backwardIteration(){
        int numberOfElementsAdded = this.addElements();
        for (int i = 1; i < numberOfElementsAdded; i++) {
            this.circularList.previous();
        }
        assertEquals(FIRST_ITEM,this.circularList.previous().orElse(GENERIC_ITEM));
    }
    @Test
    void backwardCyclicIteration(){
        int numberOfElementsAdded = this.addElements();
        for (int i = 0; i < numberOfElementsAdded; i++) {
            this.circularList.previous();
        }
        assertEquals(LAST_ITEM,this.circularList.previous().orElse(GENERIC_ITEM));
    }

    @Test
    void backwardIterationWithEmptyList(){
        assertFalse(this.circularList.previous().isPresent());
    }

    @Test
    void reset(){
        this.addElements();
        this.circularList.next();
        this.circularList.reset();
        assertEquals(FIRST_ITEM,this.circularList.next().orElse(GENERIC_ITEM));
    }


}
