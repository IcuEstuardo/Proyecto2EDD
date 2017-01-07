package com.example.estuardo.conexion;

import android.util.Log;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

/**
 * Created by Estuardo on 18/11/2016.
 */

public class wsAlgoritmo {

    private String wsUrl;
    private String nameSpace;

    public wsAlgoritmo()
    {
        //this.wsUrl ="http://192.168.1.4:8080/ServicioWeb/ServicioProyecto?wsdl";
        this.wsUrl ="http://192.168.137.1:8080/ServicioWeb/ServicioProyecto?wsdl";
        this.nameSpace = "http://Implementacion/";
    }


    public String GraficarGrafo() //Revisado
    {
        try
        {
            String funcion = "ReporteGrafo";
            SoapObject request = new SoapObject(nameSpace, funcion);
            request.addProperty("nombre", "reporteGrafo");
            request.addProperty("ruta", false);

            SoapSerializationEnvelope sobre = new SoapSerializationEnvelope(SoapEnvelope.VER11);
            sobre.dotNet = false;
            sobre.setOutputSoapObject(request);

            HttpTransportSE transporte = new HttpTransportSE(wsUrl);
            transporte.call(nameSpace + funcion, sobre);
            SoapPrimitive resultado = (SoapPrimitive) sobre.getResponse();

            Log.v("Resultado", resultado.toString());
            return resultado.toString();

        }catch(Exception e)
        {
            return "Error: " + e.toString();
        }
    }

    public String GraficarRuta(int id)  //Revisado
    {
        try
        {
            String funcion = "GrafoRutaMinima";
            SoapObject request = new SoapObject(nameSpace, funcion);
            request.addProperty("identificador", id);

            SoapSerializationEnvelope sobre = new SoapSerializationEnvelope(SoapEnvelope.VER11);
            sobre.dotNet = false;
            sobre.setOutputSoapObject(request);

            HttpTransportSE transporte = new HttpTransportSE(wsUrl);
            transporte.call(nameSpace + funcion, sobre);
            SoapPrimitive resultado = (SoapPrimitive) sobre.getResponse();

            Log.v("Resultado", resultado.toString());
            return resultado.toString();

        }catch(Exception e)
        {
            return "Error: " + e.toString();
        }
    }

    public String RutasMinimas(String pos1, String pos2)  //Revisado
    {
        try
        {
            String funcion = "RutasMinimas";
            SoapObject request = new SoapObject(nameSpace, funcion);
            request.addProperty("posicion1", pos1);
            request.addProperty("posicion2", pos2);

            SoapSerializationEnvelope sobre = new SoapSerializationEnvelope(SoapEnvelope.VER11);
            sobre.dotNet = false;
            sobre.setOutputSoapObject(request);

            HttpTransportSE transporte = new HttpTransportSE(wsUrl);
            transporte.call(nameSpace + funcion, sobre);
            SoapPrimitive resultado = (SoapPrimitive) sobre.getResponse();

            Log.v("Resultado", resultado.toString());
            return resultado.toString();

        }catch(Exception e)
        {
            return "Error: " + e.toString();
        }
    }

    public String GraficarEstado(String pos1, String pos2)  //Revisado
    {
        try
        {
            String funcion = "GraficarEstado";
            SoapObject request = new SoapObject(nameSpace, funcion);
            request.addProperty("posicion1", pos1);
            request.addProperty("posicion2", pos2);

            SoapSerializationEnvelope sobre = new SoapSerializationEnvelope(SoapEnvelope.VER11);
            sobre.dotNet = false;
            sobre.setOutputSoapObject(request);

            HttpTransportSE transporte = new HttpTransportSE(wsUrl);
            transporte.call(nameSpace + funcion, sobre);
            SoapPrimitive resultado = (SoapPrimitive) sobre.getResponse();

            Log.v("Resultado", resultado.toString());
            return resultado.toString();

        }catch(Exception e)
        {
            return "Error: " + e.toString();
        }
    }

    public boolean AgregarTiempo(String pos1, String pos2, String user, int tiempo)  //Revisado
    {
        try
        {
            String funcion = "AgregarTiempo";
            SoapObject request = new SoapObject(nameSpace, funcion);
            request.addProperty("posicion1", pos1);
            request.addProperty("posicion2", pos2);
            request.addProperty("username", user);
            request.addProperty("tiempo", tiempo);

            SoapSerializationEnvelope sobre = new SoapSerializationEnvelope(SoapEnvelope.VER11);
            sobre.dotNet = false;
            sobre.setOutputSoapObject(request);

            HttpTransportSE transporte = new HttpTransportSE(wsUrl);
            transporte.call(nameSpace + funcion, sobre);
            SoapPrimitive resultado = (SoapPrimitive) sobre.getResponse();

            Log.v("Resultado", resultado.toString());
            return Boolean.parseBoolean(resultado.toString());

        }catch(Exception e)
        {
            return false;
        }
    }

    public boolean CrearHistorial(String user, String ori, String des, int ubi)
    {
        try
        {
            String funcion = "CrearHistorial";
            SoapObject request = new SoapObject(nameSpace, funcion);
            request.addProperty("username", user);
            request.addProperty("origen", ori);
            request.addProperty("destino", des);
            request.addProperty("ubicacion", ubi);

            SoapSerializationEnvelope sobre = new SoapSerializationEnvelope(SoapEnvelope.VER11);
            sobre.dotNet = false;
            sobre.setOutputSoapObject(request);

            HttpTransportSE transporte = new HttpTransportSE(wsUrl);
            transporte.call(nameSpace + funcion, sobre);
            SoapPrimitive resultado = (SoapPrimitive) sobre.getResponse();

            return Boolean.parseBoolean(resultado.toString());

        }catch(Exception e)
        {
            return false;
        }
    }


    public String ObtenerHistorial(String user)
    {
        try
        {
            String funcion = "ObtenerHistorial";
            SoapObject request = new SoapObject(nameSpace, funcion);
            request.addProperty("nombre", user);

            SoapSerializationEnvelope sobre = new SoapSerializationEnvelope(SoapEnvelope.VER11);
            sobre.dotNet = false;
            sobre.setOutputSoapObject(request);

            HttpTransportSE transporte = new HttpTransportSE(wsUrl);
            transporte.call(nameSpace + funcion, sobre);
            SoapPrimitive resultado = (SoapPrimitive) sobre.getResponse();

            return resultado.toString();

        }catch(Exception e)
        {
            return ".";
        }
    }

    public String GraficarHistoria(String username, int codigo)
    {
        try
        {
            String funcion = "GraficarHistoria";
            SoapObject request = new SoapObject(nameSpace, funcion);
            request.addProperty("username", username);
            request.addProperty("codigo", codigo);

            SoapSerializationEnvelope sobre = new SoapSerializationEnvelope(SoapEnvelope.VER11);
            sobre.dotNet = false;
            sobre.setOutputSoapObject(request);

            HttpTransportSE transporte = new HttpTransportSE(wsUrl);
            transporte.call(nameSpace + funcion, sobre);
            SoapPrimitive resultado = (SoapPrimitive) sobre.getResponse();

            return resultado.toString();

        }catch(Exception e)
        {
            return ".";
        }
    }

}
