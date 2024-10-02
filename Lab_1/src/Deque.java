import java.util.LinkedList;

public class Deque<T> {
    private LinkedList<T> list = new LinkedList<>();

    public void addFront(T item) {
        list.addFirst(item);
    }

    public void addBack(T item) {
        list.addLast(item);
    }

    public T removeFront() {
        return list.removeFirst();
    }

    public T removeBack() {
        return list.removeLast();
    }

    public T peekFront() {
        return list.getFirst();
    }

    public T peekBack() {
        return list.getLast();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }
}
