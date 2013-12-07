/**
 * NodeType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cl.inexcell.sistemadegestion.webservices;

@SuppressWarnings("serial")
public class NodeType  implements java.io.Serializable {
    private java.lang.String id;

    private java.lang.String type;

    private cl.inexcell.sistemadegestion.webservices.GPSType gps;

    private java.lang.String addressStreet;

    private java.lang.String addressNumber;

    private java.lang.String addressCode;

    private cl.inexcell.sistemadegestion.webservices.FeasibilityType feasibility;

    private java.lang.String site;

    private java.lang.String cable;

    private java.lang.String cabinet;

    private java.lang.String pairFrom;

    private java.lang.String pairUntil;

    private java.lang.String pairOccupied;

    private java.lang.String pairVacant;

    private java.lang.String pairReserved;

    private java.lang.String pairBad;

    public NodeType() {
    }

    public NodeType(
           java.lang.String id,
           java.lang.String type,
           cl.inexcell.sistemadegestion.webservices.GPSType gps,
           java.lang.String addressStreet,
           java.lang.String addressNumber,
           java.lang.String addressCode,
           cl.inexcell.sistemadegestion.webservices.FeasibilityType feasibility,
           java.lang.String site,
           java.lang.String cable,
           java.lang.String cabinet,
           java.lang.String pairFrom,
           java.lang.String pairUntil,
           java.lang.String pairOccupied,
           java.lang.String pairVacant,
           java.lang.String pairReserved,
           java.lang.String pairBad) {
           this.id = id;
           this.type = type;
           this.gps = gps;
           this.addressStreet = addressStreet;
           this.addressNumber = addressNumber;
           this.addressCode = addressCode;
           this.feasibility = feasibility;
           this.site = site;
           this.cable = cable;
           this.cabinet = cabinet;
           this.pairFrom = pairFrom;
           this.pairUntil = pairUntil;
           this.pairOccupied = pairOccupied;
           this.pairVacant = pairVacant;
           this.pairReserved = pairReserved;
           this.pairBad = pairBad;
    }


    /**
     * Gets the id value for this NodeType.
     * 
     * @return id
     */
    public java.lang.String getId() {
        return id;
    }


    /**
     * Sets the id value for this NodeType.
     * 
     * @param id
     */
    public void setId(java.lang.String id) {
        this.id = id;
    }


    /**
     * Gets the type value for this NodeType.
     * 
     * @return type
     */
    public java.lang.String getType() {
        return type;
    }


    /**
     * Sets the type value for this NodeType.
     * 
     * @param type
     */
    public void setType(java.lang.String type) {
        this.type = type;
    }


    /**
     * Gets the gps value for this NodeType.
     * 
     * @return gps
     */
    public cl.inexcell.sistemadegestion.webservices.GPSType getGps() {
        return gps;
    }


    /**
     * Sets the gps value for this NodeType.
     * 
     * @param gps
     */
    public void setGps(cl.inexcell.sistemadegestion.webservices.GPSType gps) {
        this.gps = gps;
    }


    /**
     * Gets the addressStreet value for this NodeType.
     * 
     * @return addressStreet
     */
    public java.lang.String getAddressStreet() {
        return addressStreet;
    }


    /**
     * Sets the addressStreet value for this NodeType.
     * 
     * @param addressStreet
     */
    public void setAddressStreet(java.lang.String addressStreet) {
        this.addressStreet = addressStreet;
    }


    /**
     * Gets the addressNumber value for this NodeType.
     * 
     * @return addressNumber
     */
    public java.lang.String getAddressNumber() {
        return addressNumber;
    }


    /**
     * Sets the addressNumber value for this NodeType.
     * 
     * @param addressNumber
     */
    public void setAddressNumber(java.lang.String addressNumber) {
        this.addressNumber = addressNumber;
    }


    /**
     * Gets the addressCode value for this NodeType.
     * 
     * @return addressCode
     */
    public java.lang.String getAddressCode() {
        return addressCode;
    }


    /**
     * Sets the addressCode value for this NodeType.
     * 
     * @param addressCode
     */
    public void setAddressCode(java.lang.String addressCode) {
        this.addressCode = addressCode;
    }


    /**
     * Gets the feasibility value for this NodeType.
     * 
     * @return feasibility
     */
    public cl.inexcell.sistemadegestion.webservices.FeasibilityType getFeasibility() {
        return feasibility;
    }


    /**
     * Sets the feasibility value for this NodeType.
     * 
     * @param feasibility
     */
    public void setFeasibility(cl.inexcell.sistemadegestion.webservices.FeasibilityType feasibility) {
        this.feasibility = feasibility;
    }


    /**
     * Gets the site value for this NodeType.
     * 
     * @return site
     */
    public java.lang.String getSite() {
        return site;
    }


    /**
     * Sets the site value for this NodeType.
     * 
     * @param site
     */
    public void setSite(java.lang.String site) {
        this.site = site;
    }


    /**
     * Gets the cable value for this NodeType.
     * 
     * @return cable
     */
    public java.lang.String getCable() {
        return cable;
    }


    /**
     * Sets the cable value for this NodeType.
     * 
     * @param cable
     */
    public void setCable(java.lang.String cable) {
        this.cable = cable;
    }


    /**
     * Gets the cabinet value for this NodeType.
     * 
     * @return cabinet
     */
    public java.lang.String getCabinet() {
        return cabinet;
    }


    /**
     * Sets the cabinet value for this NodeType.
     * 
     * @param cabinet
     */
    public void setCabinet(java.lang.String cabinet) {
        this.cabinet = cabinet;
    }


    /**
     * Gets the pairFrom value for this NodeType.
     * 
     * @return pairFrom
     */
    public java.lang.String getPairFrom() {
        return pairFrom;
    }


    /**
     * Sets the pairFrom value for this NodeType.
     * 
     * @param pairFrom
     */
    public void setPairFrom(java.lang.String pairFrom) {
        this.pairFrom = pairFrom;
    }


    /**
     * Gets the pairUntil value for this NodeType.
     * 
     * @return pairUntil
     */
    public java.lang.String getPairUntil() {
        return pairUntil;
    }


    /**
     * Sets the pairUntil value for this NodeType.
     * 
     * @param pairUntil
     */
    public void setPairUntil(java.lang.String pairUntil) {
        this.pairUntil = pairUntil;
    }


    /**
     * Gets the pairOccupied value for this NodeType.
     * 
     * @return pairOccupied
     */
    public java.lang.String getPairOccupied() {
        return pairOccupied;
    }


    /**
     * Sets the pairOccupied value for this NodeType.
     * 
     * @param pairOccupied
     */
    public void setPairOccupied(java.lang.String pairOccupied) {
        this.pairOccupied = pairOccupied;
    }


    /**
     * Gets the pairVacant value for this NodeType.
     * 
     * @return pairVacant
     */
    public java.lang.String getPairVacant() {
        return pairVacant;
    }


    /**
     * Sets the pairVacant value for this NodeType.
     * 
     * @param pairVacant
     */
    public void setPairVacant(java.lang.String pairVacant) {
        this.pairVacant = pairVacant;
    }


    /**
     * Gets the pairReserved value for this NodeType.
     * 
     * @return pairReserved
     */
    public java.lang.String getPairReserved() {
        return pairReserved;
    }


    /**
     * Sets the pairReserved value for this NodeType.
     * 
     * @param pairReserved
     */
    public void setPairReserved(java.lang.String pairReserved) {
        this.pairReserved = pairReserved;
    }


    /**
     * Gets the pairBad value for this NodeType.
     * 
     * @return pairBad
     */
    public java.lang.String getPairBad() {
        return pairBad;
    }


    /**
     * Sets the pairBad value for this NodeType.
     * 
     * @param pairBad
     */
    public void setPairBad(java.lang.String pairBad) {
        this.pairBad = pairBad;
    }

    private java.lang.Object __equalsCalc = null;
    @SuppressWarnings("unused")
	public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof NodeType)) return false;
        NodeType other = (NodeType) obj;
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
            ((this.gps==null && other.getGps()==null) || 
             (this.gps!=null &&
              this.gps.equals(other.getGps()))) &&
            ((this.addressStreet==null && other.getAddressStreet()==null) || 
             (this.addressStreet!=null &&
              this.addressStreet.equals(other.getAddressStreet()))) &&
            ((this.addressNumber==null && other.getAddressNumber()==null) || 
             (this.addressNumber!=null &&
              this.addressNumber.equals(other.getAddressNumber()))) &&
            ((this.addressCode==null && other.getAddressCode()==null) || 
             (this.addressCode!=null &&
              this.addressCode.equals(other.getAddressCode()))) &&
            ((this.feasibility==null && other.getFeasibility()==null) || 
             (this.feasibility!=null &&
              this.feasibility.equals(other.getFeasibility()))) &&
            ((this.site==null && other.getSite()==null) || 
             (this.site!=null &&
              this.site.equals(other.getSite()))) &&
            ((this.cable==null && other.getCable()==null) || 
             (this.cable!=null &&
              this.cable.equals(other.getCable()))) &&
            ((this.cabinet==null && other.getCabinet()==null) || 
             (this.cabinet!=null &&
              this.cabinet.equals(other.getCabinet()))) &&
            ((this.pairFrom==null && other.getPairFrom()==null) || 
             (this.pairFrom!=null &&
              this.pairFrom.equals(other.getPairFrom()))) &&
            ((this.pairUntil==null && other.getPairUntil()==null) || 
             (this.pairUntil!=null &&
              this.pairUntil.equals(other.getPairUntil()))) &&
            ((this.pairOccupied==null && other.getPairOccupied()==null) || 
             (this.pairOccupied!=null &&
              this.pairOccupied.equals(other.getPairOccupied()))) &&
            ((this.pairVacant==null && other.getPairVacant()==null) || 
             (this.pairVacant!=null &&
              this.pairVacant.equals(other.getPairVacant()))) &&
            ((this.pairReserved==null && other.getPairReserved()==null) || 
             (this.pairReserved!=null &&
              this.pairReserved.equals(other.getPairReserved()))) &&
            ((this.pairBad==null && other.getPairBad()==null) || 
             (this.pairBad!=null &&
              this.pairBad.equals(other.getPairBad())));
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
        if (getGps() != null) {
            _hashCode += getGps().hashCode();
        }
        if (getAddressStreet() != null) {
            _hashCode += getAddressStreet().hashCode();
        }
        if (getAddressNumber() != null) {
            _hashCode += getAddressNumber().hashCode();
        }
        if (getAddressCode() != null) {
            _hashCode += getAddressCode().hashCode();
        }
        if (getFeasibility() != null) {
            _hashCode += getFeasibility().hashCode();
        }
        if (getSite() != null) {
            _hashCode += getSite().hashCode();
        }
        if (getCable() != null) {
            _hashCode += getCable().hashCode();
        }
        if (getCabinet() != null) {
            _hashCode += getCabinet().hashCode();
        }
        if (getPairFrom() != null) {
            _hashCode += getPairFrom().hashCode();
        }
        if (getPairUntil() != null) {
            _hashCode += getPairUntil().hashCode();
        }
        if (getPairOccupied() != null) {
            _hashCode += getPairOccupied().hashCode();
        }
        if (getPairVacant() != null) {
            _hashCode += getPairVacant().hashCode();
        }
        if (getPairReserved() != null) {
            _hashCode += getPairReserved().hashCode();
        }
        if (getPairBad() != null) {
            _hashCode += getPairBad().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(NodeType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:Demo", "NodeType"));
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
        elemField.setFieldName("gps");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Gps"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:Demo", "GPSType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("addressStreet");
        elemField.setXmlName(new javax.xml.namespace.QName("", "AddressStreet"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("addressNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("", "AddressNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("addressCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "AddressCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("feasibility");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Feasibility"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:Demo", "FeasibilityType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("site");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Site"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cable");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Cable"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cabinet");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Cabinet"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pairFrom");
        elemField.setXmlName(new javax.xml.namespace.QName("", "PairFrom"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pairUntil");
        elemField.setXmlName(new javax.xml.namespace.QName("", "PairUntil"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pairOccupied");
        elemField.setXmlName(new javax.xml.namespace.QName("", "PairOccupied"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pairVacant");
        elemField.setXmlName(new javax.xml.namespace.QName("", "PairVacant"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pairReserved");
        elemField.setXmlName(new javax.xml.namespace.QName("", "PairReserved"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pairBad");
        elemField.setXmlName(new javax.xml.namespace.QName("", "PairBad"));
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
