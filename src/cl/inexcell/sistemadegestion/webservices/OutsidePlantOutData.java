/**
 * OutsidePlantOutData.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cl.inexcell.sistemadegestion.webservices;

public class OutsidePlantOutData  implements java.io.Serializable {
    private cl.inexcell.sistemadegestion.webservices.ElementType[] element;

    private cl.inexcell.sistemadegestion.webservices.ReturnType _return;

    public OutsidePlantOutData() {
    }

    public OutsidePlantOutData(
           cl.inexcell.sistemadegestion.webservices.ElementType[] element,
           cl.inexcell.sistemadegestion.webservices.ReturnType _return) {
           this.element = element;
           this._return = _return;
    }


    /**
     * Gets the element value for this OutsidePlantOutData.
     * 
     * @return element
     */
    public cl.inexcell.sistemadegestion.webservices.ElementType[] getElement() {
        return element;
    }


    /**
     * Sets the element value for this OutsidePlantOutData.
     * 
     * @param element
     */
    public void setElement(cl.inexcell.sistemadegestion.webservices.ElementType[] element) {
        this.element = element;
    }

    public cl.inexcell.sistemadegestion.webservices.ElementType getElement(int i) {
        return this.element[i];
    }

    public void setElement(int i, cl.inexcell.sistemadegestion.webservices.ElementType _value) {
        this.element[i] = _value;
    }


    /**
     * Gets the _return value for this OutsidePlantOutData.
     * 
     * @return _return
     */
    public cl.inexcell.sistemadegestion.webservices.ReturnType get_return() {
        return _return;
    }


    /**
     * Sets the _return value for this OutsidePlantOutData.
     * 
     * @param _return
     */
    public void set_return(cl.inexcell.sistemadegestion.webservices.ReturnType _return) {
        this._return = _return;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof OutsidePlantOutData)) return false;
        OutsidePlantOutData other = (OutsidePlantOutData) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.element==null && other.getElement()==null) || 
             (this.element!=null &&
              java.util.Arrays.equals(this.element, other.getElement()))) &&
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
        if (getElement() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getElement());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getElement(), i);
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
        new org.apache.axis.description.TypeDesc(OutsidePlantOutData.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:Demo", "OutsidePlantOutData"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("element");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Element"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:Demo", "ElementType"));
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
