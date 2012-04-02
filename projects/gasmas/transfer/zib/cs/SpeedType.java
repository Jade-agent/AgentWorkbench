//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.04.01 at 12:38:15 AM MESZ 
//


package gasmas.transfer.zib.cs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 *  speedType defines the speed of the gas flow. 
 * 
 * <p>Java class for speedType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="speedType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://mathematik.tu-darmstadt.de/opt/framework/XMLSchema}unitType">
 *       &lt;attribute name="unit" type="{http://mathematik.tu-darmstadt.de/opt/gas/XMLSchema}per_minUnit" default="per_min" />
 *       &lt;attribute name="value" use="required" type="{http://mathematik.tu-darmstadt.de/opt/framework/XMLSchema}double" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "speedType", namespace = "http://mathematik.tu-darmstadt.de/opt/gas/XMLSchema")
public class SpeedType
    extends UnitType
{

    @XmlAttribute
    protected PerMinUnit unit;
    @XmlAttribute(required = true)
    protected double value;

    /**
     * Gets the value of the unit property.
     * 
     * @return
     *     possible object is
     *     {@link PerMinUnit }
     *     
     */
    public PerMinUnit getUnit() {
        if (unit == null) {
            return PerMinUnit.PER_MIN;
        } else {
            return unit;
        }
    }

    /**
     * Sets the value of the unit property.
     * 
     * @param value
     *     allowed object is
     *     {@link PerMinUnit }
     *     
     */
    public void setUnit(PerMinUnit value) {
        this.unit = value;
    }

    /**
     * Gets the value of the value property.
     * 
     */
    public double getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     */
    public void setValue(double value) {
        this.value = value;
    }

}
