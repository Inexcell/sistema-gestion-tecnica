/**
 * ServiceNotification3GIn.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cl.inexcell.sistemadegestion.webservices;

@SuppressWarnings("serial")
public class ServiceNotification3GIn  implements java.io.Serializable {
    private cl.inexcell.sistemadegestion.webservices.Notification3GIn notification3G;

    public ServiceNotification3GIn() {
    }

    public ServiceNotification3GIn(
           cl.inexcell.sistemadegestion.webservices.Notification3GIn notification3G) {
           this.notification3G = notification3G;
    }


    /**
     * Gets the notification3G value for this ServiceNotification3GIn.
     * 
     * @return notification3G
     */
    public cl.inexcell.sistemadegestion.webservices.Notification3GIn getNotification3G() {
        return notification3G;
    }


    /**
     * Sets the notification3G value for this ServiceNotification3GIn.
     * 
     * @param notification3G
     */
    public void setNotification3G(cl.inexcell.sistemadegestion.webservices.Notification3GIn notification3G) {
        this.notification3G = notification3G;
    }

    private java.lang.Object __equalsCalc = null;
    @SuppressWarnings("unused")
	public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ServiceNotification3GIn)) return false;
        ServiceNotification3GIn other = (ServiceNotification3GIn) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.notification3G==null && other.getNotification3G()==null) || 
             (this.notification3G!=null &&
              this.notification3G.equals(other.getNotification3G())));
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
        if (getNotification3G() != null) {
            _hashCode += getNotification3G().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ServiceNotification3GIn.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:Demo", "ServiceNotification3gIn"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("notification3G");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Notification3g"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:Demo", "Notification3gIn"));
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
