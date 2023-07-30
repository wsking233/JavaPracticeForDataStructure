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
public class Node<E> {

    E data;
    Node<E> next;

    public Node() {

    }

    public Node(E data) {
        this.data = data;
    }

    public boolean equals(Node node) {
        if (this.data == node.data) {
            return true;
        }
        if (node == null || node.data.getClass() != this.data.getClass()) {
            return false;
        }

        return data.equals(node.data);
    }

    public int compareTo(Node node) {
//        return data.compareTo(node.data);
        return 0;
    }

    @Override
    public String toString() {
        if (next != null) {
            return data + " -> ";
        }
        return data + "";
    }
}
