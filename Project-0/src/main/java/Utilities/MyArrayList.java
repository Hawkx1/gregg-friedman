package Utilities;

import Items.AccountItem;

import java.util.Arrays;
import java.util.Iterator;

/*
This is my implementation of a simple arraylist collection. It implements a simplified list interface.
 */
public class MyArrayList<T> implements MyArrayListInterface<T>, Iterable<T>{

    private Object[] arrayList;
    private int elementsInArray;
    private int size;

    public MyArrayList() {
        initialize();
    }

    /*
    This is the constructor that sets an initial size based on int parameter.
     */
    public MyArrayList(int i) {
        if(i <= 0) {
            System.out.println("Negative number given please try again");
            return;
        }

        this.arrayList = new Object[i];
        this.elementsInArray = 0;
        this.size = i;
    }

    //returns the size of the array
    @Override
    public int size() {
        return size;
    }

    public int getElementsInArray() {
        return elementsInArray;
    }

    public void setElementsInArray(int elementsInArray) {
        this.elementsInArray = elementsInArray;
    }

    //adding an item to the end of the collection
    @Override
    public void add(T t) {
        checkIfArrayFull();

        arrayList[elementsInArray] = t;
        elementsInArray++;
    }

    //Add an element anywhere in the array or return an error if out of bounds
    @Override
    public void add(int index, T t) {
        checkIfArrayFull();

        if(index >= arrayList.length) {
            System.out.println("The index is out of bounds for this list");
            System.exit(-1);
        }

        Object ob = arrayList[index];
        arrayList[index] = t;

        Object ob2;

        /*The loop cycles through the array starting at index. ob2 is given the value of arrayList at i+1 position.
         The arrayList at i+1 position is assigned the value of ob. Then the ob variable is assigned the value of ob2. */
        for(int i = index; i < arrayList.length - 1; i++) {
            ob2 = arrayList[i+1];
            arrayList[i+1] = ob;
            ob = ob2;
        }

        elementsInArray++;
    }

    //Allows to retrieve a value at any point of the array or return an error if out of bounds
    @Override
    public AccountItem get(int index) {
        Object o = null;

        try {
            o = arrayList[index];
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("The index that you entered is not within the bounds of this list");
            System.exit(-1);
        }
        return (AccountItem) o;
    }

    //crates a new arrayList and points the program to that list leaving the old one to be garbage collected
    @Override
    public void clear() {
        initialize();
    }

    private void initialize() {
        arrayList = new Object[5];
        size = 5;
        elementsInArray = 0;
    }

    //Returns the index of first occurrence of the object provided or -1 if not found
    @Override
    public int find(T t) {
        for(int i = 0; i < arrayList.length; i++) {
            if(t.equals(arrayList[i])) {
                return i;
            }
        }
        return -1;
    }

    //Removes element at the specified index, and then shift the remaining elements to close the gap
    @Override
    public void remove(T t) {
        for (int i = 0; i < elementsInArray; i++) {
            if(t.equals(arrayList[i])) {
                arrayList[i] = null;
                elementsInArray--;
                return;
            }
        }
    }

    //Checks to see if the ArrayList is full and if it is doubles it
    private void checkIfArrayFull() {

        if(this.arrayList.length == this.elementsInArray) {
            size *= 2;
            arrayList = Arrays.copyOf(arrayList, size);
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < size && arrayList[currentIndex] != null;
            }

            @Override
            public T next() {
                return (T) arrayList[currentIndex++];
            }
        };
    }
}