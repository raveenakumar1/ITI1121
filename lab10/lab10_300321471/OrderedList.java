import java.util.NoSuchElementException;

public class OrderedList implements OrderedStructure {

    // Implementation of the doubly linked nodes (nested-class)

    private static class Node {

      	private Comparable value;
      	private Node previous;
      	private Node next;

      	private Node ( Comparable value, Node previous, Node next ) {
      	    this.value = value;
      	    this.previous = previous;
      	    this.next = next;
      	}
    }

    // Instance variables

    private Node head;

    // Representation of the empty list.

    public OrderedList() {
        head = new Node(null,null,null);
		head.next = head.previous = head;
    }

    // Calculates the size of the list

    public int size() {
      	int size = 0;
		Node current = head.next;
		while (current != head) {
			current = current.next;
			size++;
		}
		return size;
    }


    public Object get( int pos ) {
       if (pos < 0 || pos >= size()){
         throw new IndexOutOfBoundsException();
      }
	  int index = 0;
		Node current = head.next;
		while (index != pos) {
			current = current.next;
			index++;
		}
		return current.value;
    }

    // Adding an element while preserving the order

    public boolean add( Comparable o ) {
        if (o == null) {
			throw new IllegalArgumentException(); 
		}
		Node current = head.next;
		while (current != head) {
			if (current.value.compareTo(o) > 0) {
				break;
			}
			current = current.next;
		}
		Node newNode = new Node(o, current.previous,current);
		current.previous.next = newNode;
		current.previous = newNode;
		return true;
    }

    //Removes one item from the position pos.

    public void remove( int pos ) {
       if (pos < 0 || pos >= size()){
         throw new IndexOutOfBoundsException();
      }
	  int index = 0;
		Node current = head.next;
		while (index != pos) {
			current = current.next;
			index++;
		}
		current.previous.next = current.next;
		current.next.previous = current.previous;
    }

    // Knowing that both lists store their elements in increasing
    // order, both lists can be traversed simultaneously.

    public void merge( OrderedList other ) {
		if (other == null) {
			throw new IllegalArgumentException(); 
		}
		Node current = head.next;
		Node val = other.head.next;
		while (val != other.head) {
			if (current == head || current.value.compareTo(val.value) > 0) {
				Node newNode = new Node (val.value, current.previous, current);
				current.previous.next = newNode;
				current.previous = newNode;
				val = val.next;
			} else {
				current = current.next;
			}
		}
    }
}