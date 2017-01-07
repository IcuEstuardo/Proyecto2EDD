package Dijkstra;

import Heap.arbolHeap;
import java.util.ArrayList;

/**
 *
 * @author Isabel
 */
public class Dijkstra {

    private ArrayList<Vertice> ListaVertices;
    private arbolHeap colaPrioridad;

    private String[] graficas;

    private String recorridos;
    private int contador;

////////////////////////// INICIALIZACION /////////////////////////////////////////////////////////////    
    public Dijkstra() {
        this.ListaVertices = new ArrayList<>();
        this.colaPrioridad = null;
    }

    public void IniciarTodo() {
        this.graficas = new String[4];
        this.contador = 0;
        this.recorridos = "";
    }

    public void InicializarAlgoritmo() {
        for (Vertice item : this.ListaVertices) {
            item.Limpiar();
        }
        this.colaPrioridad = new arbolHeap();
    }

/////////////////////////////// CARGA DATOS ////////////////////////////////////////////////////////
    public boolean AgregarVertices(String ubi) {
        this.ListaVertices = new ArrayList<>();

        try {
            String[] cadenas = ubi.split("\n");
            for (String cadena : cadenas) {
                String[] lineaTxt = cadena.split(";|->");
                if (this.BusquedaVertice(lineaTxt[0]) == null) {
                    this.ListaVertices.add(new Vertice(lineaTxt[0]));
                }
                if (this.BusquedaVertice(lineaTxt[1]) == null) {
                    this.ListaVertices.add(new Vertice(lineaTxt[1]));
                }
                this.BusquedaVertice(lineaTxt[0]).agregarAdyacente(lineaTxt[1]);
            }

//            this.graficador.graficarEstructura(this.GraficaRecorrido("#", "#"), "Reportes", "graficaGrafo");
            this.Recorrer();

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean AgregarPesoAdyacentes(String ubi) {
        try {
            String[] cadenas = ubi.split("\n");
            
            for (String cadena : cadenas) {
                String lineaTxt[] = cadena.split("->| |,|;");
                
                //System.out.println(lineaTxt[0] + " " + lineaTxt[1]);

                if (this.BusquedaVertice(lineaTxt[0]) != null) {
                    
                    if (this.BusquedaVertice(lineaTxt[0]).BusquedaAdyacente(lineaTxt[1]) != null) 
                    {
                        if (lineaTxt.length > 3) {
                            for (int i = 3; i < lineaTxt.length; i++) {
                                this.BusquedaVertice(lineaTxt[0]).BusquedaAdyacente(lineaTxt[1]).InsertarPeso(Integer.parseInt(lineaTxt[i]));
                            }
                        }
                        
                    }
                    
                }
            }

//            this.graficador.graficarEstructura(this.GraficaRecorrido("#", "#"), "Reportes", "graficaGrafo");
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean AgregarTiempo(String a, String b, int tiempo) {
        try {

            if (this.BusquedaVertice(a) != null) {
                if (this.BusquedaVertice(a).BusquedaAdyacente(b) != null) {
                    this.BusquedaVertice(a).BusquedaAdyacente(b).InsertarPeso(tiempo);
                }
            }

            return true;
        } catch (Exception e) {
            return false;
        }
    }

///////////////////////////// ALGORITMO ////////////////////////////////////////////////////////////
    private void Relajacion(Vertice actual, Vertice adyacente, int peso) {
        if ((actual.getDistancia() + peso) < adyacente.getDistancia()) {
            adyacente.setDistancia(actual.getDistancia() + peso);
            adyacente.setAntecesor(actual);

            this.colaPrioridad.Insercion(adyacente.getNombre(), adyacente.getDistancia());
        }
    }

    private void EncontrarRutaMinima(String nOrigen) {
        try {

            Vertice origen = this.BusquedaVertice(nOrigen);
            
            System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
            if (origen != null) {
                System.out.println("Inicio si existe!");
                origen.setDistancia(0);

                this.colaPrioridad.Insercion(origen.getNombre(), 0);

                
                while (!this.colaPrioridad.arbolVacio()) {
                    Vertice actual = this.BusquedaVertice(this.colaPrioridad.Eliminacion().getNombre());

                    if (actual.isEstado() == true) {
                        continue;
                    }

                    actual.setEstado(true);

                    for (Adyacente item : actual.getAdyacentes()) {
                        String nodo = item.getNodo();
                        int peso = item.ObtenerPeso();

                        Vertice adyacente = this.BusquedaVertice(nodo);
                        if (adyacente.isEstado() == false) {
                            this.Relajacion(actual, adyacente, peso);
                        }
                    }
                }
            }

        } catch (Exception e) {
            System.out.println("Error en alguna parte: " + e.toString());
        }
    }

    public void Algoritmo(String origen, String destino) {
        this.IniciarTodo();

        try {
            
            for (int i = 0; i < 4; i++) {
            this.InicializarAlgoritmo();
            this.EncontrarRutaMinima(origen);
            if (this.ExisteRutaHacia(destino)) {
                this.recorridos += this.ObtenerRuta(destino) + "\n";
                this.graficas[contador] = this.GraficaRecorrido("#", "#");
                this.contador++;
                this.BloquearCamino(destino);
            }
        }
            
        } catch (Exception e) {
        }
    }

    private void BloquearCamino(String destino) {

    }

////////////////////////////// RESULTADOS //////////////////////////////////////////
    private boolean ExisteRutaHacia(String destino) {
        return this.BusquedaVertice(destino).getDistancia() != Integer.MAX_VALUE / 2;
    }

    private String ObtenerRuta(String destino) {
        String retorno = "";
        Vertice aux = this.BusquedaVertice(destino);
        while (aux.getAntecesor() != null) {
            retorno = "->" + aux.getNombre() + retorno;
            aux.setSolucion(true);

            aux = aux.getAntecesor();
        }
        retorno = aux.getNombre() + retorno;
        aux.setSolucion(true);

        return retorno;
    }

/////////////////////////////// UTILIDADES ///////////////////////////////////////////////////////
    public Vertice BusquedaVertice(String nombre) {
        for (Vertice item : this.ListaVertices) {
            if (item.getNombre().equals(nombre)) {
                return item;
            }
        }

        return null;
    }

    public String GraficaNormal() {
        String retorno = "";

        for (Vertice nodo : this.ListaVertices) {

            for (Adyacente ady : nodo.getAdyacentes()) {
                retorno += nodo.getNombre() + " -> " + ady.getNodo() + " [label = \"" + ady.ObtenerPeso() + "\"" + "];\n";
            }
        }

        return retorno;
    }

    public String GraficaRecorrido(String A, String B) {
        String retorno = "";

        for (Vertice nodo : this.ListaVertices) {

            for (Adyacente ady : nodo.getAdyacentes()) {
                retorno += nodo.getNombre() + " -> " + ady.getNodo() + " [label = \"" + ady.ObtenerPeso() + "\"";
                String color = "";
                if (nodo.isSolucion() == true && this.BusquedaVertice(ady.getNodo()).isSolucion() == true
                        && this.BusquedaVertice(ady.getNodo()).getAntecesor().getNombre().equals(nodo.getNombre())) {
                    color = ", color = \"red\"";
                }
                if (nodo.getNombre().equals(A) && ady.getNodo().equals(B)) {
                    color = ", color = \"blue\"";
                }
                retorno += color + "];\n";
            }
        }

        return retorno;
    }

/////////////////////////////// ENCAPSULADO ///////////////////////////////////////////////////////
    public String getRecorridos() {
        return recorridos;
    }

    public void setRecorridos(String recorridos) {
        this.recorridos = recorridos;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    public String[] getGraficas() {
        return graficas;
    }

    public void setGraficas(String[] graficas) {
        this.graficas = graficas;
    }

    public void Recorrer()
    {
        for (Vertice item: this.ListaVertices) {
            System.out.println(item.getNombre());
        }
    }
        
}
