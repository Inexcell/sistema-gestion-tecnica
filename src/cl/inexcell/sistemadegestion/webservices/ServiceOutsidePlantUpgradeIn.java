/**
 * ServiceOutsidePlantUpgradeIn.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cl.inexcell.sistemadegestion.webservices;

@SuppressWarnings("serial")
public class ServiceOutsidePlantUpgradeIn  implements java.io.Serializable {
    private cl.inexcell.sistemadegestion.webservices.OutsidePlantUpgradeIn outsidePlantUpgrade;

    public ServiceOutsidePlantUpgradeIn() {
    }

    public ServiceOutsidePlantUpgradeIn(
           cl.inexcell.sistemadegestion.webservices.OutsidePlantUpgradeIn outsidePlantUpgrade) {
           this.outsidePlantUpgrade = outsidePlantUpgrade;
    }


    /**
     * Gets the outsidePlantUpgrade value for this ServiceOutsidePlantUpgradeIn.
     * 
     * @return outsidePlantUpgrade
     */
    public cl.inexcell.sistemadegestion.webservices.OutsidePlantUpgradeIn getOutsidePlantUpgrade() {
        return outsidePlantUpgrade;
    }


    /**
     * Sets the outsidePlantUpgrade value for this ServiceOutsidePlantUpgradeIn.
     * 
     * @param outsidePlantUpgrade
     */
    public void setOutsidePlantUpgrade(cl.inexcell.sistemadegestion.webservices.OutsidePlantUpgradeIn outsidePlantUpgrade) {
        this.outsidePlantUpgrade = outsidePlantUpgrade;
    }

    private java.lang.Object __equalsCalc = null;
    @SuppressWarnings("unused")
	public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ServiceOutsidePlantUpgradeIn)) return false;
        ServiceOutsidePlantUpgradeIn other = (ServiceOutsidePlantUpgradeIn) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.outsidePlantUpgrade==null && other.getOutsidePlantUpgrade()==null) || 
             (this.outsidePlantUpgrade!=null &&
              this.outsidePlantUpgrade.equals(other.getOutsidePlantUpgrade())));
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
        if (getOutsidePlantUpgrade() != null) {
            _hashCode += getOutsidePlantUpgrade().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ServiceOutsidePlantUpgradeIn.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:Demo", "ServiceOutsidePlantUpgradeIn"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("outsidePlantUpgrade");
        elemField.setXmlName(new javax.xml.namespace.QName("", "OutsidePlantUpgrade"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:Demo", "OutsidePlantUpgradeIn"));
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
