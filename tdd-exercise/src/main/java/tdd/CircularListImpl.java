package tdd;

import tdd.CircularList;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CircularListImpl implements CircularList {

    private final List<Integer> circularList = new ArrayList<>();
    private int currentItemIndex = 0;

    private boolean hasNext(){
        return this.currentItemIndex+1 < this.circularList.size();
    }

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
        return this.size() == 0;
    }

    @Override
    public Optional<Integer> next() {
        if (this.isEmpty()) return Optional.empty();
        Optional<Integer> nextItem = Optional.of(this.circularList.get(this.currentItemIndex));
        this.currentItemIndex = hasNext() ? this.currentItemIndex+1 : 0;
        return nextItem;
    }

    @Override
    public Optional<Integer> previous() {
        return Optional.empty();
    }

    @Override
    public void reset() {

    }
}
