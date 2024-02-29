package tdd.filtered;

import tdd.CircularList;
import tdd.CircularListImpl;

import java.util.Optional;
import java.util.function.Predicate;

public class CircularListFilteredImpl implements CircularListFiltered {

    private final CircularList circularList = new CircularListImpl();

    @Override
    public void add(int element) {
        this.circularList.add(element);
    }

    @Override
    public Optional<Integer> filteredNext(Predicate<Integer> filter) {
        for (int elementSeen = 0; elementSeen < this.circularList.size(); elementSeen++) {
            Optional<Integer> nextElement = this.circularList.next();
            if(nextElement.isPresent() && filter.test(nextElement.get())){
                return nextElement;
            }
        }
        return Optional.empty();
    }
}
