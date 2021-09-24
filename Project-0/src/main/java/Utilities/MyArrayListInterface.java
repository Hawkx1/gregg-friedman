package Utilities;

public interface MyArrayListInterface {

    int size();

    void add(Object x);

    void add(int index, Object x);

    Object get(int index);

    boolean isEmpty();

    boolean existsIn(Object x);

    int find(Object x);

    void remove(Object x);
}
