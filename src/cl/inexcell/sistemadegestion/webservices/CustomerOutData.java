/**
 * CustomerOutData.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cl.inexcell.sistemadegestion.webservices;

public class CustomerOutData  implements java.io.Serializable {
    private cl.inexcell.sistemadegestion.webservices.CPE CPE;

    private cl.inexcell.sistemadegestion.webservices.ReturnType _return;

    public CustomerOutData() {
    }

    public CustomerOutData(
           cl.inexcell.sistemadegestion.webservices.CPE CPE,
           cl.inexcell.sistemadegestion.webservices.ReturnType _return) {
           this.CPE = CPE;
           this._return = _return;
    }


    /**
     * Gets the CPE value for this CustomerOutData.
     * 
     * @return CPE
     */
    public cl.inexcell.sistemadegestion.webservices.CPE getCPE() {
        return CPE;
    }


    /**
     * Sets the CPE value for this CustomerOutData.
     * 
     * @param CPE
     */
    public void setCPE(cl.inexcell.sistemadegestion.webservices.CPE CPE) {
        this.CPE = CPE;
    }


    /**
     * Gets the _return value for this CustomerOutData.
     * 
     * @return _return
     */
    public cl.inexcell.sistemadegestion.webservices.ReturnType get_return() {
        return _return;
    }


    /**
     * Sets the _return value for this CustomerOutData.
     * 
     * @param _return
     */
    public void set_return(cl.inexcell.sistemadegestion.webservices.ReturnType _return) {
        this._return = _return;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CustomerOutData)) return false;
        CustomerOutData other = (CustomerOutData) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.CPE==null && other.getCPE()==null) || 
             (this.CPE!=null &&
              this.CPE.equals(other.getCPE()))) &&
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
        if (getCPE() != null) {
            _hashCode += getCPE().hashCode();
        }
        if (get_return() != null) {
            _hashCode += get_return().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CustomerOutData.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:Demo", "CustomerOutData"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CPE");
        elemField.setXmlName(new javax.xml.namespace.QName("", "CPE"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:Demo", "CPE"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
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
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
