public class LinkedList {

  Node head;

  static class Node {
    int data;
    Node next;

    Node(int d) {
      data = d;
      next = null;
    }
  }

  public static LinkedList addNodeEnd(LinkedList list, int data) {
    Node newNode = new Node(data);
    newNode.next = null;

    if (list.head == null) {
      list.head = newNode;
    } else {
      Node last = list.head;
      while (last.next != null)
        last = last.next;
      last.next = newNode;
    }
    return list;
  }

  public static Node addNodeStart(LinkedList list, int data) {
    Node newNode = new Node(data);
    newNode.next = list.head;
    return newNode;
  }

  public static int LinkedListSize(LinkedList list) {
    int listSize = 0;
    Node countNode = list.head;

    if (list.head != null)
      ++listSize;
    while (countNode.next != null) {
      ++listSize;
      countNode = countNode.next;
    }
    return listSize;
  }

  public static LinkedList addNodeNPos(LinkedList list, int data, int pos) {
    Node newNode = new Node(data);
    int i = 1;

    if (pos > LinkedListSize(list)) {
      System.out.print("Number is greater than list size.\n");
    } else if (pos == 1) {
      newNode.next = list.head;
      list.head = newNode;
    } else {
      Node target = list.head;
      while (i < pos - 1) {
        target = target.next;
        ++i;
      }
      newNode.next = target.next;
      target.next = newNode;
    }
    return list;
  }

  public static LinkedList deleteNodeNPos(LinkedList list, int pos) {
    Node target = list.head;
    int i = 1;

    if (pos > LinkedListSize(list)) {
      System.out.print("Number is greater than list size.\n");
    } else if (pos == 1) {
      list.head = target.next;
    } else {
      while (i < pos - 1) {
        target = target.next;
        ++i;
      }
      target.next = target.next.next;
    }
    return list;
  }

  public static LinkedList deleteNodeElem(LinkedList list, int elem) {
    Node target = list.head;

    while (target.next != null) {
      if (target.next.data == elem)
        target.next = target.next.next;
      else
        target = target.next;
    }
    return list;
  }

  public static Node getPositionElem(LinkedList list, int pos) {
    Node target = list.head;
    int i = 1;

    if (pos > LinkedListSize(list)) {
      System.out.print("Number is greater than list size.\n");
    } else {
      while (i != pos) {
        target = target.next;
        ++i;
      }
    }
    return target;
  }

  public static int getElemFirstPosition(LinkedList list, int elem) {
    Node target = list.head;

    int i = 1;

    while (target.next != null) {
      if (target.data == elem)
        return i;
      target = target.next;
      ++i;
    }
    if (target.data == elem)
      return i;
    return -1;
  }

  public static int getElemLastPosition(LinkedList list, int elem) {
    Node target = list.head;

    int i = 1;
    int lastPos = -1;

    while (target.next != null) {
      if (target.data == elem)
        lastPos = i;
      target = target.next;
      ++i;
    }
    if (target.data == elem)
      lastPos = i;
    return lastPos;
  }

  public static void printList(LinkedList list)
      {
          Node currNode = list.head;

          System.out.print("LinkedList: ");

          // Traverse through the LinkedList
          while (currNode != null) {
              // Print the data at current node
              System.out.print(currNode.data + " ");

              // Go to next node
              currNode = currNode.next;
          }
          System.out.print("\n");
      }

  public static void main(String[] args) {
      LinkedList list = new LinkedList();
      Node newNode;

      list = addNodeEnd(list, 2);
      list = addNodeEnd(list, 1);
      list.head = addNodeStart(list, 3);
      list = addNodeNPos(list, 5, 1);
      printList(list);
      newNode = getPositionElem(list, 4);
      list = deleteNodeNPos(list, 1);
      list = addNodeEnd(list, 1);
      printList(list);
      list = deleteNodeElem(list, 1);
      list = addNodeEnd(list, 1);
      list = addNodeEnd(list, 1);
      list = addNodeEnd(list, 8);
      list = addNodeEnd(list, 7);
      list = addNodeEnd(list, 2);
      list = addNodeEnd(list, 4);
      list = addNodeEnd(list, 3);
      list = addNodeEnd(list, 1);
      printList(list);
      System.out.print("1er " + getElemFirstPosition(list, 3) + "\n");
      System.out.print("dernier " + getElemLastPosition(list, 3) + "\n");
      printList(list);
  }
}
