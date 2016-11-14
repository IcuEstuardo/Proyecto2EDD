package Dijkstra;

/**
 *
 * @author Isabel
 */
public class main {
    
    public static void main(String[] args) {
        
        Dijkstra algoritmo = new Dijkstra();
        algoritmo.AgregarVertices("entradaVertices.txt");
        algoritmo.AgregarPesoAdyacentes("entradaPesos.txt");
        
        algoritmo.MostrarVertices();
        
        algoritmo.EncontrarRutaMinima("A");

    }
    
    
}
