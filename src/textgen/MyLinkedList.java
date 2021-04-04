package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		// TODO: Implement this method
		// sentinel nodes are not used
		head = tail = null;
		size = 0;
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) 
	{
		// TODO: Implement this method
		this.add(size, element);
		return true;
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) 
	{
		// TODO: Implement this method.
		if(index >= size || index < 0) {
			throw new IndexOutOfBoundsException("List does not contain the given index");
		}

		return getNodeAtIndex(index).data;
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) {
		if (index > size || index < 0) {
			throw new IndexOutOfBoundsException("List does not contain the given index");
		}
		if (element == null) {
			throw new NullPointerException("Tried to insert null element to the list");
		}
		LLNode<E> node = new LLNode<E>(element);
		if (size == 0) {
			head = tail = new LLNode<E>(element);
		}
		else if (index == 0) { //insert at head
				node.next = head;
				head.prev = node;
				head = node;
		}
		else if (index == size) { // insert at tail
				tail.next = node;
				node.prev = tail;
				tail = node;
		}
		else {
			LLNode<E> current = getNodeAtIndex(index);
			node.next = current;
			node.prev = current.prev;
			node.prev.next = node;
			current.prev = node;
		}
		size += 1;
	}

	private LLNode<E> getNodeAtIndex (int index) {
		// Helper method
		// For get when size >= 1
		// For add at index when size > 0 and 0 < index < size
		// For remove at index when size > 1 and 0 < index < size - 1
		// For set at index when size > 1 and 0 <= index <= size - 1
		LLNode<E> current = null;
		if (index <= size / 2) { // if insertion index is closer to head, iterate forwards starting from head
			current = head;
			for (int i = 0; i < index; i++) {
				current = current.next;
			}
		} else { // if insertion index is closer to tail, iterate backwards starting from tail
			current = tail;
			for (int i = size - 1; i > index; i--) {
				current = current.prev;
			}
		}
		return current;
	}


	/** Return the size of the list */
	public int size() 
	{
		// TODO: Implement this method
		return size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		// TODO: Implement this method

		if(index >= size || index < 0) {
			throw new IndexOutOfBoundsException("List does not contain the given index");
		}
		LLNode<E> toBeRemoved = null;
		if(size == 1) {
			toBeRemoved = head;
			head = tail = null;
		} else if(index == 0) {
			toBeRemoved = head;
			head = head.next;
			head.prev = null;
		} else if(index == size - 1 ) {
			toBeRemoved = tail;
			tail = tail.prev;
			tail.next = null;
		} else {
			toBeRemoved = getNodeAtIndex(index);
			toBeRemoved.prev.next = toBeRemoved.next;
			toBeRemoved.next.prev = toBeRemoved.prev;
		}
		size -= 1;
		return toBeRemoved.data;
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{
		// TODO: Implement this method
		if (index >= size || index < 0) {
			throw new IndexOutOfBoundsException("List does not contain the given index");
		}
		if(element == null) {
			throw new NullPointerException("Tried to insert null element to the list");
		}
		LLNode<E> current = getNodeAtIndex(index);
		E oldData = current.data;
		current.data = element;
		return oldData;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		LLNode<E> current = head;
		while(current != null) {
			sb.append(current.toString() + ", ");
			current = current.next;
		}
		return sb.subSequence(0, sb.length() - 2).toString();
	}
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}

	public String toString() {
		return this.data + "";
	}

}
