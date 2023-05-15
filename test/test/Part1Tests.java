package test;
import main.Store;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Part1Tests {
    Store store = new Store();
    @Test
    void addProduct() {
        store.AddProduct("Almohada", 25.3F, "AALM00021");
        assertTrue(store.Contains("AALM00021"));
    }
    @Test
    void addStock(){
        store.AddProduct("Almohada", 25.3F, "AALM00021");
        store.AddStock("AALM00021", 5);
        int actualStock = store.GetStockOf("AALM00021");
        assertEquals(5, actualStock);
    }
    @Test
    void decreaseStock(){
        store.AddProduct("Almohada", 25.3F, "AALM00021");
        store.AddStock("AALM00021", 5);
        store.RemoveStock("AALM00021", 2);
        int actualStock = store.GetStockOf("AALM00021");
        assertEquals(3, actualStock);
    }
    @Test
    void removeProduct(){
        store.AddProduct("Almohada", 25.3F, "AALM00021");
        store.AddStock("AALM00021", 5);
        store.RemoveProduct("AALM00021");
        assertFalse(store.Contains("AALM00021"));
    }
    @Test
    void showProducts(){
        store.AddProduct("Almohada", 25.3F, "AALM00021");
        store.AddProduct("Otro", 20.0F, "SALM00021");
        store.AddStock("AALM00021", 5);
        store.AddStock("SALM00021", 5);
        String displayed = """
                Nombre: Almohada, Código: AALM00021, Stock: 5, Precio: $25.3
                Nombre: Otro, Código: SALM00021, Stock: 5, Precio: $20.0
                """;
        assertEquals(displayed, store.ShowProducts());
    }
}