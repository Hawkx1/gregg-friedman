package Utilities;

import java.util.Arrays;

/*
This is my implementation of a simple arraylist collection. It implements a simplified list interface.
 */
public class MyArrayList<T> implements MyArrayListInterface<T>{

    private Object[] arrayList;
    private int elementsInArray;
    private int size;

    public MyArrayList() {
        initalize();
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

    @Override
    public int size() {
        return size;
    }

    //adding an item to the end of the collection
    @Override
    public void add(T t) {
        if(checkIfArrayFull()) {
            DoubleArray();
        }

        arrayList[elementsInArray] = t;
        elementsInArray++;
    }

    //Add an element anywhere in the array or return an error if out of bounds
    @Override
    public void add(int index, T t) {
        if(checkIfArrayFull()) {
            DoubleArray();
        }

        if(index >= arrayList.length) {
            System.out.println("The index is out of bounds for this list");
            System.exit(-1);
        }

        Object ob = arrayList[index];
        arrayList[index] = t;

        Object ob2;

        for(int i = index; i < arrayList.length - 1; i++) {
            ob2 = arrayList[i+1];
            arrayList[i+1] = ob;
            ob = ob2;
        }

        elementsInArray++;
    }

    //Allows to retrieve a value at any point of the array or return an error if out of bounds
    @Override
    public Object get(int index) {
        Object o = null;

        try {
            o = arrayList[index];
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("The index that you entered is not within the bounds of this list");
            System.exit(-1);
        }
        return o;
    }

    @Override
    public void clear() {
        initalize();
    }

    private void initalize() {
        arrayList = new Object[5];
        size = 5;
        elementsInArray = 0;
    }

    //Returns the first index of first occurrence of the object provided
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

    //Checks to see if the ArrayList is full
    private boolean checkIfArrayFull() {
        return this.arrayList.length == this.elementsInArray;
    }

    //Use the Array class to double the size of the current array
    private void DoubleArray() {
        size *= 2;
        arrayList = Arrays.copyOf(arrayList, size);
    }
}