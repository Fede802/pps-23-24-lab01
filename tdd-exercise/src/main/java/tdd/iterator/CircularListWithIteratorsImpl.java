package tdd.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CircularListWithIteratorsImpl implements CircularListWithIterators {

    private final List<Integer> circularList = new ArrayList<>();
    private final Iterator<Integer> forwardIterator = new Iterator<Integer>() {
        private int currentItemIndex = -1;
        @Override
        public boolean hasNext() {
            return this.currentItemIndex+1 < circularList.size();
        }

        @Override
        public Integer next() {
            this.currentItemIndex = hasNext() ? this.currentItemIndex+1 : 0;
            return circularList.get(this.currentItemIndex);
        }
    };

//    private final Iterator<Integer> backwardIterator =
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
        return null;
    }

    public class ForwardIterator implements Iterator<Integer>{
        private int index = -1;
        @Override
        public boolean hasNext() {
            return this.index+1 < circularList.size();
        }

        @Override
        public Integer next() {
            this.index = hasNext() ? this.index+1 : 0;
            return circularList.get(index);
        }
    }

    
}


