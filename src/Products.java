import java.util.HashMap;

public class Products {
    private final HashMap<Producto, Integer> inventory = new HashMap<>();
    public void AddProduct(Producto product){
        this.inventory.put(product, 0);
    }
    public void AddProduct(String name, float price, String barcode){
        AddProduct(new Producto(name, price, barcode));
    }
    public void AddStock(String barcode, int newStock){
        if (newStock > 0){
            Producto tempProduct = GetProduct(barcode);
            if (tempProduct != null){
                this.inventory.put(tempProduct, (inventory.get(tempProduct)+newStock));
            }
        }
    }
    public Producto GetProduct(String barcode){
        for(Producto key : inventory.keySet()){
            if (key.GetCode() == barcode) return key;
        }
        return null;
    }
    public void RemoveProduct(String barcode){
        this.inventory.remove(GetProduct(barcode));
    }
    public void RemoveStock(String barcode, int stock){
        ///
    }

}
