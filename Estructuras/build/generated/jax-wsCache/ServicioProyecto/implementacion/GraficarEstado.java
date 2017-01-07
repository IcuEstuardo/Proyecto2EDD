
package implementacion;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para GraficarEstado complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="GraficarEstado">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="posicion1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="posicion2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GraficarEstado", propOrder = {
    "posicion1",
    "posicion2"
})
public class GraficarEstado {

    protected String posicion1;
    protected String posicion2;

    /**
     * Obtiene el valor de la propiedad posicion1.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPosicion1() {
        return posicion1;
    }

    /**
     * Define el valor de la propiedad posicion1.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPosicion1(String value) {
        this.posicion1 = value;
    }

    /**
     * Obtiene el valor de la propiedad posicion2.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPosicion2() {
        return posicion2;
    }

    /**
     * Define el valor de la propiedad posicion2.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPosicion2(String value) {
        this.posicion2 = value;
    }

}
