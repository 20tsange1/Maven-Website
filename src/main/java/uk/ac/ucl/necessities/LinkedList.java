package uk.ac.ucl.necessities;

import uk.ac.ucl.interfaces.*;

public class LinkedList<T> implements LinkedListInterface<T> {

    private String name;
    private int keyCount = 0;
    private Node<T> head = null;

    public LinkedList(String name) {
        this.name = name;
    }

    public boolean addNode(int key) {

        Node<T> current = this.head;

        if (this.head == null) {
            this.head = new Node<T>(key);
            this.keyCount++;
            return true;
        } else {
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.changeNext(new Node<T>(key));
            this.keyCount++;
            return true;
        }

    }

    public boolean addNode(int key, T data) {

        Node<T> current = this.head;

        if (this.head == null) {
            this.head = new Node<T>(key, data);
            this.keyCount++;
            return true;
        } else {
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.changeNext(new Node<T>(key, data));
            this.keyCount++;
            return true;
        }
    }

    public boolean addNode(int key, T data, int keyList) {

        Node<T> current = this.head;

        if (this.head == null) {
            this.head = new Node<T>(key, data, keyList);
            this.keyCount++;
            return true;
        } else {
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.changeNext(new Node<T>(key, data, keyList));
            this.keyCount++;
            return true;
        }

    }

    public void printList() {

        if (this.head == null) {
            System.out.print("No List Exists");
        }
        else {
            System.out.print(this.name + " || Head");
        }

        Node<T> current = head;

        while (current != null) {
            System.out.print("->");
            System.out.print(current.getData());
            current = current.getNext();
        }

        System.out.println();
    }

    public boolean deleteNode(int key) {

        Node<T> current = this.head;

        if (current.getKey() == key) {
            this.head = current.getNext();
            return true;
        }

        Node<T> previous = current;
        current = current.getNext();
        
        while (current != null) {
            if (current.getKey() == key) {
                previous.changeNext(current.getNext());
                return true;
            }
            previous = current;
            current = current.getNext();   
        }

        return false;
    }

    public boolean deleteNode(T data) {

        Node<T> current = this.head;

        if (current.getData() == data) {
            this.head = current.getNext();
            return true;
        }

        Node<T> previous = current;
        current = current.getNext();
        
        while (current != null) {
            if (current.getData() == data) {
                previous.changeNext(current.getNext());
                return true;
            }
            previous = current;
            current = current.getNext();   
        }

        return false;
    }

    public Node<T> findNode(int key) {
        Node<T> current = this.head;
        while (current != null) {
            if (current.getKey() == key) {
                return current;
            }
            current = current.getNext();
        }
        return current;
    }

    public boolean changeNode(int key, T change) {
        Node<T> current = this.head;
        while (current != null) {
            if (current.getKey() == key) {
                current.changeData(change);
                return true;
            }
            current = current.getNext();
        }
        return false;
    }


    public boolean changeUrl(int key, String change) {
        Node<T> current = this.head;
        while (current != null) {
            if (current.getKey() == key) {
                current.changeUrl(change);
                return true;
            }
            current = current.getNext();
        }
        return false;
    }


    public boolean changePicture(int key, String change) {
        Node<T> current = this.head;
        while (current != null) {
            if (current.getKey() == key) {
                current.changePicture(change);
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    public boolean changeKeyList(int key, int change) {
        Node<T> current = this.head;
        while (current != null) {
            if (current.getKey() == key) {
                current.changeKeyList(change);
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    public void changeKeyCount(int keyCount) {
        this.keyCount = keyCount;
    }

    public void initialise() {
        this.head = null;
    }

    public Node<T> getHead() {
        return this.head;
    }

    public String getName() {
        return this.name;
    }

    public int getKeyCount() {
        return this.keyCount;
    }

    public void changeName(String name) {
        this.name = name;
    }
}