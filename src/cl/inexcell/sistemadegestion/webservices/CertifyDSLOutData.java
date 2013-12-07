/**
 * CertifyDSLOutData.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cl.inexcell.sistemadegestion.webservices;

@SuppressWarnings("serial")
public class CertifyDSLOutData  implements java.io.Serializable {
    private cl.inexcell.sistemadegestion.webservices.CertifyParameterType[] certifyParameter;

    private cl.inexcell.sistemadegestion.webservices.ReturnType _return;

    public CertifyDSLOutData() {
    }

    public CertifyDSLOutData(
           cl.inexcell.sistemadegestion.webservices.CertifyParameterType[] certifyParameter,
           cl.inexcell.sistemadegestion.webservices.ReturnType _return) {
           this.certifyParameter = certifyParameter;
           this._return = _return;
    }


    /**
     * Gets the certifyParameter value for this CertifyDSLOutData.
     * 
     * @return certifyParameter
     */
    public cl.inexcell.sistemadegestion.webservices.CertifyParameterType[] getCertifyParameter() {
        return certifyParameter;
    }


    /**
     * Sets the certifyParameter value for this CertifyDSLOutData.
     * 
     * @param certifyParameter
     */
    public void setCertifyParameter(cl.inexcell.sistemadegestion.webservices.CertifyParameterType[] certifyParameter) {
        this.certifyParameter = certifyParameter;
    }

    public cl.inexcell.sistemadegestion.webservices.CertifyParameterType getCertifyParameter(int i) {
        return this.certifyParameter[i];
    }

    public void setCertifyParameter(int i, cl.inexcell.sistemadegestion.webservices.CertifyParameterType _value) {
        this.certifyParameter[i] = _value;
    }


    /**
     * Gets the _return value for this CertifyDSLOutData.
     * 
     * @return _return
     */
    public cl.inexcell.sistemadegestion.webservices.ReturnType get_return() {
        return _return;
    }


    /**
     * Sets the _return value for this CertifyDSLOutData.
     * 
     * @param _return
     */
    public void set_return(cl.inexcell.sistemadegestion.webservices.ReturnType _return) {
        this._return = _return;
    }

    private java.lang.Object __equalsCalc = null;
    @SuppressWarnings("unused")
	public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CertifyDSLOutData)) return false;
        CertifyDSLOutData other = (CertifyDSLOutData) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.certifyParameter==null && other.getCertifyParameter()==null) || 
             (this.certifyParameter!=null &&
              java.util.Arrays.equals(this.certifyParameter, other.getCertifyParameter()))) &&
            ((this._return==null && other.get_return()==null) || 
             (this._return!=null &&
              this._return.equals(other.get_return())));
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
        if (getCertifyParameter() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getCertifyParameter());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getCertifyParameter(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (get_return() != null) {
            _hashCode += get_return().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CertifyDSLOutData.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:Demo", "CertifyDSLOutData"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("certifyParameter");
        elemField.setXmlName(new javax.xml.namespace.QName("", "CertifyParameter"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:Demo", "CertifyParameterType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("_return");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Return"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:Demo", "ReturnType"));
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
