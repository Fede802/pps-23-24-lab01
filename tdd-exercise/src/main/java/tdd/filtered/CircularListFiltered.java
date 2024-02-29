package tdd.filtered;
import tdd.CircularList;

import java.util.Optional;
import java.util.function.Predicate;

public interface CircularListFiltered extends CircularList {

    /**
     * Provides the next element of the list, matching the provided filter
     * @param filter the filter that will be used
     * @return the next element of the list matching the provided filter, or an empty optional if the list is empty
     */
    Optional<Integer> filteredNext(final Predicate<Integer> filter);

}
