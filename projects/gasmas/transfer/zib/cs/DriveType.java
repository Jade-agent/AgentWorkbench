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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 *  Definition of the abstract drive type. All drives contain a sequence
 * 				of coefficients describing the specific energy consumption rate. A quadratic
 * 				least-squares fit has the form: f(x) = [1 x x*x] * [b1 b2 b3]^T. Three dimensionless
 * 				coefficients for the specific energy consumption rate resulting from a quadratic
 * 				fit: f(x) = y with x = shaft power in kW, y = specific fuel consumption in kW
 * 			
 * 
 * <p>Java class for driveType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="driveType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="energy_rate_fun_coeff_1" type="{http://mathematik.tu-darmstadt.de/opt/framework/XMLSchema}noType"/>
 *         &lt;element name="energy_rate_fun_coeff_2" type="{http://mathematik.tu-darmstadt.de/opt/framework/XMLSchema}noType"/>
 *         &lt;element name="energy_rate_fun_coeff_3" type="{http://mathematik.tu-darmstadt.de/opt/framework/XMLSchema}noType"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "driveType", namespace = "http://ifam.uni-hannover.de/ao/nopt/compressorStation", propOrder = {
    "energyRateFunCoeff1",
    "energyRateFunCoeff2",
    "energyRateFunCoeff3"
})
@XmlSeeAlso({
    SteamTurbineType.class,
    GasTurbineType.class,
    GasDrivenMotorType.class,
    ElectricMotorType.class
})
public class DriveType {

    @XmlElement(name = "energy_rate_fun_coeff_1", required = true)
    protected NoType energyRateFunCoeff1;
    @XmlElement(name = "energy_rate_fun_coeff_2", required = true)
    protected NoType energyRateFunCoeff2;
    @XmlElement(name = "energy_rate_fun_coeff_3", required = true)
    protected NoType energyRateFunCoeff3;
    @XmlAttribute(required = true)
    protected String id;

    /**
     * Gets the value of the energyRateFunCoeff1 property.
     * 
     * @return
     *     possible object is
     *     {@link NoType }
     *     
     */
    public NoType getEnergyRateFunCoeff1() {
        return energyRateFunCoeff1;
    }

    /**
     * Sets the value of the energyRateFunCoeff1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link NoType }
     *     
     */
    public void setEnergyRateFunCoeff1(NoType value) {
        this.energyRateFunCoeff1 = value;
    }

    /**
     * Gets the value of the energyRateFunCoeff2 property.
     * 
     * @return
     *     possible object is
     *     {@link NoType }
     *     
     */
    public NoType getEnergyRateFunCoeff2() {
        return energyRateFunCoeff2;
    }

    /**
     * Sets the value of the energyRateFunCoeff2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link NoType }
     *     
     */
    public void setEnergyRateFunCoeff2(NoType value) {
        this.energyRateFunCoeff2 = value;
    }

    /**
     * Gets the value of the energyRateFunCoeff3 property.
     * 
     * @return
     *     possible object is
     *     {@link NoType }
     *     
     */
    public NoType getEnergyRateFunCoeff3() {
        return energyRateFunCoeff3;
    }

    /**
     * Sets the value of the energyRateFunCoeff3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link NoType }
     *     
     */
    public void setEnergyRateFunCoeff3(NoType value) {
        this.energyRateFunCoeff3 = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

}
