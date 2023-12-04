package uk.ac.ucl.interfaces;

public interface LinkedListInterface<T> {

    public boolean addNode(int key);

    public void printList();

    public NodeInterface<T> findNode(int key);

    public boolean deleteNode(int key);

    public boolean deleteNode(T data);

    public NodeInterface<T> getHead();

    public boolean changeNode(int key, T change);

    public void initialise();

}