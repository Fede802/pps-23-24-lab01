package tdd.iterator;

import tdd.iterator.CircularListWithIterators;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CircularListWithIteratorsImpl implements CircularListWithIterators {

    private final List<Integer> circularList = new ArrayList<>();
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
    public Iterator<Integer> forwardIterator() {
        return circularList.iterator();
    }

    @Override
    public Iterator<Integer> backwardIterator() {
        return null;
    }
}
