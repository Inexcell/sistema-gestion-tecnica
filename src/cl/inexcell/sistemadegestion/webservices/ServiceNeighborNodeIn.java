/**
 * ServiceNeighborNodeIn.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cl.inexcell.sistemadegestion.webservices;

@SuppressWarnings("serial")
public class ServiceNeighborNodeIn  implements java.io.Serializable {
    private cl.inexcell.sistemadegestion.webservices.NeighborNodeIn neighborNode;

    public ServiceNeighborNodeIn() {
    }

    public ServiceNeighborNodeIn(
           cl.inexcell.sistemadegestion.webservices.NeighborNodeIn neighborNode) {
           this.neighborNode = neighborNode;
    }


    /**
     * Gets the neighborNode value for this ServiceNeighborNodeIn.
     * 
     * @return neighborNode
     */
    public cl.inexcell.sistemadegestion.webservices.NeighborNodeIn getNeighborNode() {
        return neighborNode;
    }


    /**
     * Sets the neighborNode value for this ServiceNeighborNodeIn.
     * 
     * @param neighborNode
     */
    public void setNeighborNode(cl.inexcell.sistemadegestion.webservices.NeighborNodeIn neighborNode) {
        this.neighborNode = neighborNode;
    }

    private java.lang.Object __equalsCalc = null;
    @SuppressWarnings("unused")
	public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ServiceNeighborNodeIn)) return false;
        ServiceNeighborNodeIn other = (ServiceNeighborNodeIn) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.neighborNode==null && other.getNeighborNode()==null) || 
             (this.neighborNode!=null &&
              this.neighborNode.equals(other.getNeighborNode())));
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
        if (getNeighborNode() != null) {
            _hashCode += getNeighborNode().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ServiceNeighborNodeIn.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:Demo", "ServiceNeighborNodeIn"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("neighborNode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "NeighborNode"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:Demo", "NeighborNodeIn"));
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
