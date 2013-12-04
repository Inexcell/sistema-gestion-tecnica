/**
 * PrototypeLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cl.inexcell.sistemadegestion.webservices;

public class PrototypeLocator extends org.apache.axis.client.Service implements cl.inexcell.sistemadegestion.webservices.Prototype {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PrototypeLocator() {
    }


    public PrototypeLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public PrototypeLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for PrototypePort
    private java.lang.String PrototypePort_address = "http://pcba.telefonicachile.cl/smartphone/ws/shark.php";

    public java.lang.String getPrototypePortAddress() {
        return PrototypePort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String PrototypePortWSDDServiceName = "PrototypePort";

    public java.lang.String getPrototypePortWSDDServiceName() {
        return PrototypePortWSDDServiceName;
    }

    public void setPrototypePortWSDDServiceName(java.lang.String name) {
        PrototypePortWSDDServiceName = name;
    }

    public cl.inexcell.sistemadegestion.webservices.PrototypePortType getPrototypePort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(PrototypePort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getPrototypePort(endpoint);
    }

    public cl.inexcell.sistemadegestion.webservices.PrototypePortType getPrototypePort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            cl.inexcell.sistemadegestion.webservices.PrototypeBindingStub _stub = new cl.inexcell.sistemadegestion.webservices.PrototypeBindingStub(portAddress, this);
            _stub.setPortName(getPrototypePortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setPrototypePortEndpointAddress(java.lang.String address) {
        PrototypePort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    @SuppressWarnings("rawtypes")
	public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (cl.inexcell.sistemadegestion.webservices.PrototypePortType.class.isAssignableFrom(serviceEndpointInterface)) {
                cl.inexcell.sistemadegestion.webservices.PrototypeBindingStub _stub = new cl.inexcell.sistemadegestion.webservices.PrototypeBindingStub(new java.net.URL(PrototypePort_address), this);
                _stub.setPortName(getPrototypePortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    @SuppressWarnings("rawtypes")
	public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("PrototypePort".equals(inputPortName)) {
            return getPrototypePort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("urn:Demo", "Prototype");
    }

    @SuppressWarnings("rawtypes")
	private java.util.HashSet ports = null;

    @SuppressWarnings({ "rawtypes", "unchecked" })
	public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("urn:Demo", "PrototypePort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("PrototypePort".equals(portName)) {
            setPrototypePortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
