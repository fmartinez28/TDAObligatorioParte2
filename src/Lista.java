import java.util.HashSet;
import java.util.Set;

public class Lista<T> {
    private Node<T> first = null;
    private int size;
    public Lista(){
    }
    public Lista(Node<T> first){
        this.first = first;
    }

    /**
     *
     * @return retorna true o false dependendiendo de si la lista contiene elementos o no.
     */
    public boolean IsEmpty(){
        return (first == null);
    }

    /**
     *
     * @return retorna el último nodo de la lista.
     */
    private Node<T> Last(){
        if (!IsEmpty()){
            int size = 0;
            Node<T> aux = first;
            while (aux.next != null){
                size++;
                aux = aux.next;
            }
            this.size = size;
            return aux;
        }
        return null;
    }

    /**
     *
     * @param siguiente
     */
    public void Push(Node<T> siguiente){
        if (siguiente == null) return;

        Node<T> last = Last();
        if (last != null){
            last.next = siguiente;
        } else {
            first = siguiente;
        }
    }
    public void Push(T val){
        Node<T> aux = new Node<T>(val);
        this.Push(aux);
    }

    /**
     *
     * @param newFirst elemento a agregar al inicio de la lista.
     */
    public void AddFirst(Node<T> newFirst){
        if (IsEmpty()) {
            this.first = newFirst;
            return;
        }
        Node<T> aux = this.first;
        this.first = newFirst;
        newFirst.next = aux;
        return;
    }
    public void SetFirst(Node<T> newFirst){
        this.first = newFirst;
    }

    /**
     *
     * @param val valor del nodo sin referencia que se creará para agregar al inicio de la lista.
     */
    public void AddFirst(T val){
        Node<T> aux = new Node<>(val);
        this.AddFirst(aux);
    }

    /**
     *
     * @param findVal parámetro buscado en los valores de los nodos (val) pertenecientes a la lista
     * @return retorna la primera ocurrencia de un elemento que contenga el valor de findVal
     */
    public Node<T> find(T findVal){
        if (IsEmpty()) return null;

        for (Node<T> aux = first; aux != null; aux = aux.next){
            if (aux.val == findVal) return aux;
        }
        return null;
    }

    /**
     * Elimina un elemento de la lista
     * @param item Node<T>
     */
    public void Delete(Node<T> item) {
        if (IsEmpty()) return;

        if (first != item) {
            Node<T> left = first;
            for (Node<T> right = left.next; right != null; left = right, right = right.next) {
                if (right == item) {
                    left.next = right.next;
                    return;
                }
            }
        } else first = first.next;
    }

    public Node<T> GetFirst(){
        return this.first;
    }

    /**
     * Ingresa un elemento en el índice indicado.
     * @param index Índice (entero positivo) en el cual insertar el elemento
     * @param item  Elemento a insertar (Node<T>)
     */
    public void InsertAt(int index, Node<T> item){
        if (index > -1 ){
            if (index == 0){
                AddFirst(item);
                return;
            }
            if (!IsEmpty()){
                int i = 1;
                for (Node<T> aux = first; aux != null; aux = aux.next){
                    if (i == index) {
                        item.next = aux.next;
                        aux.next = item;
                        return;
                    }
                    i++;
                }
            }
        }
    }

    /**
     * Ingresa un elemento en el índice indicado, creando un elemento en base a el valor ingresado como parámetro.
     * Satisface patrón Creator.
     * @param index Índice en el cual insertar el elemento
     * @param val   Valor del elemento a ser creado para subsecuentemente ser ingresado
     */
    public void InsertAt(int index, T val){
        InsertAt(index, new Node<T>(val));
    }

    /**
     * Elimina elementos duplicados, exceptuando la primera ocurrencia de los mismos
     */
    public void DeleteDuplicates(){
        if (IsEmpty()) return;

        Set<T> knownData = new HashSet<>();
        Node<T> prev = null;
        Node<T> aux = first;
        while(aux != null){
            if(!knownData.contains(aux.val)){
                prev = aux.next;
                knownData.add(aux.val);
            } else {
                Delete(prev);
                prev = aux.next;
            }
            aux = aux.next;
        }
    }
    public int Size(){
        Last();
        return this.size;
    }

}
