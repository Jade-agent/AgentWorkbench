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
import javax.xml.bind.annotation.XmlType;


/**
 *  Definition of the turbo compressor measurement type
 * 			
 * 
 * <p>Java class for tc_measurementType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tc_measurementType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="speed" type="{http://ifam.uni-hannover.de/ao/nopt/compressorStation}speedType"/>
 *         &lt;element name="adiabaticHead">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="unit" type="{http://mathematik.tu-darmstadt.de/opt/framework/XMLSchema}string" default="kJ_per_kg" />
 *                 &lt;attribute name="value" use="required" type="{http://mathematik.tu-darmstadt.de/opt/framework/XMLSchema}double" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="volumetricFlowrate">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="unit" type="{http://mathematik.tu-darmstadt.de/opt/framework/XMLSchema}string" default="m_cube_per_s" />
 *                 &lt;attribute name="value" use="required" type="{http://mathematik.tu-darmstadt.de/opt/framework/XMLSchema}double" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tc_measurementType", namespace = "http://ifam.uni-hannover.de/ao/nopt/compressorStation", propOrder = {
    "speed",
    "adiabaticHead",
    "volumetricFlowrate"
})
public class TcMeasurementType {

    @XmlElement(required = true)
    protected CompressorSpeedType speed;
    @XmlElement(required = true)
    protected TcMeasurementType.AdiabaticHead adiabaticHead;
    @XmlElement(required = true)
    protected TcMeasurementType.VolumetricFlowrate volumetricFlowrate;

    /**
     * Gets the value of the speed property.
     * 
     * @return
     *     possible object is
     *     {@link CompressorSpeedType }
     *     
     */
    public CompressorSpeedType getSpeed() {
        return speed;
    }

    /**
     * Sets the value of the speed property.
     * 
     * @param value
     *     allowed object is
     *     {@link CompressorSpeedType }
     *     
     */
    public void setSpeed(CompressorSpeedType value) {
        this.speed = value;
    }

    /**
     * Gets the value of the adiabaticHead property.
     * 
     * @return
     *     possible object is
     *     {@link TcMeasurementType.AdiabaticHead }
     *     
     */
    public TcMeasurementType.AdiabaticHead getAdiabaticHead() {
        return adiabaticHead;
    }

    /**
     * Sets the value of the adiabaticHead property.
     * 
     * @param value
     *     allowed object is
     *     {@link TcMeasurementType.AdiabaticHead }
     *     
     */
    public void setAdiabaticHead(TcMeasurementType.AdiabaticHead value) {
        this.adiabaticHead = value;
    }

    /**
     * Gets the value of the volumetricFlowrate property.
     * 
     * @return
     *     possible object is
     *     {@link TcMeasurementType.VolumetricFlowrate }
     *     
     */
    public TcMeasurementType.VolumetricFlowrate getVolumetricFlowrate() {
        return volumetricFlowrate;
    }

    /**
     * Sets the value of the volumetricFlowrate property.
     * 
     * @param value
     *     allowed object is
     *     {@link TcMeasurementType.VolumetricFlowrate }
     *     
     */
    public void setVolumetricFlowrate(TcMeasurementType.VolumetricFlowrate value) {
        this.volumetricFlowrate = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attribute name="unit" type="{http://mathematik.tu-darmstadt.de/opt/framework/XMLSchema}string" default="kJ_per_kg" />
     *       &lt;attribute name="value" use="required" type="{http://mathematik.tu-darmstadt.de/opt/framework/XMLSchema}double" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class AdiabaticHead {

        @XmlAttribute
        protected String unit;
        @XmlAttribute(required = true)
        protected double value;

        /**
         * Gets the value of the unit property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getUnit() {
            if (unit == null) {
                return "kJ_per_kg";
            } else {
                return unit;
            }
        }

        /**
         * Sets the value of the unit property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setUnit(String value) {
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


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attribute name="unit" type="{http://mathematik.tu-darmstadt.de/opt/framework/XMLSchema}string" default="m_cube_per_s" />
     *       &lt;attribute name="value" use="required" type="{http://mathematik.tu-darmstadt.de/opt/framework/XMLSchema}double" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class VolumetricFlowrate {

        @XmlAttribute
        protected String unit;
        @XmlAttribute(required = true)
        protected double value;

        /**
         * Gets the value of the unit property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getUnit() {
            if (unit == null) {
                return "m_cube_per_s";
            } else {
                return unit;
            }
        }

        /**
         * Sets the value of the unit property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setUnit(String value) {
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

}
