package Utilities;
/*
This is my implementation of a simple arraylist collection. It implements a simplified list interface.
 */
public class MyArrayList<T> implements MyArrayListInterface<T>{

    private Object[] arrayList;
    private int elementsInArray = 5;

    public MyArrayList() {
        arrayList = new Object[elementsInArray];
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
        this.elementsInArray = 1;
    }

    @Override
    public int size() {
        return elementsInArray;
    }

    @Override
    public void add(Object o) {
        if(checkIfArrayFull()) {
            copyArray("double");
        }

        arrayList[elementsInArray] = o;
        elementsInArray++;
    }

    //Add an element anywhere in the array or return an error if out of bounds
    @Override
    public void add(int index, Object o) {
        if(checkIfArrayFull()) {
            copyArray("double");
        }

        if(index >= arrayList.length) {
            System.out.println("The index is out of bounds for this list");
            System.exit(-1);
        }

        Object ob = arrayList[index];
        arrayList[index] = o;

        Object ob2;

        for(int i = index; i < arrayList.length - 1; i++) {
            ob2 = arrayList[i+1];
            arrayList[i+1] = ob;
            ob = ob2;
        }

        copyArray("");
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
        arrayList = null;
    }

    //Returns the first index of first occurrence of the object provided
    @Override
    public int find(Object o) {
        for(int i = 0; i < arrayList.length; i++) {
            if(o.equals(arrayList[i])) {
                return i;
            }
        }
        return -1;
    }

    //Removes the first occurrence od the object provided
    @Override
    public void remove(Object o) {
        for (int i = 0; i < elementsInArray; i++) {
            if(o.equals(arrayList[i])) {
                arrayList[i] = null;
                elementsInArray--;
                copyArray("");
                return;
            }
        }
    }

    //Checks to see if the ArrayList is full
    private boolean checkIfArrayFull() {
        return this.arrayList.length == this.elementsInArray;
    }

    //Copies the current ArrayList to an array double the size of the current one
    private void copyArray(String str) {
        int size = 0;
        if(str.equals("double")) {
            size = this.arrayList.length * 2;
        } else {
            size = this.arrayList.length + size;
        }
        Object[] tempArray = new Object[size];

        int temp = 0;

        for(int i = 0; i < arrayList.length; i++, temp++) {
            if(arrayList[i] == null) {
                temp--;
                continue;
            }

            tempArray[temp] = arrayList[i];
        }

        arrayList = null;
        arrayList = new Object[tempArray.length];
        arrayList = tempArray;
    }
}