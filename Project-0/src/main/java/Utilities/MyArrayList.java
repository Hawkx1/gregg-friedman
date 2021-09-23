package Utilities;

import javax.jws.Oneway;
import java.util.ArrayList;

public class MyArrayList implements MyArrayListInterface{

    private Object[] arrayList;
    private int elementsInArray;

    public MyArrayList() {
        this(10);
    }

    public MyArrayList(int i) {
        if(i <= 0) {
            System.out.println("Negative number given please try again");
            return;
        }

        this.arrayList = new Object[i];
        this.elementsInArray = 0;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public void add(Object x) {
        if(checkIfArrayFull()) {

        }
    }

    @Override
    public void add(int index, Object x) {

    }

    @Override
    public Object get(int index) {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean isIn(Object x) {
        return false;
    }

    @Override
    public int find(Object x) {
        return 0;
    }

    @Override
    public void remove(Object x) {

    }

    private boolean checkIfArrayFull() {
        return this.arrayList.length == this.elementsInArray;
    }

    private void copyArray(int size, String str) {
        if(str.equals("double")) {
            size = this.arrayList.length * 2;
        } else {
            size = this.arrayList.length + size;
        }
        Object[] tempArray = new Object[size];

        int tempElement = 0;
    }


}
