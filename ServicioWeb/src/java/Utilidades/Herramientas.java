package Utilidades;

import java.io.File;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author estuardo
 */
public class Herramientas {
    
    public Herramientas(){}
    
    public String graficarEstructura(String cuerpo, String ruta, String nombre)
    {
        String ubicacion = "E:\\Mis Documentos\\GitHub\\Proyecto2EDD\\ServicioWeb\\build\\web\\Imagenes\\"+ ruta + "\\";
        
        try {
            File archivo = new File(ubicacion + "archivo.dot");
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
                bw.write("digraph G { \n");
                bw.write(cuerpo);
                bw.write("\n}\n");
                bw.close();
            }
            
            
            
            this.ejecutarCMD("\"C:\\Program Files (x86)\\Graphviz2.38\\bin\\dot.exe\" -Tpng \"" + ubicacion + "archivo.dot\" -o \"" + ubicacion  + nombre +  ".png\"");
            //this.ejecutarCMD(nombre + ".png");
            
            return ubicacion + nombre + ".png";
            
        } catch (Exception e) {
            return "error";
        }        
    }
    
    
    private void ejecutarCMD(String comando)
    {
        String salida;
        //String comando = "cmd /c tree";
 
        try{
 
            // Ejecucion Basica del Comando
            Process proceso = Runtime.getRuntime().exec(comando);
 
            InputStreamReader entrada = new InputStreamReader(proceso.getInputStream());
            BufferedReader stdInput = new BufferedReader(entrada);
 
            //Si el comando tiene una salida la mostramos
            if((salida = stdInput.readLine()) != null){
                System.out.println("Comando ejecutado Correctamente");
                while ((salida=stdInput.readLine()) != null){
                    System.out.println(salida);
                }
            }else{
                System.out.println("No se a producido ninguna salida");
            }
        }catch (IOException e) {
                System.out.println("Excepción: " + e.getMessage());
                System.out.println("          " + e.toString());
                //e.printStackTrace();
        }
    }
    
    
    private void ejecutarComando(String instruccion)
    {
        try {
            String s;
            Process p = Runtime.getRuntime().exec(instruccion);
            

            BufferedReader stdInput = new BufferedReader(new InputStreamReader(
                    p.getInputStream()));

            BufferedReader stdError = new BufferedReader(new InputStreamReader(
                    p.getErrorStream()));

            // Leemos la salida del comando
            System.out.println("Ésta es la salida standard del comando:\n");
            while ((s = stdInput.readLine()) != null) {
                System.out.println(s);
            }

            // Leemos los errores si los hubiera
            System.out.println("Ésta es la salida standard de error del comando (si la hay):\n");
            while ((s = stdError.readLine()) != null) {
                System.out.println(s);
            }
        } catch (Exception e) {
        }
    }
    
}
