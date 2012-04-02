//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.04.01 at 12:38:15 AM MESZ 
//


package gasmas.transfer.zib.cs;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for heatTransferUnit.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="heatTransferUnit">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="W_per_m_square_per_K"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "heatTransferUnit")
@XmlEnum
public enum HeatTransferUnit {

    @XmlEnumValue("W_per_m_square_per_K")
    W_PER_M_SQUARE_PER_K("W_per_m_square_per_K");
    private final String value;

    HeatTransferUnit(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static HeatTransferUnit fromValue(String v) {
        for (HeatTransferUnit c: HeatTransferUnit.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
