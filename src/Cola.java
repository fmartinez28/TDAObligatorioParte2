/**
 * Clase Cola (queue) implementada utilizando una lista simplemente enlazada, basado en el principio FIFO
 * @param <T> Tipo genérico
 */
public class Cola<T> {
    private Lista<T> queue;
    public Cola(){
        queue = new Lista<>();
    }
    public void Enqueue(Node<T> node){
        if (IsEmpty()) {
            queue.AddFirst(node);
            return;
        }
        Node<T> aux = queue.GetFirst();
        while (aux.next != null){
            aux = aux.next;
        }
        aux.next = node;
    }
    public boolean IsEmpty(){
        return this.queue.IsEmpty();
    }

    public Node<T> Dequeue(){
        Node<T> aux = queue.GetFirst();
        queue.Delete(aux);
        return aux;
    }
    public Node<T> Peek(){
        return this.queue.GetFirst();
    }

}
