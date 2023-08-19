/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Question_1;

/**
 *
 * @author xhu
 * @param <E>
 */
public class LinkedList<E extends Comparable<E>>{

    public int size;
    public Node<E> head;

    public LinkedList() {
        this.size = 0;
    }

        public void add(E data) {
        if (head == null) {
            this.addHead(data);
        } else {
//            Node<E> temp = this.getTail();
//            temp.next = new Node(data);
            this.getTail().next = new Node<>(data);
            size++;
        }

    }
        
    public void addHead(E data) {
        Node<E> newNode = new Node<>(data);
//        System.out.println("add: "+newNode.toString());
        if (head == null) {
            head = newNode;
        } else {
            Node<E> currentNode = head;
            head = newNode;
            head.next = currentNode;
        }
        size++;
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return this.getTail(head);
    }

    //recusion to get last node
    private Node getTail(Node<E> node) {
        if (node.next == null) {
            return node;
        } else {
            return this.getTail(node.next);
        }
    }



    private void add(Node head, Node node) {

    }

    public void printLinkedList() {
        if (size <= 0) {
            System.out.println("list is empty now!");
            return;
        }

        System.out.println("The linked list:");
        this.printLinkedList(head);
        System.out.println();

    }

    private void printLinkedList(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.toString());
        this.printLinkedList(node.next);
    }

    public boolean contains(Node node) {
        if (head.data == node.data) {
            return true;
        }
        return this.contains(this.head, node);
    }

    private boolean contains(Node head, Node node) {
        if (head.data.equals(node.data)) {
            return true;
        }
        if (head.next != null) {
            return this.contains(head.next, node);
        }
        return false;
    }

    public void remove(Node node) {
        //if delete first node
        if (head.data == node.data) {
            this.removeFromHead();
            return;
        }

        this.removeFromBody(head, node);
    }

    private void removeFromBody(Node head, Node node) {
        if (head.next != null) {
            if (head.next.data.equals(node.data)) {
                head.next = head.next.next;
                size--;
            } else {
                this.removeFromBody(head.next, node);
            }
        }
    }

    public void remove(int position) {
        if (position > size) {
            System.out.println(position + " is out of range");
            return;
        }
        if (position == 0) {
            size--;
            head = head.next;
            return;
        }
        this.removeByIndex(head, position - 1);

    }

    private void removeByIndex(Node head, int position) {
        if (position > 0) {
            this.removeByIndex(head.next, --position);
        } else {
            head.next = head.next.next;
            size--;
        }
    }

    public Node removeFromHead() {
        if (head == null) {
            size = 0;
            return null;
        }

        Node<E> temp = head;
        this.remove(0);
        return temp;

    }

    public Node removeFromTail() {
        Node<E> temp = this.getTail();
        this.remove(size - 1);
        return temp;
    }

    private Node removeFromTail(Node node) {
        return null;
    }

    public void addInOrder(E data) {
        Node<E> newNode = new Node<>(data);

        if (head == null || data.compareTo(head.data) <= 0) {
            newNode.next = head;
            head = newNode;
        } else {
            this.addInOrder(head, newNode);
        }
        size++;
    }

    private void addInOrder(Node currentNode, Node newNode) {
        
        
        if(currentNode.next != null && newNode.compareTo(currentNode.next) >0){
            this.addInOrder(currentNode.next, newNode);
        }else{
             newNode.next = currentNode.next;
            currentNode.next = newNode;
        }
    }

    public Node getNode(int index) {
        if (index >= size || index < 0) {
            System.out.println(index + " out of range");
            return null;
        }
        if (index == 0) {
            return head;
        } else {
            return this.getNode(index, head);
        }
    }

    private Node getNode(int index, Node head) {
        if (index > 0) {
            index--;
            return this.getNode(index, head.next);
        }
        return head;
    }

    public E getData(int index) {
        if (index > size || index < 0) {
            System.out.println("Out of range");
            return null;
        }

        Node<E> temp = this.getNode(index);
        return temp.data;

    }

    private E getData(int index, Node head) {
        return null;
    }
    
}
