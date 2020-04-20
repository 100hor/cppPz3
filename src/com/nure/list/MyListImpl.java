package com.nure.list;

import com.nure.model.Phone;

import java.util.Iterator;
import java.util.NoSuchElementException;


public class MyListImpl implements MyList {

    transient int size = 0;
    transient Node<Phone> first;
    transient Node<Phone> last;


    @Override
    public void add(Phone phone) {
        linkLast(phone);
    }

    @Override
    public void clear() {
        for (Node<Phone> x = first; x != null; ) {
            Node<Phone> next = x.next;
            x.item = null;
            x.next = null;
            x.prev = null;
            x = next;
        }
        first = last = null;
        size = 0;
    }

    @Override
    public boolean remove(Phone phone) {
        if (phone == null) {
            for (Node<Phone> x = first; x != null; x = x.next) {
                if (x.item == null) {
                    unlink(x);
                    return true;
                }
            }
        } else {
            for (Node<Phone> x = first; x != null; x = x.next) {
                if (phone.equals(x.item)) {
                    unlink(x);
                    return true;
                }
            }
        }
        return false;
    }


    @Override
    public Object[] toArray() {
        Object[] result = new Object[size];
        int i = 0;
        for (Node<Phone> x = first; x != null; x = x.next)
            result[i++] = x.item;
        return result;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(Phone phone) {
        for (Node<Phone> x = first; x != null; x = x.next) {
            if (phone.equals(x.item)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<Phone> iterator() {
        return new IteratorImpl(0);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("{");
        for (Node<Phone> x = first; x != null; x = x.next)
            result.append('[').append(x.item.toString()).append("], ");
        return result.append('}').toString();
    }





    void linkLast(Phone phone) {
        final Node<Phone> l = last;
        final Node<Phone> newNode = new Node<>(l, phone, null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;

    }


    private void checkElementIndex(int index) {
        if (!isElementIndex(index))
            throw new IndexOutOfBoundsException("Index: "+index+", Size: "+size);
    }

    private boolean isElementIndex(int index) {
        return index >= 0 && index < size;
    }

    Node<Phone> node(int index) {

        if (index < (size >> 1)) {
            Node<Phone> x = first;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x;
        } else {
            Node<Phone> x = last;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
            return x;
        }
    }

    Phone unlink(Node<Phone> x) {
        final Phone element = x.item;
        final Node<Phone> next = x.next;
        final Node<Phone> prev = x.prev;

        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            x.prev = null;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            x.next = null;
        }

        x.item = null;
        size--;
        return element;
    }

    private class IteratorImpl implements Iterator<Phone> {
        private Node<Phone> lastReturned;
        private Node<Phone> next;
        private int nextIndex;

        IteratorImpl(int index) {
            next = (index == size) ? null : node(index);
            nextIndex = index;
        }

        @Override
        public boolean hasNext() {
            return nextIndex < size;
        }

        @Override
        public Phone next() {
            if (!hasNext())
                throw new NoSuchElementException();

            lastReturned = next;
            next = next.next;
            nextIndex++;
            return lastReturned.item;
        }

        @Override
        public void remove() {
            if (lastReturned == null)
                throw new IllegalStateException();

            Node<Phone> lastNext = lastReturned.next;
            unlink(lastReturned);
            if (next == lastReturned)
                next = lastNext;
            else
                nextIndex--;
            lastReturned = null;
        }
    }


    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

}
