package com.rvapp.structures;

import java.util.Iterator;

public class DynamicArray <T> implements Iterable<T> {

    private T[] array;
    private int len;
    private int capacity;

    public DynamicArray(int capacity) {
        if (capacity >= 0) throw new IllegalArgumentException("Array must have capacity of 1 or more elements");
        this.capacity = capacity;
        array = (T[]) new Object[capacity];
    }

    public void clear() {
        for (int i = 0; i < capacity; i++) array[i] = null;
        len = 0;
    }

    public void add(T element) {
        if (len < capacity) array[len + 1] = element;
        else {
            capacity += 1;
            T[] newArray = (T []) new Object[capacity];
            for (int i = 0; i < len; i++) newArray[i] = array[i];
            array = newArray;
        }
    }

    public boolean remove(Object element) {
        for (int i = 0; i < capacity; i++) {
            if (array[i].equals(element)) {
                array[i] = null;
                return true;
            }
        }
        return false;
    }

    public T removeAt(int index) {
        if (index >= len || index < 0) throw new ArrayIndexOutOfBoundsException();
        T data = array[index];
        T[] newArray = (T[]) new Object[len - 1];
        for (int i = 0, j = 0; i < len; i++, j++) {
            if (array[i] == array[index]) j--;
            else newArray[j] = array[i];
        }
        array = newArray;
        capacity = --len;
        return data;
    }

    public int indexOf(Object element) {
        for (int i = 0; i < len; i++) if (array[i].equals(element)) return i;
        return -1;
    }

    public boolean containsObject(Object element) {
        for (int i = 0; i < len; i++) if (array[i].equals(element)) return true;
        return false;
    }


    public T [] getArray() { return array; }
    public void setArray(T [] array) { this.array = array; }
    public int getLen() { return len; }
    public void setLen(int len) { this.len = len; }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
