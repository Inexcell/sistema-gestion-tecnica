/**
 * ElementPlantUpgradeType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cl.inexcell.sistemadegestion.webservices;

@SuppressWarnings("serial")
public class ElementPlantUpgradeType  implements java.io.Serializable {
    private java.lang.String id;

    private java.lang.String type;

    private java.lang.String value;

    private cl.inexcell.sistemadegestion.webservices.GPSType gps;

    private java.lang.String picture;

    public ElementPlantUpgradeType() {
    }

    public ElementPlantUpgradeType(
           java.lang.String id,
           java.lang.String type,
           java.lang.String value,
           cl.inexcell.sistemadegestion.webservices.GPSType gps,
           java.lang.String picture) {
           this.id = id;
           this.type = type;
           this.value = value;
           this.gps = gps;
           this.picture = picture;
    }


    /**
     * Gets the id value for this ElementPlantUpgradeType.
     * 
     * @return id
     */
    public java.lang.String getId() {
        return id;
    }


    /**
     * Sets the id value for this ElementPlantUpgradeType.
     * 
     * @param id
     */
    public void setId(java.lang.String id) {
        this.id = id;
    }


    /**
     * Gets the type value for this ElementPlantUpgradeType.
     * 
     * @return type
     */
    public java.lang.String getType() {
        return type;
    }


    /**
     * Sets the type value for this ElementPlantUpgradeType.
     * 
     * @param type
     */
    public void setType(java.lang.String type) {
        this.type = type;
    }


    /**
     * Gets the value value for this ElementPlantUpgradeType.
     * 
     * @return value
     */
    public java.lang.String getValue() {
        return value;
    }


    /**
     * Sets the value value for this ElementPlantUpgradeType.
     * 
     * @param value
     */
    public void setValue(java.lang.String value) {
        this.value = value;
    }


    /**
     * Gets the gps value for this ElementPlantUpgradeType.
     * 
     * @return gps
     */
    public cl.inexcell.sistemadegestion.webservices.GPSType getGps() {
        return gps;
    }


    /**
     * Sets the gps value for this ElementPlantUpgradeType.
     * 
     * @param gps
     */
    public void setGps(cl.inexcell.sistemadegestion.webservices.GPSType gps) {
        this.gps = gps;
    }


    /**
     * Gets the picture value for this ElementPlantUpgradeType.
     * 
     * @return picture
     */
    public java.lang.String getPicture() {
        return picture;
    }


    /**
     * Sets the picture value for this ElementPlantUpgradeType.
     * 
     * @param picture
     */
    public void setPicture(java.lang.String picture) {
        this.picture = picture;
    }

    private java.lang.Object __equalsCalc = null;
    @SuppressWarnings("unused")
	public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ElementPlantUpgradeType)) return false;
        ElementPlantUpgradeType other = (ElementPlantUpgradeType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.id==null && other.getId()==null) || 
             (this.id!=null &&
              this.id.equals(other.getId()))) &&
            ((this.type==null && other.getType()==null) || 
             (this.type!=null &&
              this.type.equals(other.getType()))) &&
            ((this.value==null && other.getValue()==null) || 
             (this.value!=null &&
              this.value.equals(other.getValue()))) &&
            ((this.gps==null && other.getGps()==null) || 
             (this.gps!=null &&
              this.gps.equals(other.getGps()))) &&
            ((this.picture==null && other.getPicture()==null) || 
             (this.picture!=null &&
              this.picture.equals(other.getPicture())));
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
        if (getId() != null) {
            _hashCode += getId().hashCode();
        }
        if (getType() != null) {
            _hashCode += getType().hashCode();
        }
        if (getValue() != null) {
            _hashCode += getValue().hashCode();
        }
        if (getGps() != null) {
            _hashCode += getGps().hashCode();
        }
        if (getPicture() != null) {
            _hashCode += getPicture().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ElementPlantUpgradeType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:Demo", "ElementPlantUpgradeType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("type");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Type"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("value");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Value"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("gps");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Gps"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:Demo", "GPSType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("picture");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Picture"));
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