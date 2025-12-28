import java.util.ArrayList;

/**
 * Custom Queue implementation using ArrayList.
 * FIFO: First In, First Out
 * 
 * Build phase for Queues module.
 */
public class MyQueue<T> {
    private ArrayList<T> data;

    public MyQueue() {
        data = new ArrayList<>();
    }

    /**
     * Add element to back of queue.
     */
    public void offer(T item) {
        data.add(item);
    }

    /**
     * Remove and return front element. Returns null if empty.
     */
    public T poll() {
        if (isEmpty()) {
            return null;
        }
        return data.remove(0);
    }

    /**
     * Return front element without removing. Returns null if empty.
     */
    public T peek() {
        if (isEmpty()) {
            return null;
        }
        return data.get(0);
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    public int size() {
        return data.size();
    }
}
