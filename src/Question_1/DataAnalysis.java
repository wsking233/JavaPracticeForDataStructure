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
 */
public class DataAnalysis <E extends Comparable>{
    private Queue <E> queue = new Queue();
    private Stack <E> stack = new Stack();
    private E[] data;
    
    public DataAnalysis(E[] data)
    {
        this.data = data;
    }    
    
    public boolean isPalindrome()
    {
        Queue<E> rData = reverse(data);
        System.out.println("Reverse list:");
        rData.printQueue();
        
//        for (E data1 : data) {
//            if (!data1.equals(rData.dequeue())) {
//                System.out.println(Arrays.toString(data) + " is not palindrome");
//                return false;
//            }
//        }
//       
        return false;
    }
    
    public Queue<E> reverse(E[] data){
        
        Node<E> node = new Node("test node");
        
        Stack<E> inOrder = new Stack();
        
        for (E e : data) {
            inOrder.push(e);
        }
        System.out.println("In order:");
        inOrder.printStack();
        System.out.println("InOrder size: " + inOrder.getSize());
        
        Queue<E> outOrder = new Queue();
//        outOrder.enqueue(node.data);
    
         
        
        while(inOrder.getSize() > 0){
            E tempdata = inOrder.pop();
            System.out.print(tempdata + " ");
            outOrder.enqueue(tempdata);
//            System.out.println(inOrder.getSize());
        }
        System.out.println();
        System.out.println("Out Order:");
        outOrder.printQueue();
      
        return outOrder;
    } 
}
