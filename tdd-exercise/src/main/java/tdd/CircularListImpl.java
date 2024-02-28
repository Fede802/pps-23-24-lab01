package tdd;

import tdd.CircularList;

import java.util.Optional;

public class CircularListImpl implements CircularList {

    private int size;

    @Override
    public void add(int element) {
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public Optional<Integer> next() {
        return Optional.empty();
    }

    @Override
    public Optional<Integer> previous() {
        return Optional.empty();
    }

    @Override
    public void reset() {

    }
}
