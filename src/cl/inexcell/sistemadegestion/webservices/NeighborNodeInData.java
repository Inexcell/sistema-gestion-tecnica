/**
 * NeighborNodeInData.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cl.inexcell.sistemadegestion.webservices;

@SuppressWarnings("serial")
public class NeighborNodeInData  implements java.io.Serializable {
    private cl.inexcell.sistemadegestion.webservices.GPSType gps;

    public NeighborNodeInData() {
    }

    public NeighborNodeInData(
           cl.inexcell.sistemadegestion.webservices.GPSType gps) {
           this.gps = gps;
    }


    /**
     * Gets the gps value for this NeighborNodeInData.
     * 
     * @return gps
     */
    public cl.inexcell.sistemadegestion.webservices.GPSType getGps() {
        return gps;
    }


    /**
     * Sets the gps value for this NeighborNodeInData.
     * 
     * @param gps
     */
    public void setGps(cl.inexcell.sistemadegestion.webservices.GPSType gps) {
        this.gps = gps;
    }

    private java.lang.Object __equalsCalc = null;
    @SuppressWarnings("unused")
	public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof NeighborNodeInData)) return false;
        NeighborNodeInData other = (NeighborNodeInData) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.gps==null && other.getGps()==null) || 
             (this.gps!=null &&
              this.gps.equals(other.getGps())));
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
        if (getGps() != null) {
            _hashCode += getGps().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(NeighborNodeInData.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:Demo", "NeighborNodeInData"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("gps");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Gps"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:Demo", "GPSType"));
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
