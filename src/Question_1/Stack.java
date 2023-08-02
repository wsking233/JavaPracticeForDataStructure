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
public class Stack <E extends Comparable<E>>{
    LinkedList<E> stack = new LinkedList<>();
    
    public void push(E data)
    {
        stack.addHead(data);
    }
    
    public E pop()
    {

        Node<E> removeData = stack.removeFromHead();
        return removeData.data;
       
    }
    
    public void printStack()
    {
        stack.printLinkedList();
    }
    
    public int getSize()
    {
        return stack.size;
    }
}
