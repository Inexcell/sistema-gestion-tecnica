/**
 * GPSType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cl.inexcell.sistemadegestion.webservices;

public class GPSType  implements java.io.Serializable {
    private java.lang.String lat;

    private java.lang.String lng;

    public GPSType() {
    }

    public GPSType(
           java.lang.String lat,
           java.lang.String lng) {
           this.lat = lat;
           this.lng = lng;
    }


    /**
     * Gets the lat value for this GPSType.
     * 
     * @return lat
     */
    public java.lang.String getLat() {
        return lat;
    }


    /**
     * Sets the lat value for this GPSType.
     * 
     * @param lat
     */
    public void setLat(java.lang.String lat) {
        this.lat = lat;
    }


    /**
     * Gets the lng value for this GPSType.
     * 
     * @return lng
     */
    public java.lang.String getLng() {
        return lng;
    }


    /**
     * Sets the lng value for this GPSType.
     * 
     * @param lng
     */
    public void setLng(java.lang.String lng) {
        this.lng = lng;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GPSType)) return false;
        GPSType other = (GPSType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.lat==null && other.getLat()==null) || 
             (this.lat!=null &&
              this.lat.equals(other.getLat()))) &&
            ((this.lng==null && other.getLng()==null) || 
             (this.lng!=null &&
              this.lng.equals(other.getLng())));
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
        if (getLat() != null) {
            _hashCode += getLat().hashCode();
        }
        if (getLng() != null) {
            _hashCode += getLng().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GPSType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:Demo", "GPSType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lat");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Lat"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lng");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Lng"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
