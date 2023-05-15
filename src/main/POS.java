package main;

public class POS {
    private Cola<String> checkoutLine;
    private Store store;
    public POS(Store store){
        checkoutLine = new Cola<>();
        this.store = store;
    }
    public float Buy(){
        float ticket = 0;
        while (!checkoutLine.IsEmpty()){
            String[] params = checkoutLine.Dequeue().val.split(",");
            ticket += store.GetProduct(params[0]).val.GetPrice()*(Integer.parseInt(params[1]));
            store.RemoveStock(params[0], Integer.parseInt(params[1]));
        }
        return ticket;
    }
    public void AddToCart(String barcode, int quantity){
        Node<Producto> prod = store.GetProduct(barcode);
        if (prod == null) return;
        if(prod.val.GetStock() >= quantity){
            checkoutLine.Enqueue(new Node<String>("%s,%s".formatted(barcode, quantity)));
        } else {
            System.out.println("Stock insuficiente, stock actual: %sU".formatted(prod.val.GetStock()));
        }
    }
}
