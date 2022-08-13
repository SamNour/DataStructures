/**
 * {@link PriorityQueuePackage.Abstraction part of the degenerated Brdige pattern,
 * it Acts as the abstraction class for the client.}
 */
package PriorityQueuePackage;

public class Abstraction<T> {
    private final PriorityQueue<T> priorityQueue;

    public Abstraction(PriorityQueue<T> priorityQueue) {
        this.priorityQueue = priorityQueue;
    }

    public void add(T item) {
        priorityQueue.add(item);
    }

    public T pop() {
        return priorityQueue.pop();
    }

    public boolean find(T object) {
        return priorityQueue.find(object);
    }

    public void decreaseKey(T from, T to) {
        priorityQueue.decreaseKey(from, to);
    }

    public void increaseKey(T from, T to) {
        priorityQueue.increaseKey(from, to);
    }

    public int getSize() {
        return priorityQueue.getSize();
    }

}
