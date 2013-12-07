/**
 * NeighborNodeOutData.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cl.inexcell.sistemadegestion.webservices;

@SuppressWarnings("serial")
public class NeighborNodeOutData  implements java.io.Serializable {
    private cl.inexcell.sistemadegestion.webservices.NodeType[] node;

    private cl.inexcell.sistemadegestion.webservices.ReturnType _return;

    public NeighborNodeOutData() {
    }

    public NeighborNodeOutData(
           cl.inexcell.sistemadegestion.webservices.NodeType[] node,
           cl.inexcell.sistemadegestion.webservices.ReturnType _return) {
           this.node = node;
           this._return = _return;
    }


    /**
     * Gets the node value for this NeighborNodeOutData.
     * 
     * @return node
     */
    public cl.inexcell.sistemadegestion.webservices.NodeType[] getNode() {
        return node;
    }


    /**
     * Sets the node value for this NeighborNodeOutData.
     * 
     * @param node
     */
    public void setNode(cl.inexcell.sistemadegestion.webservices.NodeType[] node) {
        this.node = node;
    }

    public cl.inexcell.sistemadegestion.webservices.NodeType getNode(int i) {
        return this.node[i];
    }

    public void setNode(int i, cl.inexcell.sistemadegestion.webservices.NodeType _value) {
        this.node[i] = _value;
    }


    /**
     * Gets the _return value for this NeighborNodeOutData.
     * 
     * @return _return
     */
    public cl.inexcell.sistemadegestion.webservices.ReturnType get_return() {
        return _return;
    }


    /**
     * Sets the _return value for this NeighborNodeOutData.
     * 
     * @param _return
     */
    public void set_return(cl.inexcell.sistemadegestion.webservices.ReturnType _return) {
        this._return = _return;
    }

    private java.lang.Object __equalsCalc = null;
    @SuppressWarnings("unused")
	public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof NeighborNodeOutData)) return false;
        NeighborNodeOutData other = (NeighborNodeOutData) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.node==null && other.getNode()==null) || 
             (this.node!=null &&
              java.util.Arrays.equals(this.node, other.getNode()))) &&
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
        if (getNode() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getNode());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getNode(), i);
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
        new org.apache.axis.description.TypeDesc(NeighborNodeOutData.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:Demo", "NeighborNodeOutData"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("node");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Node"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:Demo", "NodeType"));
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
