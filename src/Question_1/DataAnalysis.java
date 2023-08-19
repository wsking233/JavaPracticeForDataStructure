/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Question_1;

import java.util.Arrays;

/**
 *
 * @author xhu
 * @param <E>
 */
public class DataAnalysis <E extends Comparable<E>>{
    // private Queue<E> queue = new Queue();
    // private Stack<E> stack = new Stack();
    private E[] data;
    
    public DataAnalysis(E[] data)
    {
        this.data = data;
    }    
    
    public boolean isPalindrome()
    {
        Queue<E> rData = reverse(data);
        
        for (E data1 : data) {
            if (!data1.equals(rData.dequeue())) {
                return false;
            }
        }
        return true;
    }
    
    public Queue<E> reverse(E[] data){
                
        Stack<E> inOrder = new Stack();
        for (E e : data) {
            inOrder.push(e);
        }
        System.out.println("In order list: ");
        inOrder.printStack();

        Queue<E> outOrder = new Queue();    
        while(inOrder.getSize() > 0){
            E tempdata = inOrder.pop();
            outOrder.enqueue(tempdata);
        }
        System.out.println("Out order list: ");
        outOrder.printQueue();
        
        return outOrder;
    } 
}
