/**
 * ServiceCertifyDSLIn.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cl.inexcell.sistemadegestion.webservices;

@SuppressWarnings("serial")
public class ServiceCertifyDSLIn  implements java.io.Serializable {
    private cl.inexcell.sistemadegestion.webservices.CertifyDSLIn certifyDSL;

    public ServiceCertifyDSLIn() {
    }

    public ServiceCertifyDSLIn(
           cl.inexcell.sistemadegestion.webservices.CertifyDSLIn certifyDSL) {
           this.certifyDSL = certifyDSL;
    }


    /**
     * Gets the certifyDSL value for this ServiceCertifyDSLIn.
     * 
     * @return certifyDSL
     */
    public cl.inexcell.sistemadegestion.webservices.CertifyDSLIn getCertifyDSL() {
        return certifyDSL;
    }


    /**
     * Sets the certifyDSL value for this ServiceCertifyDSLIn.
     * 
     * @param certifyDSL
     */
    public void setCertifyDSL(cl.inexcell.sistemadegestion.webservices.CertifyDSLIn certifyDSL) {
        this.certifyDSL = certifyDSL;
    }

    private java.lang.Object __equalsCalc = null;
    @SuppressWarnings("unused")
	public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ServiceCertifyDSLIn)) return false;
        ServiceCertifyDSLIn other = (ServiceCertifyDSLIn) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.certifyDSL==null && other.getCertifyDSL()==null) || 
             (this.certifyDSL!=null &&
              this.certifyDSL.equals(other.getCertifyDSL())));
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
        if (getCertifyDSL() != null) {
            _hashCode += getCertifyDSL().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ServiceCertifyDSLIn.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:Demo", "ServiceCertifyDSLIn"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("certifyDSL");
        elemField.setXmlName(new javax.xml.namespace.QName("", "CertifyDSL"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:Demo", "CertifyDSLIn"));
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
