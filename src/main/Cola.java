package main;
/**
 * Clase Cola (queue) implementada utilizando una lista simplemente enlazada, basado en el principio FIFO
 * @param <T> Tipo genérico
 */
public class Cola<T> {
    private Lista<T> queue;
    public Cola(){
        queue = new Lista<>();
    }

    /**
     * Agrega un nodo al final de la cola
     * @param node Nodo a ser agregado
     */
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

    /**
     * Elimina y retorna el elemento al inicio de la cola
     * @return Node<T>
     */
    public Node<T> Dequeue(){
        Node<T> aux = queue.GetFirst();
        queue.Delete(aux);
        return aux;
    }

    /**
     * Retorna el elemento al inicio de la cola
     * @return Node<T>
     */
    public Node<T> Peek(){
        return this.queue.GetFirst();
    }

}
