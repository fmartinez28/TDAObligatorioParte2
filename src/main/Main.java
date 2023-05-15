package main;
public class Main {
    public static void main(String[] args) {
        Store geant = new Store();
        POS pos = new POS(geant);
        LoadAll(geant, 30);
    }

    /**
     * Añade n productos junto con su stock a una tienda especificada.
     * @param store Tienda a la cual añadir los productos
     * @param n Cantidad de entradas a incluir
     */
    public static void LoadAll(Store store, int n){
            String[] prodsArr = ManejadorArchivosGenerico.
                    leerArchivo(
                            "%s/res/productos_tarea.txt".formatted(System.getProperty("user.dir"))
                    );
            String[] stockArr = ManejadorArchivosGenerico.
                    leerArchivo(
                            "%s/res/stock_tarea.txt".formatted(System.getProperty("user.dir"))
                    );
            for(int ln = 1; ln <= n+1; ln++){
                String[] line = prodsArr[ln].split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
                String[] stockL = stockArr[ln].split(" ");
                store.AddProduct(line[1], Float.parseFloat(line[2]), line[0]);
                store.AddStock(stockL[0], Integer.parseInt(stockL[1]));
            }
        }
}