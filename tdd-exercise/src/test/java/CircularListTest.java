import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import tdd.CircularList;
import tdd.CircularListImpl;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {

    @Test
    void isInitiallyEmpty(){
        CircularList circularList = new CircularListImpl();
        assertTrue(circularList.isEmpty());
    }


}
