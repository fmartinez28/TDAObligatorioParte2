package main;
public class Producto implements Comparable<Producto> {
    private String name;
    private float price;
    private String barcode;
    private int stock = 0;
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

    public int GetStock() {
        return stock;
    }

    public void setStock(int stock) {
        if (stock >= 0){
            this.stock = stock;
        }
    }
    public String Print(){
        return "%s, %s, %s".formatted(this.name, this.barcode, this.price);
    }
    @Override
    public int compareTo(Producto prod) {
        return this.name.compareTo(prod.name);
    }
}
