package main;
public class Node<T>{
    public T val;
    public Node<T> next = null;
    public Node(T val){
        this.val = val;
    }
    public Node(T val, Node<T> next){
        this.val = val;
        this.next = next;
    }
}
