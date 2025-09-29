public class MyQueue {
    private int[] queueElements;
    private int frontIndex;
    private int rearIndex;
    private int currentSize;
    private static final int DEFAULT_CAPACITY = 10;

    public MyQueue() {
        this(DEFAULT_CAPACITY);
    }

    public MyQueue(int initialCapacity) {
        queueElements = new int[initialCapacity];
        frontIndex = 0;
        rearIndex = 0;
        currentSize = 0;
    }

    public void enqueue(int newElement) {
        if (currentSize == queueElements.length) {
            expandCapacity();
        }
        if (rearIndex == queueElements.length && currentSize < queueElements.length) {
            shiftElementsToFront();
        }
        queueElements[rearIndex] = newElement;
        rearIndex++;
        currentSize++;
    }

    public int dequeue() {
        if (isEmpty()) throw new RuntimeException("Queue is empty");
        int removedElement = queueElements[frontIndex];
        frontIndex++;
        currentSize--;
        return removedElement;
    }

    public int peek() {
        if (isEmpty()) throw new RuntimeException("Queue is empty");
        return queueElements[frontIndex];
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }

    public int size() {
        return currentSize;
    }

    private void expandCapacity() {
        int newCapacity = queueElements.length * 2;
        int[] expandedQueue = new int[newCapacity];
        for (int position = 0; position < currentSize; position++) {
            expandedQueue[position] = queueElements[frontIndex + position];
        }
        queueElements = expandedQueue;
        rearIndex = currentSize;
        frontIndex = 0;
    }

    private void shiftElementsToFront() {
        for (int position = 0; position < currentSize; position++) {
            queueElements[position] = queueElements[frontIndex + position];
        }
        rearIndex = currentSize;
        frontIndex = 0;
    }
}
