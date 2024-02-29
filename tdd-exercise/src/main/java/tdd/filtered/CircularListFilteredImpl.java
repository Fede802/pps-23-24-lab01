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
    public int size() {
        return this.circularList.size();
    }

    @Override
    public boolean isEmpty() {
        return this.circularList.isEmpty();
    }

    @Override
    public Optional<Integer> next() {
        return this.circularList.next();
    }

    @Override
    public Optional<Integer> previous() {
        return this.circularList.previous();
    }

    @Override
    public void reset() {
        this.circularList.reset();
    }

    @Override
    public Optional<Integer> filteredNext(Predicate<Integer> filter) {
        for (int elementSeen = 0; elementSeen < this.size(); elementSeen++) {
            Optional<Integer> nextElement = this.next();
            if(nextElement.isPresent() && filter.test(nextElement.get())){
                return nextElement;
            }
        }
        return Optional.empty();
    }
}
