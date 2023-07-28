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
public class Stack <E extends Comparable>{
    LinkedList<E> stack = new LinkedList();
    
    public void push(E data)
    {
        stack.addHead(data);
    }
    
    public E pop()
    {
        if(stack.size <= 1){
            return stack.head.data;
        }
        
        Node<E> node = stack.head;
        stack.head = stack.head.next;
       
        return node.data;
    }
    
    public void printStack()
    {
        stack.printLinkedList();
    }
    
    public int getSize()
    {
        return 0;
    }
}
