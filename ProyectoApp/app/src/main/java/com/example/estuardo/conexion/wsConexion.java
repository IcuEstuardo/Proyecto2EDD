package com.example.estuardo.conexion;

/**
 * Created by Estuardo on 15/11/2016.
 */

import android.hardware.camera2.params.StreamConfigurationMap;
import android.util.Log;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

public class wsConexion {

    private String wsUrl;
    private String nameSpace;

    public wsConexion()
    {
        this.wsUrl ="http://192.168.137.1:8080/ServicioWeb/ServicioProyecto?wsdl";
     //   this.wsUrl ="http://192.168.1.4:8080/ServicioWeb/ServicioProyecto?wsdl";
        this.nameSpace = "http://Implementacion/";
    }

    public String Testeador(String usu, String cla){
        try
        {
            String funcion = "FuncionPrueba";
            SoapObject request = new SoapObject(nameSpace, funcion);
            request.addProperty("nombre", usu);
            request.addProperty("pass", cla);

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


    public String RegistrarUsuario(String usu, String cla, String ema){
        try
        {
            String funcion = "RegistroUsuario";
            SoapObject request = new SoapObject(nameSpace, funcion);
            request.addProperty("username", usu);
            request.addProperty("password", cla);
            request.addProperty("correo", ema);

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

    public String IngresoUsuario(String user){
        try
        {
            String funcion = "BusquedaUsuario";
            SoapObject request = new SoapObject(nameSpace, funcion);
            request.addProperty("username", user);

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

    public boolean ModificarUsuario(String user, String pass, String ema, String path)
    {
        try
        {
            String funcion = "ModificarUsuario";
            SoapObject request = new SoapObject(nameSpace, funcion);
            request.addProperty("username", user);
            request.addProperty("password", pass);
            request.addProperty("correo", ema);
            request.addProperty("path", path);

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



}
