package uk.ac.ucl.model;

import java.io.File;
import java.util.List;
import java.util.ArrayList;

import uk.ac.ucl.necessities.LinkedList;
import uk.ac.ucl.necessities.Node;
import uk.ac.ucl.necessities.FileInput;
import uk.ac.ucl.necessities.FileOutput;
import uk.ac.ucl.necessities.Input;

public class Model {

  // List of List
  public LinkedList<LinkedList<String>> lists = new LinkedList<LinkedList<String>>("List of Lists");

  // Importing Lists from File
  public void importLists() {
    FileInput readFile = new FileInput("./data//Data.txt");

    String[] item;
    int count2 = 0;

    this.lists.changeKeyCount(Integer.parseInt(readFile.nextLine()));

    while (readFile.hasNextLine()) {

      // Formatting File based on
      // - is new list
      // . is indicating list content
      // ! is to split the attributes to set the node
      if (readFile.nextLine().equals("-")) {
        item = readFile.nextLine().split("!", 3);
        this.lists.addNode(Integer.parseInt(item[1]), new LinkedList<String>(item[0]));
        this.lists.findNode(Integer.parseInt(item[1])).getData().changeKeyCount(Integer.parseInt(item[2]));
        count2 = 0;

        while (readFile.nextLine().equals(".")) {
          String[] next = readFile.nextLine().split("!", 4);
          this.lists.findNode(Integer.parseInt(item[1])).getData().addNode(count2, next[0]);
          this.lists.findNode(Integer.parseInt(item[1])).getData().changeUrl(count2, next[1]);
          this.lists.findNode(Integer.parseInt(item[1])).getData().changePicture(count2, next[2]);
          this.lists.findNode(Integer.parseInt(item[1])).getData().changeKeyList(count2, Integer.parseInt(next[3]));
          count2++;
        }
      }
    }

    readFile.close();
  }


  // Exporting Lists to File
  public void exportLists() {
    // Setting up output file
    FileOutput writeFile = new FileOutput("./data/Data.txt");

    String outputStr = "";
    Node<LinkedList<String>> currentNode = this.lists.getHead();
    Node<String> currentNode2;

    outputStr += this.lists.getKeyCount() + "\n";

    // Building an import file using the previous format
    while (currentNode != null) {
      outputStr += "-\n" + currentNode.getData().getName() + "!" + currentNode.getKey() + "!" + currentNode.getData().getKeyCount();
      currentNode2 = currentNode.getData().getHead();
      while (currentNode2 != null) {
        outputStr += "\n.\n" + currentNode2.getData() + "!" + currentNode2.getUrl() + "!" + currentNode2.getPicture() + "!" + currentNode2.getKeyList();
        currentNode2 = currentNode2.getNext();
      }
      outputStr += "\n%\n";
      currentNode = currentNode.getNext();
    }

    writeFile.writeString(outputStr);
    writeFile.close();
  }


  // Changing Name of Lists
  public void changeName(int key, String name) {
    this.lists.findNode(key).getData().changeName(name);
  }


  // Getting List Names
  public List<String> getNames() {

    List<String> retList = new ArrayList<String>();

    Node<LinkedList<String>> currentNode = lists.getHead();
    while (currentNode != null) {
      retList.add(currentNode.getData().getName());
      currentNode = currentNode.getNext();
    }

    return retList;
  }


  // Getting List Keys
  public List<Integer> getKeys() {

    List<Integer> retList = new ArrayList<Integer>();

    Node<LinkedList<String>> currentNode = lists.getHead();
    while (currentNode != null) {
      retList.add(currentNode.getKey());
      currentNode = currentNode.getNext();
    }

    return retList;
  }


  // Getting the Data from the Lists
  public List<String> getListData(int key) {

    List<String> retList = new ArrayList<String>();

    Node<String> currentNode = lists.findNode(key).getData().getHead();
    while (currentNode != null) {
      retList.add(currentNode.getData());
      currentNode = currentNode.getNext();
    }

    return retList;
  }


  // Getting the Data's Keys
  public List<Integer> getListKey(int key) {

    List<Integer> retList = new ArrayList<Integer>();

    Node<String> currentNode = lists.findNode(key).getData().getHead();
    while (currentNode != null) {
      retList.add(currentNode.getKey());
      currentNode = currentNode.getNext();
    }

    return retList;
  }


  // Getting the Data's List Keys if they are a List
  public List<Integer> getListKeyList(int key) {

    List<Integer> retList = new ArrayList<Integer>();

    Node<String> currentNode = lists.findNode(key).getData().getHead();
    while (currentNode != null) {
      retList.add(currentNode.getKeyList());
      currentNode = currentNode.getNext();
    }

    return retList;
  }

  
  // Returns node with keyword in it.
  public List<Node<String>> searchForNode(String keyword) {
    List<Node<String>> retList = new ArrayList<Node<String>>();

    Node<LinkedList<String>> currentNode = this.lists.getHead();

    while (currentNode != null) {

      Node<String> currentListNode = currentNode.getData().getHead();

      while (currentListNode != null) {
        // Checks all string regardless of case.
        if (currentListNode.getData().toLowerCase().contains(keyword)) {
          retList.add(currentListNode);
        }
        currentListNode = currentListNode.getNext();
      }
      currentNode = currentNode.getNext();
    }

    return retList;
  }


  // Returns Key of List who's name has the keyword.
  public List<Integer> searchForKey(String keyword) {
    List<Integer> retList = new ArrayList<Integer>();

    Node<LinkedList<String>> currentNode = this.lists.getHead();

    while (currentNode != null) {

      if (currentNode.getData().getName().toLowerCase().contains(keyword)) {
        retList.add(currentNode.getKey());
      }

      currentNode = currentNode.getNext();

    }

    return retList;
  }

  // Returns the Name of the List who's name has the keyword.
  public List<String> searchForName(String keyword) {
    List<String> retList = new ArrayList<String>();

    Node<LinkedList<String>> currentNode = this.lists.getHead();

    while (currentNode != null) {

      if (currentNode.getData().getName().toLowerCase().contains(keyword)) {
        retList.add(currentNode.getData().getName());
      }

      currentNode = currentNode.getNext();

    }

    return retList;
  }

  // Returns the name of the item that has they keyword in it.
  public List<String> searchForItemData(String keyword) {
    List<String> retList = new ArrayList<String>();

    Node<LinkedList<String>> currentNode = this.lists.getHead();

    while (currentNode != null) {

      Node<String> currentListNode = currentNode.getData().getHead();

      while (currentListNode != null) {
        if (currentListNode.getData().toLowerCase().contains(keyword)) {
          retList.add(currentListNode.getData());
        }
        currentListNode = currentListNode.getNext();
      }

      currentNode = currentNode.getNext();

    }

    return retList;
  }

  // Returns the key of the item with the keyword.
  public List<Integer> searchForItemKey(String keyword) {
    List<Integer> retList = new ArrayList<Integer>();

    Node<LinkedList<String>> currentNode = this.lists.getHead();

    while (currentNode != null) {

      Node<String> currentListNode = currentNode.getData().getHead();

      while (currentListNode != null) {
        if (currentListNode.getData().toLowerCase().contains(keyword)) {
          retList.add(currentListNode.getKey());
        }
        currentListNode = currentListNode.getNext();
      }

      currentNode = currentNode.getNext();

    }

    return retList;
  }

  // Returns the Key of the List with the item.
  public List<Integer> searchForListKey(String keyword) {
    List<Integer> retList = new ArrayList<Integer>();

    Node<LinkedList<String>> currentNode = this.lists.getHead();

    while (currentNode != null) {

      Node<String> currentListNode = currentNode.getData().getHead();

      while (currentListNode != null) {
        if (currentListNode.getData().toLowerCase().contains(keyword)) {
          retList.add(currentNode.getKey());
        }
        currentListNode = currentListNode.getNext();
      }

      currentNode = currentNode.getNext();

    }

    return retList;
  }

}
