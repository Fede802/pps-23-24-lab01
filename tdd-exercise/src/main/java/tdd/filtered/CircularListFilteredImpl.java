package tdd.filtered;

import tdd.CircularList;
import tdd.CircularListImpl;
import tdd.filtered.CircularListFiltered;

import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class CircularListFilteredImpl implements CircularListFiltered {

    private final CircularList circularList = new CircularListImpl();

    @Override
    public void add(int element) {
        circularList.add(element);
    }

    @Override
    public Optional<Integer> filteredNext(Predicate<Integer> filter) {
        for (int elementSeen = 0; elementSeen < circularList.size(); elementSeen++) {
            Optional<Integer> nextElement = circularList.next();
            if(nextElement.isPresent() && filter.test(nextElement.get())){
                return nextElement;
            }
        }
        return Optional.empty();
//        return Stream.generate(circularList::next).limit(circularList.size())
//                .filter(Optional::isPresent).map(Optional::get).filter(filter).findFirst();

    }
}
