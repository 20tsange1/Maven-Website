package uk.ac.ucl.interfaces;

public interface NodeInterface<T> {

    public int getKey();

    public T getData();

    public NodeInterface<T> getNext();

    public void changeKey(int element);

    public void changeData(T data);

}