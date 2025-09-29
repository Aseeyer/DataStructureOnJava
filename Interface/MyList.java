public class MyList {
    private int[] listElements;
    private int currentSize;
    private static final int DEFAULT_CAPACITY = 10;

    public MyList() {
        listElements = new int[DEFAULT_CAPACITY];
        currentSize = 0;
    }

    public void add(int newElement) {
        ensureCapacity();
        listElements[currentSize] = newElement;
        currentSize++;
    }

    public int get(int targetIndex) {
        validateIndex(targetIndex);
        return listElements[targetIndex];
    }

    public void remove(int targetIndex) {
        validateIndex(targetIndex);
        for (int position = targetIndex; position < currentSize - 1; position++) {
            listElements[position] = listElements[position + 1];
        }
        currentSize--;
    }

    public int size() {
        return currentSize;
    }

    public void clear(){
        currentSize = 0;
    }

    private void ensureCapacity() {
        if (currentSize == listElements.length) {
            int newCapacity = listElements.length * 2;
            int[] expandedList = new int[newCapacity];
            System.arraycopy(listElements, 0, expandedList, 0, listElements.length);
            listElements = expandedList;
        }
    }

    private void validateIndex(int targetIndex) {
        if (targetIndex < 0 || targetIndex >= currentSize) {
            throw new IndexOutOfBoundsException("Invalid index: " + targetIndex);
        }
    }

    public void set(int index, int newValue) {
        validateIndex(index);
        listElements[index] = newValue;
    }


}
