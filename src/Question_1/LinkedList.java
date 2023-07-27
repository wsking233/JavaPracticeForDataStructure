/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Question_1;

/**
 *
 * @author xhu
 */
public class LinkedList <E extends Comparable>{
    
    public int size = 0;
    public Node<E> head;
    
    public void addHead(E data)
    {
        Node<E> newHead = new Node<E>();
        newHead.data = data;
        newHead.next = head;
    }
    
    public Node getHead()
    {
        return head;
    }
    
    public Node getTail(){
        Node<E> currentNode = head;
       while (currentNode.next != null) {
            currentNode = currentNode.next;
        }
        return currentNode;
    }
    
    public void add(E data)
    {
       Node<E> newNode = new Node<>();
       newNode.data = data;
       if(head == null){
           head = newNode;
       }else{
           Node<E> currentNode = head;
          while(currentNode.next != null){
              currentNode = currentNode.next;
          }
          currentNode.next = newNode;
       }
       size++;
       
    }
    
    private void add(Node head, Node node)
    {
        
    }
    
    public void printLinkedList()
    {
        if(size <= 0){
            System.out.println("list is empty now!");
            return;
        }
        
        int index = 1;
        Node<E> currentNode = head;
        System.out.println("The linked list:");
        System.out.println(index +". "+head.toString());
        
        while(currentNode.next != null){
            index++;
            currentNode = currentNode.next;
            System.out.println(index + ". " + currentNode.toString());
        }
    }
    
    private void printLinkedList(Node node)
    {
        
    }
    
    public boolean contains(Node node)
    {
        if(head.data == node.data){
            return true;
        }else{
            Node<E> currentNode = head;
            while(currentNode.next != null){
                if(currentNode.data.equals(node.data)){
                    return true;
                }
                currentNode = currentNode.next;
            }
        }
        return false;
    }
    
    private boolean contains(Node head, Node node)
    {
        return false;
    }
    
    public void remove(Node node)
    {
        
        if(head.data == node.data){ //if delete first node
            head = head.next;
            return;
        }

        Node<E> nodeA = head;   //one position before the target node
        Node<E> nodeB = null;   //the target node
           
        //find the target node.
        while(nodeA.next != null){ 
           if(nodeA.next.data.equals(node.data)){
               nodeB = nodeA.next;
               break;
           }
           nodeA = nodeA.next;
        }
        
        //if target node is null, it means target is not found in list.
        if(nodeB == null){
            System.out.println(node.data + " is not exist");
        }else{
        //A -> C, if the target node is found.
            if(nodeB.next == null){
                nodeA.next = null;
            }else{
                nodeA.next = nodeB.next.next;
            }
            size--;
        }
        
        
    }
    
    public void remove(int position)
    {
        
        
    }
    
    private void removeByIndex(Node head, int position)
    {

    }
    
    private void removeFromBody(Node head, Node node)
    {

    }
    
    public Node removeFromHead()
    {
        return  head = head.next;
    }
    
    public Node removeFromTail()
    {
        return null;
    }
    
    private Node removeFromTail(Node node)
    {
        return null;
    }
    
    public void addInOrder(E data)
    {
        Node<E> newNode = new Node<>();
       newNode.data = data;
       if(head == null){
           head = newNode;
       }else{
           Node<E> currentNode = head;
          while(currentNode.next != null){
              currentNode = currentNode.next;
          }
          currentNode.next = newNode;
       }
       size++;

    }
    
    private void addInOrder(Node currentNode, Node newNode)
    {

    }
    
    public Node getNode(int index)
    {
        if(index > size || index < 0){
            System.out.println(index + " out of range");
            return null;
        }
        if(index == 0){
            return head;
        }else{
            Node<E> currentNode = head;
            for(int i = 0; i < size && i < index; i++){
                currentNode = currentNode.next;
            }
            return currentNode;
        }
    }
    
    private Node getNode(int index, Node head)
    {
        return null;
    }
    
    public E getData(int index)
    {
        if(index > size || index < 0){
                System.out.println("Out of range");
                return null;
        }
        
        Node<E> currentNode = head;
   
        for(int i =0; i < index; i++){
            currentNode = currentNode.next;
        }
        
        return currentNode.data;
    }
    
    private E getData(int index, Node head)
    {
        return null;
    }    
}
