import org.junit.jupiter.api.Test;
import tdd.filtered.CircularListFiltered;
import tdd.filtered.CircularListFilteredImpl;

import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class CircularListFilteredTest {

    private final static int FIRST_EVEN_ITEM = 0;
    private final static int FIRST_ODD_ITEM = 1;
    private final static int SECOND_EVEN_ITEM = 2;

    CircularListFiltered circularList;
    private int addItems(){
        int itemsAdded = 3;
        circularList.add(FIRST_EVEN_ITEM);
        circularList.add(FIRST_ODD_ITEM);
        circularList.add(SECOND_EVEN_ITEM);
        return itemsAdded;
    }

    private boolean evenFilter(int element){
        return element%2 == 0;
    }
    @Test
    void evenFilter(){
        circularList = new CircularListFilteredImpl();
        addItems();
        circularList.filteredNext(this::evenFilter);
        assertEquals(SECOND_EVEN_ITEM,circularList.filteredNext(this::evenFilter).orElse(FIRST_ODD_ITEM));
    }

    


}
