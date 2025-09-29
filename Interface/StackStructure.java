public class StackStructure {
    private int count = 0;

    public boolean isEmpty() {
        return count == 0;
    }

    public void pushElement(int newElement) {
        count++;
    }

    public void popElement() {
        if (count == 0) {
            throw new RuntimeException("Stack is empty");
        }
        count--;
    }

    public int getCount() {
        return count;
    }
}
