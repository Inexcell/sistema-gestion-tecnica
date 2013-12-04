/**
 * ServiceInventoryUpdateOut.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cl.inexcell.sistemadegestion.webservices;

@SuppressWarnings("serial")
public class ServiceInventoryUpdateOut  implements java.io.Serializable {
    private cl.inexcell.sistemadegestion.webservices.InventoryUpdateOut inventoryUpdate;

    public ServiceInventoryUpdateOut() {
    }

    public ServiceInventoryUpdateOut(
           cl.inexcell.sistemadegestion.webservices.InventoryUpdateOut inventoryUpdate) {
           this.inventoryUpdate = inventoryUpdate;
    }


    /**
     * Gets the inventoryUpdate value for this ServiceInventoryUpdateOut.
     * 
     * @return inventoryUpdate
     */
    public cl.inexcell.sistemadegestion.webservices.InventoryUpdateOut getInventoryUpdate() {
        return inventoryUpdate;
    }


    /**
     * Sets the inventoryUpdate value for this ServiceInventoryUpdateOut.
     * 
     * @param inventoryUpdate
     */
    public void setInventoryUpdate(cl.inexcell.sistemadegestion.webservices.InventoryUpdateOut inventoryUpdate) {
        this.inventoryUpdate = inventoryUpdate;
    }

    private java.lang.Object __equalsCalc = null;
    @SuppressWarnings("unused")
	public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ServiceInventoryUpdateOut)) return false;
        ServiceInventoryUpdateOut other = (ServiceInventoryUpdateOut) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.inventoryUpdate==null && other.getInventoryUpdate()==null) || 
             (this.inventoryUpdate!=null &&
              this.inventoryUpdate.equals(other.getInventoryUpdate())));
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
        if (getInventoryUpdate() != null) {
            _hashCode += getInventoryUpdate().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ServiceInventoryUpdateOut.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:Demo", "ServiceInventoryUpdateOut"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("inventoryUpdate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "InventoryUpdate"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:Demo", "InventoryUpdateOut"));
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
