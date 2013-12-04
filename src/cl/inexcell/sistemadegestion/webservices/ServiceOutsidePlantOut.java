/**
 * ServiceOutsidePlantOut.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cl.inexcell.sistemadegestion.webservices;

@SuppressWarnings("serial")
public class ServiceOutsidePlantOut  implements java.io.Serializable {
    private cl.inexcell.sistemadegestion.webservices.OutsidePlantOut outsidePlant;

    public ServiceOutsidePlantOut() {
    }

    public ServiceOutsidePlantOut(
           cl.inexcell.sistemadegestion.webservices.OutsidePlantOut outsidePlant) {
           this.outsidePlant = outsidePlant;
    }


    /**
     * Gets the outsidePlant value for this ServiceOutsidePlantOut.
     * 
     * @return outsidePlant
     */
    public cl.inexcell.sistemadegestion.webservices.OutsidePlantOut getOutsidePlant() {
        return outsidePlant;
    }


    /**
     * Sets the outsidePlant value for this ServiceOutsidePlantOut.
     * 
     * @param outsidePlant
     */
    public void setOutsidePlant(cl.inexcell.sistemadegestion.webservices.OutsidePlantOut outsidePlant) {
        this.outsidePlant = outsidePlant;
    }

    private java.lang.Object __equalsCalc = null;
    @SuppressWarnings("unused")
	public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ServiceOutsidePlantOut)) return false;
        ServiceOutsidePlantOut other = (ServiceOutsidePlantOut) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.outsidePlant==null && other.getOutsidePlant()==null) || 
             (this.outsidePlant!=null &&
              this.outsidePlant.equals(other.getOutsidePlant())));
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
        if (getOutsidePlant() != null) {
            _hashCode += getOutsidePlant().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ServiceOutsidePlantOut.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:Demo", "ServiceOutsidePlantOut"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("outsidePlant");
        elemField.setXmlName(new javax.xml.namespace.QName("", "OutsidePlant"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:Demo", "OutsidePlantOut"));
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
