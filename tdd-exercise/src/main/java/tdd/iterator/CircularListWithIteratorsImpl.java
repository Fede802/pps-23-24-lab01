package tdd.iterator;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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
        return new ForwardIterator();
    }

    @Override
    public Iterator<Integer> backwardIterator() {
        return new BackwardIterator();
    }

    private class ForwardIterator implements Iterator<Integer>{
        private int index = -1;
        @Override
        public boolean hasNext() {
            return this.index+1 < circularList.size();
        }

        @Override
        public Integer next() {
            this.index = this.hasNext() ? this.index+1 : 0;
            return circularList.get(index);
        }
    }

    private class BackwardIterator implements Iterator<Integer>{
        private int index = circularList.size();
        @Override
        public boolean hasNext() {
            return this.index-1 >= 0;
        }

        @Override
        public Integer next() {
            this.index = this.hasNext() ? this.index-1 : circularList.size()-1;
            return circularList.get(this.index);
        }
    }


}


