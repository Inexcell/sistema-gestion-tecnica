/**
 * VendorOutData.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cl.inexcell.sistemadegestion.webservices;

@SuppressWarnings("serial")
public class VendorOutData  implements java.io.Serializable {
    private java.lang.String[] vendor;

    private cl.inexcell.sistemadegestion.webservices.ReturnType _return;

    public VendorOutData() {
    }

    public VendorOutData(
           java.lang.String[] vendor,
           cl.inexcell.sistemadegestion.webservices.ReturnType _return) {
           this.vendor = vendor;
           this._return = _return;
    }


    /**
     * Gets the vendor value for this VendorOutData.
     * 
     * @return vendor
     */
    public java.lang.String[] getVendor() {
        return vendor;
    }


    /**
     * Sets the vendor value for this VendorOutData.
     * 
     * @param vendor
     */
    public void setVendor(java.lang.String[] vendor) {
        this.vendor = vendor;
    }


    /**
     * Gets the _return value for this VendorOutData.
     * 
     * @return _return
     */
    public cl.inexcell.sistemadegestion.webservices.ReturnType get_return() {
        return _return;
    }


    /**
     * Sets the _return value for this VendorOutData.
     * 
     * @param _return
     */
    public void set_return(cl.inexcell.sistemadegestion.webservices.ReturnType _return) {
        this._return = _return;
    }

    private java.lang.Object __equalsCalc = null;
    @SuppressWarnings("unused")
	public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof VendorOutData)) return false;
        VendorOutData other = (VendorOutData) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.vendor==null && other.getVendor()==null) || 
             (this.vendor!=null &&
              java.util.Arrays.equals(this.vendor, other.getVendor()))) &&
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
        if (getVendor() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getVendor());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getVendor(), i);
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
        new org.apache.axis.description.TypeDesc(VendorOutData.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:Demo", "VendorOutData"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("vendor");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Vendor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "Name"));
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
