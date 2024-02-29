import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tdd.filtered.CircularListFiltered;
import tdd.filtered.CircularListFilteredImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class CircularListFilteredTest extends CircularListTest{

    private final static int FIRST_EVEN_ITEM = 0;
    private final static int FIRST_ODD_ITEM = 1;
    private final static int SECOND_EVEN_ITEM = 2;

    private CircularListFiltered circularList;
    private int addElements(){
        int numberOfElementsAdded = 3;
        circularList.add(FIRST_EVEN_ITEM);
        circularList.add(FIRST_ODD_ITEM);
        circularList.add(SECOND_EVEN_ITEM);
        return numberOfElementsAdded;
    }

    private boolean evenFilter(int element){
        return element%2 == 0;
    }

    private boolean identityFilter(int element){
        return true;
    }
    @BeforeEach
    void beforeEach(){
        this.circularList = new CircularListFilteredImpl();
        super.circularList = this.circularList;
    }

    @Test
    void evenFilter(){
        this.addElements();
        this.circularList.filteredNext(this::evenFilter);
        assertEquals(SECOND_EVEN_ITEM,this.circularList.filteredNext(this::evenFilter).orElse(FIRST_ODD_ITEM));
    }

    @Test
    void evenCyclicFilter(){
        int numberOfElementsAdded = this.addElements();
        for (int i = 0; i < numberOfElementsAdded; i++) {
            this.circularList.filteredNext(this::identityFilter);
        }
        assertEquals(FIRST_EVEN_ITEM,this.circularList.filteredNext(this::evenFilter).orElse(FIRST_ODD_ITEM));
    }

    @Test
    void evenFilterWithEmptyList(){
        this.circularList = new CircularListFilteredImpl();
        assertFalse(this.circularList.filteredNext(this::evenFilter).isPresent());
    }

}
