/**
 * OutsidePlantUpgradeInData.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cl.inexcell.sistemadegestion.webservices;

@SuppressWarnings("serial")
public class OutsidePlantUpgradeInData  implements java.io.Serializable {
    private cl.inexcell.sistemadegestion.webservices.ElementPlantUpgradeType element;

    public OutsidePlantUpgradeInData() {
    }

    public OutsidePlantUpgradeInData(
           cl.inexcell.sistemadegestion.webservices.ElementPlantUpgradeType element) {
           this.element = element;
    }


    /**
     * Gets the element value for this OutsidePlantUpgradeInData.
     * 
     * @return element
     */
    public cl.inexcell.sistemadegestion.webservices.ElementPlantUpgradeType getElement() {
        return element;
    }


    /**
     * Sets the element value for this OutsidePlantUpgradeInData.
     * 
     * @param element
     */
    public void setElement(cl.inexcell.sistemadegestion.webservices.ElementPlantUpgradeType element) {
        this.element = element;
    }

    private java.lang.Object __equalsCalc = null;
    @SuppressWarnings("unused")
	public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof OutsidePlantUpgradeInData)) return false;
        OutsidePlantUpgradeInData other = (OutsidePlantUpgradeInData) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.element==null && other.getElement()==null) || 
             (this.element!=null &&
              this.element.equals(other.getElement())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getElement() != null) {
            _hashCode += getElement().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(OutsidePlantUpgradeInData.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:Demo", "OutsidePlantUpgradeInData"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("element");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Element"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:Demo", "ElementPlantUpgradeType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    @SuppressWarnings("rawtypes")
	public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    @SuppressWarnings("rawtypes")
	public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}