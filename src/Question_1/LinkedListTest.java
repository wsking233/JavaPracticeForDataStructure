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
public class LinkedListTest {
    static final String ANSI_RED = "\u001B[31m";
    static final String ANSI_RESET = "\u001B[0m";
    public static void main(String[] args) {
        
        int mark = 0;
        String report = new String("Failed test\n");
        
        int mark_add = test_add();

        mark += mark_add;
        if(mark_add == 0)
        {
            report += ANSI_RED+"test_contains()\n"+ANSI_RESET;
        }
        System.out.println("Current mark: " + mark);
        System.out.println("________________________________________________\n");

        
        //check for contains method
        int mark_contains = test_contains();

        mark += mark_contains;
        if(mark_contains == 0)
        {
            report += ANSI_RED+"test_contains()\n"+ANSI_RESET;
        }
        System.out.println("Current mark: " + mark);
        System.out.println("________________________________________________\n");
        
        int mark_getData = test_getData();

        mark += mark_getData;
        if(mark_getData == 0)
        {
            report += ANSI_RED+"test_getData()\n"+ANSI_RESET;
        }
        System.out.println("Current mark: " + mark);
        System.out.println("________________________________________________\n");
        
        //check for remove method
        
        int mark_remove =  test_remove();

        mark += mark_remove;
        if(mark_remove == 0)
        {
            report += ANSI_RED+"test_remove()\n"+ANSI_RESET;
        }
        System.out.println("Current mark: " + mark);
        System.out.println("________________________________________________\n");
        
         //check for remove from head method
        int mark_remove_head = test_remove_head();
        mark += mark_remove_head;
        if(mark_remove_head == 0)
        {
            report += ANSI_RED+"test_remove_head()\n"+ANSI_RESET;
        }
        System.out.println("Current mark: " + mark);
        System.out.println("________________________________________________\n");
        
        //check for remove from tail method
        int mark_remove_tail = test_remove_tail();
        mark += mark_remove_tail;
        if(mark_remove_tail == 0)
        {
            report += ANSI_RED+"test_remove_tail()\n"+ANSI_RESET;
        }
        System.out.println("Current mark: " + mark);
        System.out.println("________________________________________________\n");              
        
        //part 2
        
        
        int mark_dequeue = test_Queue();
        mark += mark_dequeue;
        if(mark_dequeue == 0)
        {
            report += ANSI_RED+"test_Queue()\n"+ANSI_RESET;
        }
        System.out.println("Current mark: " + mark);
        System.out.println("________________________________________________\n");
        
        int mark_pop = test_Stack();
        mark += mark_pop;
        if(mark_pop == 0)
        {
            report += ANSI_RED+"test_Stack()\n"+ANSI_RESET;
        }
        System.out.println("Current mark: " + mark);
        System.out.println("________________________________________________\n");
        
        int mark_palindrome = test_palindrome(mark);
        mark += mark_palindrome;
        if(mark_palindrome == 0)
        {
            report += ANSI_RED+"test_Palindrome()\n"+ANSI_RESET;
        }
        
        System.out.println("Current mark: " + mark);
        System.out.println("________________________________________________\n");
        
        if(report.contains("getData()"))
        {
            System.out.println(ANSI_RED+"Please fix getData() method before testing add_in_order() method.\n"+ANSI_RESET);
        }
        else
        {
            int mark_addInOrder = test_add_in_order();
            mark += mark_addInOrder;
            if(mark_addInOrder == 0)
            {
                report += ANSI_RED+"test_add_in_order()\n"+ANSI_RESET;
            }
        }
        
        
        System.out.println("Current mark: " + mark);
        System.out.println("________________________________________________\n");
        if(mark == 35)
        {
            mark+=5; 
            System.out.println("Node Class should be fine.");
        }
        System.out.println();
        
        
        System.out.println("************************************************\n");
        if(mark < 40)
            System.out.println(ANSI_RED+report+ANSI_RESET);
        System.out.println("\nTotal mark of Question 1: "+ mark+" out of 40\n");
    }
    
    private static int test_add()
    {               
        System.out.println("Testing for \"add\" method (mark: 3)");
        LinkedList<String> list = new LinkedList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        if(list.head == null || list.head.next == null|| list.head.next.next == null)
        {
            System.out.println(ANSI_RED+"Failed, mark: 0"+ANSI_RESET);
            return 0;
        }
        if(list.head.data.equals("a") && 
                list.head.next.data.equals("b") && 
                list.head.next.next.data.equals("c"))
        {
            System.out.println("passed, mark: 3");
            return 3;
        }
        else
        {
            System.out.println(ANSI_RED+"Failed, mark: 0"+ANSI_RESET);
            return 0;
        }
    }
    
    private static int test_contains()
    {
        int mark = 0;
        System.out.println("Testing for \"contains\" method (mark: 2)");
        LinkedList<Character> list = new LinkedList<>();
        list.add('a');
        list.add('b');
        list.add('c');        

        
        Node<Character> node = new Node<>();
        node.data = (char)('b');
        if(list.contains(node))
        {
            mark += 1; 
            System.out.println("Passed, contain("+node.data+") True");
        }
        else
        {
            System.out.println(ANSI_RED+"Failed, mark: "+mark+ANSI_RESET);
        }
        
        
        
        node.data = (char)('A');
        if(list.contains(node))
        {
            System.out.println(ANSI_RED+"Failed, mark: "+mark+ANSI_RESET);
        }
        else
        {
            mark += mark; 
            System.out.println("Passed, contain("+node.data+") False");           
        }
        
        list.printLinkedList();
        if(mark == 2)
        {
            System.out.println("\nPassed, mark 2\n");
        }
        
        return mark;
    }
    
    private static int test_getData()
    {
        System.out.println("Testing for \"getData\" method (mark: 3)");
        int mark = 0;
        LinkedList<Float> list = new LinkedList<>();
        list.add(0.3f);
        list.add(0.5f);
        list.add(1.2f);
        
        Float data = list.getData(mark);
        if(data == null)
        {
            System.out.println(ANSI_RED+"Cannot get data from the list."+ANSI_RESET);
            return 0;
        }
        if(data.compareTo(0.3f) == 0)
            mark += 2;
        else
            System.out.println(ANSI_RED+"Cannot get data from first node."+ANSI_RESET);
        
        if(list.getData(2).compareTo(1.2f) == 0)
            mark += 1;
        else
            System.out.println(ANSI_RED+"Cannot get data from third node."+ANSI_RESET);
        
        if(mark == 3)
        {
            System.out.println("passed, mark: 3");
        }
        else
        {
            System.out.println(ANSI_RED+"Failed, mark: 0"+ANSI_RESET);
        }
        return mark;
    }
    
    private static int test_remove()
    {
        System.out.println("Testing for \"remove\" method (mark: 3)");
        int mark = 0;
        LinkedList<Float> list = new LinkedList<>();
        list.add(0.0f);
        list.add(1.1f);
        list.add(2.2f);
        
        System.out.println("Test remove by node:");
        list.printLinkedList();
        
        Node node = new Node();
        node.data = 1.1f;
        System.out.println("\nRemove node data: " + node.data);
        list.remove(node);
        System.out.println("After remove node data: " + node.data);
        list.printLinkedList();
        
        System.out.println("\nTest remove by index:");
        list.add(3.3f);
        list.add(4.4f);
        list.printLinkedList();
        
        System.out.println("\nRemove node index: 2");
        list.remove(2);
        list.printLinkedList();
        
        if(list.size == 3 
        && list.head.data == 0.0f 
        && list.head.next.data == 2.2f 
        && list.head.next.next.data == 4.4f)
        {
            mark = 3;
            System.out.println("Passed");
        }
        else
        {
            System.out.println(ANSI_RED+"Failed"+ANSI_RESET);
        }
        
        
        return mark;
    }
    
    private static int test_remove_head()
    {
        System.out.println("Testing for \"remove from head\" method (mark: 2)");
        LinkedList<String> list = new LinkedList<>();
        int mark = 0;
        list.add("10");
        list.add("20");
        list.printLinkedList();

//        list.removeFromTail();
        list.removeFromHead();
        System.out.println();
        list.printLinkedList();
        Node<String> node = new Node<>();
        node.data = "10";
        if(list.size == 1 && !list.contains(node))
        {
            mark = 2;
            System.out.println("Passed");
        }
        else
        {
            System.out.println(ANSI_RED+"Failed"+ANSI_RESET);
        }
        
        return mark;
    }
    
    private static int test_remove_tail()
    {
        System.out.println("Testing for \"remove from tail\" method (mark: 2)");
        LinkedList<Integer> list = new LinkedList<>();
        int mark = 0;
        list.add(10);
        list.add(20);
        list.add(30);
        
        list.printLinkedList();
        list.removeFromTail();
        System.out.println();
        list.printLinkedList();
        
        Node<Integer> node = new Node<>();
        node.data = 30;
        if(list.size == 2 && !list.contains(node))
        {
            mark = 2;
            System.out.println("Passed");
        }
        else
        {
            System.out.println(ANSI_RED+"Failed"+ANSI_RESET);
        }        
        
        return mark;
    }
    
    private static int test_Queue()
    {
        System.out.println("Testing for \"Queue\" methods (mark: 5)");
        
        String word = "Hello Data Structures & Algorithms Students.";
        Queue<Character> queue = new Queue();
        
        for(int i = 0; i < word.length(); i++)
        {
            queue.enqueue((Character)word.charAt(i));
            System.out.print(word.charAt(i));
        }
        System.out.println();
        queue.printQueue();
        String output = "";
        System.out.println("Output:");
        for(int i = 0; i < word.length(); i++)
        {
            Character char_from_queue = queue.dequeue();
            if(char_from_queue == null)
            {
                System.out.println(ANSI_RED+"dequeue method returns null"+ANSI_RESET);
                i = word.length();
            }
            else
            {
                System.out.print(char_from_queue);
                output += char_from_queue;
            }
        }
        System.out.println();
        
        int mark = 0;
        //for(int i = 0; queue.getSize() > 0 && ((Character)queue.dequeue()).equals(word.charAt(i));i++);
        if(queue.getSize() == 0 && word.equals(output))
        {
            mark = 5;
            System.out.println("Passed");
        }
        else
        {
            System.out.println(ANSI_RED+"Failed"+ANSI_RESET);
        }
        return mark;
    }
    
    private static int test_Stack()
    {
        System.out.println("Testing for \"Stack\" methods (mark: 5)");
        Stack<Integer> stack = new Stack();
        
        stack.push(0);
        if(stack.pop()==null)
        {
            System.out.println(ANSI_RED+"Failed"+ANSI_RESET);
            return 0;
        }
        
        for(int i = 0; i < 5; i++)
        {
            stack.push(i);
        }
        
        int mark = 0;               
        
        for(int i = 4; i >=0 && stack.pop() == i; i--);
        
        if(stack.getSize() == 0)
        {
            mark = 5;
            System.out.println("Passed");
        }
        else
        {
            System.out.println(ANSI_RED+"Failed"+ANSI_RESET);
        }
        return mark;
    }    
    
    private static int test_palindrome(int current_mark)
    {
        if (current_mark < 25)
        {
            System.out.println(ANSI_RED+"Cannot test palindrome. Please fix the previous tests first."+ANSI_RESET);
            return 0;
        }
        System.out.println("Testing for \"palindrome\" method (mark: 5)");
        int mark = 0;
        boolean true_test;
        boolean false_test;
        char[] chars = "Able was I ere I saw Elba".toLowerCase().toCharArray();
        Character[] characters = new Character[chars.length];
        for(int i = 0; i < chars.length; i++)
        {
            characters[i] = chars[i];
        }
        DataAnalysis<Character> da = new DataAnalysis(characters);
        
        true_test = da.isPalindrome();
        
        chars = "Able was I ere I  saw Elba".toLowerCase().toCharArray();
        characters = new Character[chars.length];
        for(int i = 0; i < chars.length; i++)
        {
            characters[i] = chars[i];
        }
        da = new DataAnalysis(characters);
        
        false_test = da.isPalindrome();
        
        if(true_test &&!false_test)
        {
            mark = 5;
            System.out.println("Passed");
        }
        else
        {
            System.out.println(ANSI_RED+"Failed"+ANSI_RESET);
        }
        
        return mark;
    }
    
    
    private static int test_add_in_order()
    {
        System.out.println("Testing for \"add in order\" method");
        LinkedList<String> string_list = new LinkedList<>();
        int mark = 0;
        string_list.addInOrder("ABC");
        string_list.addInOrder("ABA");
        string_list.addInOrder("BBB");
        string_list.addInOrder("ABB");
        
        System.out.println("List: ");
        string_list.printLinkedList();
        
        if(  string_list.getNode(0).data.equals("ABA") 
           &&string_list.getNode(1).data.equals("ABB") 
           &&string_list.getNode(2).data.equals("ABC") 
           &&string_list.getNode(3).data.equals("BBB"))
        {
            System.out.println("\tString test Passed");
            mark+=3;
        }
        else
        {
            System.out.println(ANSI_RED+"\tString test Failed"+ANSI_RESET);
        }
        
        LinkedList<Integer> int_list = new LinkedList();
        int_list.addInOrder(3);
        int_list.addInOrder(2);
        int_list.addInOrder(0);
        int_list.addInOrder(1);
        int_list.addInOrder(12);
        
        System.out.println("List: ");
        int_list.printLinkedList();
        
        if(  int_list.getNode(0).data.equals(0) 
           &&int_list.getNode(1).data.equals(1) 
           &&int_list.getNode(2).data.equals(2)
           &&int_list.getNode(3).data.equals(3)
           &&int_list.getNode(4).data.equals(12))
        {
            System.out.println("\tInteger test Passed");
            mark+=2;
        }
        else
        {
            System.out.println(ANSI_RED+"\tInteger test Failed"+ANSI_RESET);
        }
        
        return mark;
    }
}
