public class MyLinkedList {
    private Node headNode;
    private int currentSize;

    private static class Node {
        int value;
        Node nextNode;

        Node(int value) {
            this.value = value;
            this.nextNode = null;
        }
    }

    public MyLinkedList() {
        headNode = null;
        currentSize = 0;
    }

    public void add(int newValue) {
        Node newNode = new Node(newValue);
        if (headNode == null) {
            headNode = newNode;
        } else {
            Node currentNode = headNode;
            while (currentNode.nextNode != null) {
                currentNode = currentNode.nextNode;
            }
            currentNode.nextNode = newNode;
        }
        currentSize++;
    }

    public int get(int targetIndex) {
        validateIndex(targetIndex);
        Node currentNode = headNode;
        for (int position = 0; position < targetIndex; position++) {
            currentNode = currentNode.nextNode;
        }
        return currentNode.value;
    }

    public void set(int targetIndex, int newValue) {
        validateIndex(targetIndex);
        Node currentNode = headNode;
        for (int position = 0; position < targetIndex; position++) {
            currentNode = currentNode.nextNode;
        }
        currentNode.value = newValue;
    }

    public void removeAt(int targetIndex) {
        validateIndex(targetIndex);
        if (targetIndex == 0) {
            headNode = headNode.nextNode;
        } else {
            Node currentNode = headNode;
            for (int position = 0; position < targetIndex - 1; position++) {
                currentNode = currentNode.nextNode;
            }
            currentNode.nextNode = currentNode.nextNode.nextNode;
        }
        currentSize--;
    }

    public void clear() {
        headNode = null;
        currentSize = 0;
    }

    public int size() {
        return currentSize;
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }

    private void validateIndex(int targetIndex) {
        if (targetIndex < 0 || targetIndex >= currentSize) {
            throw new IndexOutOfBoundsException("Invalid index: " + targetIndex);
        }
    }
}
