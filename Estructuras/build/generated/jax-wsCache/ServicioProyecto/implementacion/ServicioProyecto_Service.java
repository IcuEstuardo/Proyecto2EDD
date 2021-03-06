
package implementacion;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "ServicioProyecto", targetNamespace = "http://Implementacion/", wsdlLocation = "http://localhost:8080/ServicioWeb/ServicioProyecto?wsdl")
public class ServicioProyecto_Service
    extends Service
{

    private final static URL SERVICIOPROYECTO_WSDL_LOCATION;
    private final static WebServiceException SERVICIOPROYECTO_EXCEPTION;
    private final static QName SERVICIOPROYECTO_QNAME = new QName("http://Implementacion/", "ServicioProyecto");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/ServicioWeb/ServicioProyecto?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        SERVICIOPROYECTO_WSDL_LOCATION = url;
        SERVICIOPROYECTO_EXCEPTION = e;
    }

    public ServicioProyecto_Service() {
        super(__getWsdlLocation(), SERVICIOPROYECTO_QNAME);
    }

    public ServicioProyecto_Service(WebServiceFeature... features) {
        super(__getWsdlLocation(), SERVICIOPROYECTO_QNAME, features);
    }

    public ServicioProyecto_Service(URL wsdlLocation) {
        super(wsdlLocation, SERVICIOPROYECTO_QNAME);
    }

    public ServicioProyecto_Service(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, SERVICIOPROYECTO_QNAME, features);
    }

    public ServicioProyecto_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ServicioProyecto_Service(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns ServicioProyecto
     */
    @WebEndpoint(name = "ServicioProyectoPort")
    public ServicioProyecto getServicioProyectoPort() {
        return super.getPort(new QName("http://Implementacion/", "ServicioProyectoPort"), ServicioProyecto.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ServicioProyecto
     */
    @WebEndpoint(name = "ServicioProyectoPort")
    public ServicioProyecto getServicioProyectoPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://Implementacion/", "ServicioProyectoPort"), ServicioProyecto.class, features);
    }

    private static URL __getWsdlLocation() {
        if (SERVICIOPROYECTO_EXCEPTION!= null) {
            throw SERVICIOPROYECTO_EXCEPTION;
        }
        return SERVICIOPROYECTO_WSDL_LOCATION;
    }

}
