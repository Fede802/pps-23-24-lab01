package tdd.filtered;
import java.util.Optional;
import java.util.function.Predicate;

public interface CircularListFiltered {

    /**
     * Adds an element to the list, namely, after the last inserted one.
     * @param element the element to be added to the list
     */
    void add(final int element);

    /**
     * Provides the next element of the list, matching the provided filter
     * @param filter the filter that will be used
     * @return the next element of the list matching the provided filter, or an empty optional if the list is empty
     */
    Optional<Integer> filteredNext(final Predicate<Integer> filter);

}
