package test;
import main.Store;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class Part3Tests {
    Store geant = new Store();
    Store disco = new Store();
    @Test
    public void integrateProducts(){
        //Inventario GEANT
        geant.AddProduct("Almohada", 25.3F, "AALM00021");
        geant.AddProduct("Otro", 20.0F, "SALM00021");
        geant.AddStock("AALM00021", 5);
        geant.AddStock("SALM00021", 5);

        //Inventario DISCO
        disco.AddProduct("Almohada", 25.3F, "AALM00021");
        disco.AddProduct("Distinto", 10.0F, "CALM00021");
        disco.AddStock("AALM00021", 12);
        disco.AddStock("CALM00021", 8);

        String displayed = """
                Nombre: Almohada, Código: AALM00021, Stock: 17, Precio: $25.3
                Nombre: Distinto, Código: CALM00021, Stock: 8, Precio: $10.0
                Nombre: Otro, Código: SALM00021, Stock: 5, Precio: $20.0
                """;
        geant.ImportInventory(disco);
        assertEquals(displayed, geant.ShowProducts());
    }

}