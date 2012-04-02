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
 * <p>Java class for amountOfSubstanceUnit.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="amountOfSubstanceUnit">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="mol"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "amountOfSubstanceUnit")
@XmlEnum
public enum AmountOfSubstanceUnit {


    /**
     *  Mol. 
     * 
     */
    @XmlEnumValue("mol")
    MOL("mol");
    private final String value;

    AmountOfSubstanceUnit(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AmountOfSubstanceUnit fromValue(String v) {
        for (AmountOfSubstanceUnit c: AmountOfSubstanceUnit.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
