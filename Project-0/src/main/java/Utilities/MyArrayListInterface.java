package Utilities;

public interface MyArrayListInterface<T> {

    int size();

    void add(T t);

    void add(int index, T t);

    Object get(int index);

    void clear();

    int find(T t);

    void remove(T t);
}
