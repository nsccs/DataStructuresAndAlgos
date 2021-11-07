/**
 * Circular Linked List Class. Created during a live coding session as part of
 * North Seattle College Computer Science Club.
 * The code was created on the fly, as an example on how to think about and
 * design a data structure. The requirement was to design a circular list using
 * a Linked List of Nodes.
 * Some methods are left as an exercise for the students to implement.
 *
 * Date: 10/31/2021
 * @author: Jardi A. M. Jordan
 */
package com.jmj.containers;

/**
 * Represents a Circular Linked List where the note at the tail of the list
 * points to the one at the head, so you can iterate through it in a circular
 * manner.
 * @param <E>   Type of the elements to be stored in the list
 */
public class CircularLinkedList<E> {
    private Node<E> head;
    private Node<E> tail;
    private int size;

    /**
     * Constructs an empty Circular Linked List
     */
    public CircularLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * Returns true if the Circular Linked List is empty otherwise false.
     * @return  True if the Circular Linked List is empty otherwise false.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Inserts a new element at the Front of the Circular Linked List.
     * @param value Element to be added at the Front of the Circular Linked List.
     */
    public void pushFront(E value) {
        Node<E> newNode = new Node<>(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
            newNode.next = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    /**
     * Retrieves the Element at the Front of the Circular Linked List.
     * @return  The Element at the Front of the Circular Linked List.
     */
    public E peekFront() {
        if (head == null) {
            return null;
        }
        return head.data;
    }

    /**
     * Adds a new Element to the Back of the Circular Linked List.
     * @param element   Element to be added at the Back of the Circular Linked
     *                  List.
     */
    public void pushBack(E element) {
        // ToDo: Implementation left as an exercise for the students.
    }

    /**
     * Retrieves the Value of the Element stored at the given index. The index
     * Numbering starts at 0 at the Front of the Circular Linked List.
     *
     * @param idx   The index of the target Element.
     * @return  The value of the Element stored at the given index.
     */
    public E atIndex(int idx) {
        // ToDo: Implementation left as an exercise for the students.
        return null;
    }

    /**
     * Retrieves and removes the Element stored at the Front of the Circular
     * Linked List.
     * @return  The Element at the Front of the Circular Linked List.
     */
    public E popFront() {
        if (head == null) {
            return null;
        }

        E element = head.data;
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            head = head.next;
        }
        size--;
        return element;
    }

    /**
     * Retrieves and removes the Element stored at the Back of the Circular
     * Linked List.
     * @return  The Element at the Back of the Circular Linked List.
     */
    public E popBack() {
        if (head == null) { // List is empty
            return null;
        }

        if (head == tail) { // List has only one element
            E value = tail.data;
            head = null;
            tail = null;
            size--;
            return value;
        }

        Node<E> current = head;
        while (current.next != tail) {  // Stop at the element before the tail
            current = current.next;
        }

        E element = current.next.data;
        current.next = current.next.next;
        tail = current;
        size--;
        return element;
    }

    /**
     * Retrieves the size of the Circular Linked List.
     * @return  The size of the Circular Linked List.
     */
    public int size() {
        return size;
    }

    /**
     * Represents a linking Node, which contains a data value and a pointer to the next
     * Node in a chained list.
     * @param <T>
     */
    private class Node<T> {
        public T data;
        public Node<T> next;

        /**
         * Constructs a Node with the given data value.
         * @param data  The value to be stored in this Node.
         */
        public Node(T data) {
            this(data, null);
        }

        /**
         * Construct a Node with the given data value and its next pointer referencing
         * the given Node.
         *
         * @param data  The value to be stored in this Node.
         * @param next  The next node in the linked list.
         */
        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }

        /**
         * Default Node constructor.
         */
        public Node() { }
    }
}
