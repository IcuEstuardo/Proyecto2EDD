package com.example.estuardo.conexion;

/**
 * Created by Estuardo on 15/11/2016.
 */

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

public class wsConexion {

    private String wsURL;
    private String nameSpace;

    public wsConexion()
    {
        this.wsURL ="http://192.168.1.2:8080/ServicioWeb/ServicioProyecto?wsdl";
        this.nameSpace = "http://ServicioWeb/";
    }

    public String RegistrarUsuario(String usu, String cla, String ema){
        SoapObject jug = new SoapObject(nameSpace,"RegistroUsuario");
        jug.addProperty("usu", usu);
        jug.addProperty("cla", cla);
        jug.addProperty("ema", ema);

        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        envelope.setOutputSoapObject(jug);
        envelope.dotNet = false;

        HttpTransportSE http = new HttpTransportSE(wsURL);
        try {
            http.call(nameSpace, envelope);
            SoapPrimitive respuesta = (SoapPrimitive) envelope.getResponse();
            return respuesta.toString();

        }catch (Exception e){
            e.printStackTrace();
            return "Error: "+e.toString();
        }
    }

    public String IngresoUsuario(String user, String pass){

        SoapObject busJug = new SoapObject(nameSpace,"BusquedaUsuario");
        busJug.addProperty("val", user);

        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        envelope.setOutputSoapObject(busJug);
        envelope.dotNet = false;

        HttpTransportSE http = new HttpTransportSE(wsURL);
        try {
            http.call(nameSpace, envelope);
            SoapPrimitive respuesta = (SoapPrimitive) envelope.getResponse();
            return respuesta.toString();

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }



}
