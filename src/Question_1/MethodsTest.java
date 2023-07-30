/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Question_1;

/**
 *
 * @author wskin
 */
public class MethodsTest {
    
    public static void main(String[] args){
        LinkedList<Integer> test = new LinkedList<Integer>();
        
        for(int i = 0; i < 10; i++){
            test.add(i);
        }
        
        test.addHead(15);
        
        test.printLinkedList();
        
        System.out.println("The head of the list is: " + test.getHead());
        System.out.println("The tail of the list is: " + test.getTail());
        
        System.out.println(test.contains(new Node(9)));
//        test.add(56);
//        test.addHead(18);
//        test.printLinkedList();
        test.remove(2);
        test.printLinkedList();
        System.out.println("Size: " + test.size);
        test.removeFromHead();
        test.printLinkedList();
        System.out.println("Size: " + test.size);

        
        
    }
}
