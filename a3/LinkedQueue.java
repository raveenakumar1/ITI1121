public class LinkedQueue<D> implements Queue<D> {

    private static class Elem<T> {
        private T value;
        private Elem<T> next;

        private Elem(T value, Elem<T> next) {
            this.value = value;
            this.next = next;
        }
    }

    private Elem<D> front;
    private Elem<D> rear;
    private int count = 0;

    public LinkedQueue() {
        front = rear = null;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public void enqueue(D newElement) {

        if (newElement == null) {
            throw new NullPointerException("no null object in my queue !");
            // could have been IllegalArgumentException but NPE seems
            // to be the norm
        }

        Elem<D> newElem;
        newElem = new Elem<D>(newElement, null);
        if (isEmpty()) {
            front = newElem;
            rear = newElem;
        } else {
            rear.next = newElem;
            rear = newElem;
        }
        count++;
    }

    public D dequeue() {

        if (isEmpty()) {
            throw new IllegalStateException("Dequeue method called on an empty queue");
        }

        D returnedValue;
        returnedValue = front.value;

        if (front.next == null) {
            front = rear = null;
        } else {
            front = front.next;
        }
        count--;
        return returnedValue;
    }

    public D peek() {
        if(isEmpty()){
            throw new IllegalStateException("Peek method called on an empty queue");
        }
        D ans = front.value;
        return ans;
    }

    public int size() {
        return count;
    }

    public String toString() {

        StringBuffer returnedValue = new StringBuffer("[");

        if (!isEmpty()) {
            Elem<D> cursor = front;
            returnedValue.append(cursor.value);
            while (cursor.next != null) {
                cursor = cursor.next;
                returnedValue.append(", " + cursor.value);
            }
        }

        returnedValue.append("]");
        return returnedValue.toString();

    }
}