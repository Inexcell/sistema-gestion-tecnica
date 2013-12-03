/**
 * InventoryUpdateInData.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cl.inexcell.sistemadegestion.webservices;

public class InventoryUpdateInData  implements java.io.Serializable {
    private java.lang.String area;

    private java.lang.String phone;

    private java.lang.String CPEType;

    private java.lang.String CPEModel;

    public InventoryUpdateInData() {
    }

    public InventoryUpdateInData(
           java.lang.String area,
           java.lang.String phone,
           java.lang.String CPEType,
           java.lang.String CPEModel) {
           this.area = area;
           this.phone = phone;
           this.CPEType = CPEType;
           this.CPEModel = CPEModel;
    }


    /**
     * Gets the area value for this InventoryUpdateInData.
     * 
     * @return area
     */
    public java.lang.String getArea() {
        return area;
    }


    /**
     * Sets the area value for this InventoryUpdateInData.
     * 
     * @param area
     */
    public void setArea(java.lang.String area) {
        this.area = area;
    }


    /**
     * Gets the phone value for this InventoryUpdateInData.
     * 
     * @return phone
     */
    public java.lang.String getPhone() {
        return phone;
    }


    /**
     * Sets the phone value for this InventoryUpdateInData.
     * 
     * @param phone
     */
    public void setPhone(java.lang.String phone) {
        this.phone = phone;
    }


    /**
     * Gets the CPEType value for this InventoryUpdateInData.
     * 
     * @return CPEType
     */
    public java.lang.String getCPEType() {
        return CPEType;
    }


    /**
     * Sets the CPEType value for this InventoryUpdateInData.
     * 
     * @param CPEType
     */
    public void setCPEType(java.lang.String CPEType) {
        this.CPEType = CPEType;
    }


    /**
     * Gets the CPEModel value for this InventoryUpdateInData.
     * 
     * @return CPEModel
     */
    public java.lang.String getCPEModel() {
        return CPEModel;
    }


    /**
     * Sets the CPEModel value for this InventoryUpdateInData.
     * 
     * @param CPEModel
     */
    public void setCPEModel(java.lang.String CPEModel) {
        this.CPEModel = CPEModel;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof InventoryUpdateInData)) return false;
        InventoryUpdateInData other = (InventoryUpdateInData) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.area==null && other.getArea()==null) || 
             (this.area!=null &&
              this.area.equals(other.getArea()))) &&
            ((this.phone==null && other.getPhone()==null) || 
             (this.phone!=null &&
              this.phone.equals(other.getPhone()))) &&
            ((this.CPEType==null && other.getCPEType()==null) || 
             (this.CPEType!=null &&
              this.CPEType.equals(other.getCPEType()))) &&
            ((this.CPEModel==null && other.getCPEModel()==null) || 
             (this.CPEModel!=null &&
              this.CPEModel.equals(other.getCPEModel())));
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
        if (getArea() != null) {
            _hashCode += getArea().hashCode();
        }
        if (getPhone() != null) {
            _hashCode += getPhone().hashCode();
        }
        if (getCPEType() != null) {
            _hashCode += getCPEType().hashCode();
        }
        if (getCPEModel() != null) {
            _hashCode += getCPEModel().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(InventoryUpdateInData.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:Demo", "InventoryUpdateInData"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("area");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Area"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("phone");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Phone"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CPEType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "CPEType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CPEModel");
        elemField.setXmlName(new javax.xml.namespace.QName("", "CPEModel"));
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
