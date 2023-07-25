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

        return false;
    }
}
