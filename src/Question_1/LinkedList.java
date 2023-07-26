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

    }
    
    public Node getHead()
    {
        return null;
    }
    
    public void add(E data)
    {
       Node<E> newNode = new Node<>();
       newNode.data = data;
       if(head == null){
           head = newNode;
           size++;
       }else{
           Node currentNode = head;
          while(currentNode.next != null){
              currentNode = currentNode.next;
          }
          currentNode.next = newNode;
          size++;
       }
       
    }
    
    private void add(Node head, Node node)
    {

    }
    
    public void printLinkedList()
    {

    }
    
    private void printLinkedList(Node node)
    {
        
    }
    
    public boolean contains(Node node)
    {
        if(head.data == node.data){
            return true;
        }else{
            Node currentNode = head;
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
        return null;
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

    }
    
    private void addInOrder(Node currentNode, Node newNode)
    {

    }
    
    public Node getNode(int index)
    {
        return null;
    }
    
    private Node getNode(int index, Node head)
    {
        return null;
    }
    
    public E getData(int index)
    {
        Node 
        return null;
    }
    
    private E getData(int index, Node head)
    {
        return null;
    }    
}
