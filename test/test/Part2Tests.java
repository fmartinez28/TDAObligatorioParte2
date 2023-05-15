package test;
import main.Store;
import main.POS;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class Part2Tests {
    Store store = new Store();
    POS pos = new POS(store);

    @Test
    public void checkTicketPrice(){
        store.AddProduct("Almohada", 25.3F, "AALM00021");
        store.AddProduct("Otro", 20.0F, "SALM00021");
        store.AddStock("AALM00021", 5);
        store.AddStock("SALM00021", 5);
        pos.AddToCart("AALM00021", 3);
        pos.AddToCart("SALM00021", 1);
        float ticket = pos.Buy();
        float expected = (25.3F*3)+(20.0F);
        assertEquals(expected, ticket);
    }
    @Test
    public void checkStock(){
        store.AddProduct("Almohada", 25.3F, "AALM00021");
        store.AddStock("AALM00021", 5);
        pos.AddToCart("AALM00021", 3);
        float ticket = pos.Buy();
        int actual = store.GetStockOf("AALM00021");
        int expected = 2;
        assertEquals(expected, actual);
    }
}
