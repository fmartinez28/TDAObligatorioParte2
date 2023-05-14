public class Producto {
    private String name;
    private float price;
    private String barcode;
    public Producto(String name, float price, String barcode){
        this.name = name;
        this.price = price;
        this.barcode = barcode;
    }
    public String GetName(){
        return this.name;
    }
    public float GetPrice(){
        return this.price;
    }
    public void UpdatePrice(float newPrice){
        if (newPrice <= 0) return;
        this.price = newPrice;
    }
    public String GetCode() {
        return this.barcode;
    }
}
