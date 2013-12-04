/**
 * RequestOutsidePlant.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cl.inexcell.sistemadegestion.webservices;

@SuppressWarnings("serial")
public class RequestOutsidePlant  implements java.io.Serializable {
    private cl.inexcell.sistemadegestion.webservices.OperationType operation;

    private cl.inexcell.sistemadegestion.webservices.ServiceOutsidePlantIn service;

    public RequestOutsidePlant() {
    }

    public RequestOutsidePlant(
           cl.inexcell.sistemadegestion.webservices.OperationType operation,
           cl.inexcell.sistemadegestion.webservices.ServiceOutsidePlantIn service) {
           this.operation = operation;
           this.service = service;
    }


    /**
     * Gets the operation value for this RequestOutsidePlant.
     * 
     * @return operation
     */
    public cl.inexcell.sistemadegestion.webservices.OperationType getOperation() {
        return operation;
    }


    /**
     * Sets the operation value for this RequestOutsidePlant.
     * 
     * @param operation
     */
    public void setOperation(cl.inexcell.sistemadegestion.webservices.OperationType operation) {
        this.operation = operation;
    }


    /**
     * Gets the service value for this RequestOutsidePlant.
     * 
     * @return service
     */
    public cl.inexcell.sistemadegestion.webservices.ServiceOutsidePlantIn getService() {
        return service;
    }


    /**
     * Sets the service value for this RequestOutsidePlant.
     * 
     * @param service
     */
    public void setService(cl.inexcell.sistemadegestion.webservices.ServiceOutsidePlantIn service) {
        this.service = service;
    }

    private java.lang.Object __equalsCalc = null;
    @SuppressWarnings("unused")
	public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof RequestOutsidePlant)) return false;
        RequestOutsidePlant other = (RequestOutsidePlant) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.operation==null && other.getOperation()==null) || 
             (this.operation!=null &&
              this.operation.equals(other.getOperation()))) &&
            ((this.service==null && other.getService()==null) || 
             (this.service!=null &&
              this.service.equals(other.getService())));
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
        if (getOperation() != null) {
            _hashCode += getOperation().hashCode();
        }
        if (getService() != null) {
            _hashCode += getService().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(RequestOutsidePlant.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:Demo", "RequestOutsidePlant"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("operation");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Operation"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:Demo", "OperationType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("service");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Service"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:Demo", "ServiceOutsidePlantIn"));
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
