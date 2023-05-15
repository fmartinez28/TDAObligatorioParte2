public class Store {
    private Lista<Producto> inventory;
    public Store(){
        inventory = new Lista<>();
    }
    private void AddProduct(Producto prod){
        if (GetProduct(prod.GetCode()) == null){
            this.inventory.Push(prod);
        }
    }

    /**
     * Añade un producto al inventario del supermercado
     * @param name nombre del producto
     * @param price precio del producto
     * @param barcode codigo de barras del producto
     */
    public void AddProduct(String name, float price, String barcode){
        if (GetProduct(barcode) == null){
            this.inventory.Push(new Producto(name, price, barcode));
        }
    }

    /**
     * Incrementa el stock de un producto
     * @param barcode codigo de barra
     * @param stock cantidad que se quiere añadir a un producto
     */
    public void AddStock(String barcode, int stock) {
        Node<Producto> tempProd = GetProduct(barcode);
        if (tempProd != null && stock > 0) {
            int currStock = tempProd.val.GetStock();
            tempProd.val.setStock(currStock + stock);
        }
    }

    /**
     * Decrementa el stock de un producto
     * @param barcode codigo de barra del producto
     * @param stock cantidad de stock que se quiere remover
     */
    public void RemoveStock(String barcode, int stock){
            Node<Producto> tempProd = GetProduct(barcode);
            if (tempProd != null && (tempProd.val.GetStock() - stock) >= 0) {
                tempProd.val.setStock(tempProd.val.GetStock() - stock);
            }
    }

    /**
     * Encuentra un el nodo de un producto en base a su codigo de barra
     * @param barcode
     * @return
     */
    protected Node<Producto> GetProduct(String barcode){
        if(inventory.IsEmpty()) return null;

        Node<Producto> head = inventory.GetFirst();
        while (head != null){
            if (head.val.GetCode().equals(barcode)) return head;
            head = head.next;
        }
        return null;
    }
    public int GetStockOf(String barcode){
        return GetProduct(barcode).val.GetStock();
    }

    public boolean Contains(String barcode){
        return (GetProduct(barcode) != null);
    }

    /**
     * Remueve un producto en base a su codigo de barra
     * @param barcode código de barras del producto a remover
     */
    public void RemoveProduct(String barcode){
        this.inventory.Delete(GetProduct(barcode));
    }

    /**
     * Metodo encargado de importar el inventario de una tienda a otra
     * @param store Instancia de la clase Store, tienda de la que cual quiero importar su inventario
     */
    public void ImportInventory(Store store){
        if (store.inventory.IsEmpty()) return;

        Node<Producto> diffStoreHead = store.inventory.GetFirst();
        while (diffStoreHead != null){
            Node<Producto> temp = GetProduct(diffStoreHead.val.GetCode());
            if (temp != null){
                temp.val.setStock(temp.val.GetStock() + diffStoreHead.val.GetStock());
            } else {
                this.inventory.Push(diffStoreHead.val);
            }
            diffStoreHead = diffStoreHead.next;
        }
    }

    /**
     * Organiza el inventario en base a los nombres de los productos
     */
    public void SortList(){
        Node<Producto> head = this.inventory.GetFirst();
        this.inventory.SetFirst(sort(head));
    }
    private Node<Producto> sort(Node<Producto> head){
        if (head == null || head.next == null) return head;

        Node<Producto> leftHandEnd = head;
        Node<Producto> rightSideHead = head;
        Node<Producto> fastTracker = head;

        while(fastTracker != null && fastTracker.next != null){
            leftHandEnd = rightSideHead;
            rightSideHead = rightSideHead.next;
            fastTracker = fastTracker.next.next;
        }

        leftHandEnd.next = null;

        Node<Producto> leftSide = sort(head);
        Node<Producto> rightSide = sort(rightSideHead);

        return merge(leftSide, rightSide);
    }
    private Node<Producto> merge(Node<Producto> left, Node<Producto> right){
        Node<Producto> oneBeforeHead = new Node<>(null);
        Node<Producto> tailPointer = oneBeforeHead;

        while (left != null && right != null){
            if(left.val.GetName().compareTo(right.val.GetName()) <= 0){
                tailPointer.next = left;
                left = left.next;
            }
            else{
                tailPointer.next = right;
                right = right.next;
            }
            tailPointer = tailPointer.next;
        }
        if (left != null) tailPointer.next = left;
        if (right != null) tailPointer.next = right;

        return oneBeforeHead.next;
    }

    public String ShowProducts(){
        SortList();
        StringBuilder prods = new StringBuilder();
        Node<Producto> looper = inventory.GetFirst();
        while (looper != null){
            prods.append("%s, %s, %s, %s\n".formatted(looper.val.GetName(), looper.val.GetCode(), looper.val.GetStock(), looper.val.GetPrice()));
            looper = looper.next;
        }
        return prods.toString();
    }
}
