/**
 * ServiceNotification3GOut.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cl.inexcell.sistemadegestion.webservices;

@SuppressWarnings("serial")
public class ServiceNotification3GOut  implements java.io.Serializable {
    private cl.inexcell.sistemadegestion.webservices.Notification3GOut notification3G;

    public ServiceNotification3GOut() {
    }

    public ServiceNotification3GOut(
           cl.inexcell.sistemadegestion.webservices.Notification3GOut notification3G) {
           this.notification3G = notification3G;
    }


    /**
     * Gets the notification3G value for this ServiceNotification3GOut.
     * 
     * @return notification3G
     */
    public cl.inexcell.sistemadegestion.webservices.Notification3GOut getNotification3G() {
        return notification3G;
    }


    /**
     * Sets the notification3G value for this ServiceNotification3GOut.
     * 
     * @param notification3G
     */
    public void setNotification3G(cl.inexcell.sistemadegestion.webservices.Notification3GOut notification3G) {
        this.notification3G = notification3G;
    }

    private java.lang.Object __equalsCalc = null;
    @SuppressWarnings("unused")
	public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ServiceNotification3GOut)) return false;
        ServiceNotification3GOut other = (ServiceNotification3GOut) obj;
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
        new org.apache.axis.description.TypeDesc(ServiceNotification3GOut.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:Demo", "ServiceNotification3gOut"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("notification3G");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Notification3g"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:Demo", "Notification3gOut"));
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
