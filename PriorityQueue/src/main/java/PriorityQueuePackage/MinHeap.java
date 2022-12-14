/**
 * {@link PriorityQueuePackage.MinHeap contains the implementation of siftDown() and siftUp()  }
 */
package PriorityQueuePackage;

import java.util.Comparator;
import java.util.List;

public class MinHeap<T> extends PriorityQueue<T> {

    public MinHeap() {
    }

    public MinHeap(Comparator<T> myNewComparator) {
        super(myNewComparator);
    }

    public MinHeap(T[] objects) {
        super(objects);
    }

    public MinHeap(T[] objects, Comparator<T> myNewComparator) {
        super(objects, myNewComparator);
    }

    public MinHeap(List<T> objects) {
        super(objects);
    }

    public MinHeap(List<T> objects, Comparator<T> myNewComparator) {
        super(objects, myNewComparator);
    }


    /**
     * After appending a new Object to the end of the list/Heap, it is compared with its parent; if the
     * child is smaller than the parent, swap the child with the parent. repeat the process with the new
     * parent
     */
    @Override
    public void siftUp() {
        int currentPointer = getList().size() - 1;
        while (currentPointer > 0) {
            int parent = (currentPointer - 1) / 2;
            if (getComparator().compare(getList().get(currentPointer),
                    getList().get(parent)) < 0) {
                swap(currentPointer, parent);
            } else {
                break;
            }
            currentPointer = parent;
        }
    }

    /**
     * After pop(), the last added element is added to the list, to keep the MaxHeap invariant, we compare the
     * root node, with its left and right child, and replace the head with the smaller child. the process is repeated
     * until the root is now a leaf, or the heap invariant is resorted.
     */
    @Override
    public void siftDown() {
        int pointer = 0;

        while (pointer < getList().size()) {
            int leftChildIndex = 2 * pointer + 1;
            int rightChildIndex = 2 * pointer + 2;

            /* terminating condition */
            if (leftChildIndex >= getList().size()) {
                break;
            }
            int max = leftChildIndex;
            if (rightChildIndex < getList().size()) {//if right child exist
                if (getComparator().compare(getList().get(max),
                        getList().get(rightChildIndex)) > 0) {
                    max = rightChildIndex;
                }
            }
            if (getComparator().compare(getList().get(pointer),
                    getList().get(max)) > 0) {
                swap(max, pointer);
                pointer = max;
            } else {
                break;
            }
        }
    }
}
