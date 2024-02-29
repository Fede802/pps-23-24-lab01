package tdd.filtered;
import java.util.Optional;
import java.util.function.Predicate;

public interface CircularListFiltered {

    void add(final int element);
    Optional<Integer> filteredNext(final Predicate<Integer> filter);

}
