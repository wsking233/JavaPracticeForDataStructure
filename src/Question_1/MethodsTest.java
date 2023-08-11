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
        System.out.println("Size: " + test.size);

        test.remove(10);
        test.printLinkedList();
        System.out.println("Size: " + test.size);
        test.removeFromTail();
         test.printLinkedList();
        System.out.println("Size: " + test.size);

//        test.removeFromHead();
//        test.printLinkedList();
//        System.out.println("Size: " + test.size);
//        System.out.println(test.getNode(5).toString());
//        int i = 10;
//        while(i > 10){
//            test.add(i);
//        }
//        System.out.println("toString test:");
//        System.out.println(test.toString());
//        
    }
}
