/**
 * {@link PriorityQueuePackage.PriorityQueue acts as an implementation interface in the Degenerated bridge design patterm, contains all
 * the commong functionalities of MaxHeap and MinHeap}.
 * This file contains an implementation of Priority queue, all Comparable items are allowed in this implementation,
 * Supported operations include {add, pop, decreaseKey, IncreaseKey}.
 */
package PriorityQueuePackage;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public abstract class PriorityQueue<T> {
    /**
     * Implementation of a priority queue is done using ArrayLists.
     */
    private final ArrayList<T> list = new ArrayList<>();
    /**
     * Declaration of a comparator, to either invoke the compareTo methods of two comparable elements of the same
     * class, or to be overridden by a user specified comparator, or to be used if the Objects need to be compared
     * does not implement the comparable interface and need their own compareTo method.
     */
    private final Comparator<? super T> comparator;

    /**
     * The Empty Constructor used when, the input Objects are comparable, to compare them in the Natural Order.
     */
    public PriorityQueue() {
        this.comparator = (e1, e2) -> ((Comparable<T>) e1).compareTo(e2);
    }

    /**
     * @param myNewComparator user specified Comparator.
     */
    public PriorityQueue(Comparator<T> myNewComparator) {
        this.comparator = myNewComparator;
    }

    /**
     * Creates a priority queue of objects[], arranged in the natural Order.
     *
     * @param objects array of Objects to be added to the Heap
     */
    public PriorityQueue(T[] objects) {

        this.comparator = (e1, e2) -> {
            return ((Comparable<T>) e1).compareTo(e2);
        };
        for (T item : objects) {
            add(item);
        }
    }

    /**
     * @param objects         array of Objects to be added to the Heap
     * @param myNewComparator user specified Comparator
     */
    public PriorityQueue(T[] objects, Comparator<T> myNewComparator) {
        this.comparator = myNewComparator;
        for (T item : objects) {
            add(item);
        }
    }

    public PriorityQueue(List<T> objects) {
        this.comparator = (e1, e2) -> ((Comparable<T>) e1).compareTo(e2);
        for (T item : objects) {
            add(item);
        }

    }

    public PriorityQueue(List<T> objects, Comparator<T> myNewComparator) {
        this.comparator = myNewComparator;
        for (T item : objects) {
            add(item);
        }
    }

    //restores the Heap Invariant after adding a new item at the end of the tree
    protected abstract void siftUp();

    //restores the Heap Invariant after a pop Operation
    protected abstract void siftDown();

    /**
     * @param child  the Object that will replace the parent.
     * @param parent the Object that will be replaced by the child.
     */
    public void swap(Integer child, Integer parent) {
        T temp = list.get(child);
        list.set(child, list.get(parent));
        list.set(parent, temp);
    }

    public void add(T items) {
        list.add(items);
        siftUp();
    }

    /**
     * Substitutes the Heap`s root with the last added element in the heap, then removes the Root.
     * siftDown is then used to keep the Heap Invariant.
     *
     * @return return the root of the Heap
     */
    public T pop() {
        if (list.size() == 0) {
            return null;
        }
        T headOfTheHeap = list.get(0);
        list.set(0, list.get(list.size() - 1));
        list.remove(list.size() - 1);
        siftDown();
        return headOfTheHeap;
    }

    public int getSize() {
        return list.size();
    }

    protected ArrayList<T> getList() {
        return list;
    }

    protected Comparator<? super T> getComparator() {
        return comparator;
    }


    /**
     * @param from the value object to decrease.
     * @param to   the value that will replace from.
     * @throws IllegalArgumentException if the value is not present in the heap.
     */
    public void decreaseKey(T from, T to) {
        if (list.contains(from)) {
            if (comparator.compare(from, to) > 0) {
                list.remove(from);
                add(to);
            }
        } else {
            throw new IllegalArgumentException("value you want to replace, does not Exist");
        }

    }

    /**
     * @param from the value object to increase.
     * @param to   the value that will replace from.
     * @throws IllegalArgumentException if the value is not present in the heap.
     */
    public void increaseKey(T from, T to) {
        if (list.contains(from)) {
            if (comparator.compare(from, to) < 0) {
                list.remove(from);
                add(to);
            }
        } else {
            throw new IllegalArgumentException("value you want to replace, does not Exist");
        }
    }

    /**
     * @param object to be searched for in the Heap.
     * @return true, if object exists in the heap.
     * @throws IllegalArgumentException if the heap is Empty or the heap does not contain the object.
     */
    public boolean find(T object) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("Heap is Empty");
        }
        if (list.contains(object)) {
            return true;
        } else {
            throw new IllegalArgumentException("List does not contain : " + object);
        }
    }
}
