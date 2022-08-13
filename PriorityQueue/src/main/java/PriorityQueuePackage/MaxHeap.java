/**
 * {@link PriorityQueuePackage.MaxHeapHeap contains the implementation of siftDown() and siftUp()  }
 */

package PriorityQueuePackage;

import java.util.Comparator;
import java.util.List;

public class MaxHeap<T> extends PriorityQueue<T> {

    public MaxHeap() {
    }

    public MaxHeap(Comparator<T> myNewComparator) {
        super(myNewComparator);
    }

    public MaxHeap(T[] objects) {
        super(objects);
    }

    public MaxHeap(T[] objects, Comparator<T> myNewComparator) {
        super(objects, myNewComparator);
    }

    public MaxHeap(List<T> objects) {
        super(objects);
    }

    public MaxHeap(List<T> objects, Comparator<T> myNewComparator) {
        super(objects, myNewComparator);
    }

    /**
     * After appending a new Object to the end of the list/Heap, it is compared with its parent; if the
     * child is bigger than the parent, swap the child with the parent. repeat the process with the new
     * parent
     */
    @Override
    public void siftUp() {
        int currentPointer = getList().size() - 1; //to always point to the last appended item
        while (currentPointer > 0) {
            int parent = (currentPointer - 1) / 2;
            if (getComparator().compare(getList().get(currentPointer),
                    getList().get(parent)) > 0) {
                swap(currentPointer, parent);
            } else {
                break;
            }
            currentPointer = parent;
        }
    }

    /**
     * After pop(), the last added element is added to the list, to keep the MaxHeap invariant, we compare the
     * root node, with its left and right child, and replace the head with the bigger child. the process is repeated
     * until the root is now a leaf, or the heap invariant is resorted.
     */
    @Override
    public void siftDown() {
        int pointerIndex = 0; //starting at the root
        while (pointerIndex < getList().size()) {
            int leftChildIndex = 2 * pointerIndex + 1;
            int rightChildIndex = 2 * pointerIndex + 2;
            /* while loop terminating condition */
            // when the heap invariant is restored.
            // check is done on left child, as elements are added according to level order insertion. (left to right)
            if (leftChildIndex >= getList().size()) {
                //ex: list size = 14, pointerIndex = 10 , leftChild = 21.
                break;
            }
            //Arbitrary assignment of max to the left child
            int max = leftChildIndex;
            if (rightChildIndex < getList().size()) {
                //checking index out of bound; if the parent have right child.
                //ex: [1,2,3,4] 2 has no right child parent = 2, parent index =1, leftChildIndex = 4, no right child
                if (getComparator().compare(getList().get(max),
                        getList().get(rightChildIndex)) < 0) {
                    //if the right child is bigger.
                    max = rightChildIndex;
                }
            }
            //if the left child is bigger.
            if (getComparator().compare(getList().get(pointerIndex),
                    getList().get(max)) < 0) {
                swap(max, pointerIndex);
                // pointerIndex that was pointing to the parent, is now pointing to the child
                //that it had just replaced, repeating the sift down on this child.
                pointerIndex = max;
            } else {
                break;
            }
        }
    }
}
