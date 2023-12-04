package uk.ac.ucl.necessities;

import uk.ac.ucl.interfaces.*;

public class Node<T> implements NodeInterface<T> {
    private int key;
    private String url = "null";
    private String picture = "null";
    private T data;
    private int keyList = -1;
    private Node<T> next = null;

    public Node(int element) {
        this.key = element;
    }

    public Node(int element, T data) {
        this.key = element;
        this.data = data;
    }

    public Node(int element, T data, int keyList) {
        this.key = element;
        this.data = data;
        this.keyList = keyList;
    }

    public int getKey() {
        return this.key;
    }

    public T getData() {
        return this.data;
    }

    public Node<T> getNext() {
        return this.next;
    }

    public String getUrl() {
        return this.url;
    }

    public String getPicture() {
        return this.picture;
    }

    public int getKeyList() {
        return this.keyList;
    }

    public void changeKey(int element) {
        this.key = element;
    }

    public void changeData(T data) {
        this.data = data;
    }

    public void changeUrl(String url) {
        this.url = url;
    }

    public void changePicture(String picture) {
        this.picture = picture;
    }

    public void changeKeyList(int keyList) {
        this.keyList = keyList;
    }

    public void changeNext(Node<T> next) {
        this.next = next;
    }

}