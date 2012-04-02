//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.04.01 at 12:35:43 AM MESZ 
//


package gasmas.transfer.zib.net;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for electricalCurrentUnit.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="electricalCurrentUnit">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="A"/>
 *     &lt;enumeration value="mA"/>
 *     &lt;enumeration value="kA"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "electricalCurrentUnit")
@XmlEnum
public enum ElectricalCurrentUnit {


    /**
     *  Ampere. 
     * 
     */
    A("A"),

    /**
     *  Milliampere. 
     * 
     */
    @XmlEnumValue("mA")
    M_A("mA"),

    /**
     *  Kiloampere. 
     * 
     */
    @XmlEnumValue("kA")
    K_A("kA");
    private final String value;

    ElectricalCurrentUnit(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ElectricalCurrentUnit fromValue(String v) {
        for (ElectricalCurrentUnit c: ElectricalCurrentUnit.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
