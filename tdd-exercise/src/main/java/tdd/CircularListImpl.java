package tdd;

import tdd.CircularList;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CircularListImpl implements CircularList {

    private final List<Integer> circularList = new ArrayList<>();
    private int currentItemIndex = -1;

    private boolean hasNext(){
        return this.currentItemIndex+1 < this.circularList.size();
    }

    private boolean hasPrevious(){
        return this.currentItemIndex-1 >= 0;
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
        this.currentItemIndex = hasNext() ? this.currentItemIndex+1 : 0;
        Optional<Integer> nextItem = Optional.of(this.circularList.get(this.currentItemIndex));
        return nextItem;
    }

    @Override
    public Optional<Integer> previous() {
        if (this.isEmpty()) return Optional.empty();
        System.out.println(this.currentItemIndex);
        System.out.println(hasPrevious());
        this.currentItemIndex = hasPrevious() ? this.currentItemIndex-1 : this.circularList.size()-1;
        System.out.println(this.currentItemIndex);
        return Optional.of(this.circularList.get(this.currentItemIndex));
    }

    @Override
    public void reset() {
        this.currentItemIndex = -1;
    }
}
