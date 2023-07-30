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
public class Queue <E extends Comparable>{
    
    private LinkedList<E> queue = new LinkedList<>();
    
    public void enqueue(E data)
    {
        queue.add(data);    
    }
    
    public E dequeue()
    {
        Node<E> node = queue.removeFromHead();
//        if(node == null){
//            return queue.head.data;
//        }
         
        return node.data;
    }
    
    public void printQueue()
    {
        queue.printLinkedList();
    }
    
    public int getSize()
    {
        return queue.size;
    }
}
