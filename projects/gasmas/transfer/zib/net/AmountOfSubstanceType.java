//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.04.01 at 12:35:43 AM MESZ 
//


package gasmas.transfer.zib.net;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 *  Amount of substance type. 
 * 
 * <p>Java class for amountOfSubstanceType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="amountOfSubstanceType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://mathematik.tu-darmstadt.de/opt/framework/XMLSchema}unitType">
 *       &lt;attribute name="unit" type="{http://mathematik.tu-darmstadt.de/opt/framework/XMLSchema}amountOfSubstanceUnit" default="mol" />
 *       &lt;attribute name="value" use="required" type="{http://www.w3.org/2001/XMLSchema}double" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "amountOfSubstanceType")
public class AmountOfSubstanceType
    extends UnitType
{

    @XmlAttribute
    protected AmountOfSubstanceUnit unit;
    @XmlAttribute(required = true)
    protected double value;

    /**
     * Gets the value of the unit property.
     * 
     * @return
     *     possible object is
     *     {@link AmountOfSubstanceUnit }
     *     
     */
    public AmountOfSubstanceUnit getUnit() {
        if (unit == null) {
            return AmountOfSubstanceUnit.MOL;
        } else {
            return unit;
        }
    }

    /**
     * Sets the value of the unit property.
     * 
     * @param value
     *     allowed object is
     *     {@link AmountOfSubstanceUnit }
     *     
     */
    public void setUnit(AmountOfSubstanceUnit value) {
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
