/**
 * PrototypePortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cl.inexcell.sistemadegestion.webservices;

public interface PrototypePortType extends java.rmi.Remote {

    /**
     * Test.
     */
    public cl.inexcell.sistemadegestion.webservices.ResponseCustomer customer(cl.inexcell.sistemadegestion.webservices.RequestCustomer requestCustomer) throws java.rmi.RemoteException;

    /**
     * Test.
     */
    public cl.inexcell.sistemadegestion.webservices.ResponseVendor vendor(cl.inexcell.sistemadegestion.webservices.RequestVendor requestVendor) throws java.rmi.RemoteException;

    /**
     * Test.
     */
    public cl.inexcell.sistemadegestion.webservices.ResponseModel model(cl.inexcell.sistemadegestion.webservices.RequestModel requestModel) throws java.rmi.RemoteException;

    /**
     * Test.
     */
    public cl.inexcell.sistemadegestion.webservices.ResponseInventoryUpdate inventoryUpdate(cl.inexcell.sistemadegestion.webservices.RequestInventoryUpdate requestInventoryUpdate) throws java.rmi.RemoteException;

    /**
     * Test.
     */
    public cl.inexcell.sistemadegestion.webservices.ResponseOutsidePlant outsidePlant(cl.inexcell.sistemadegestion.webservices.RequestOutsidePlant requestOutsidePlant) throws java.rmi.RemoteException;

    /**
     * Test.
     */
    public cl.inexcell.sistemadegestion.webservices.ResponseOutsidePlantUpgrade outsidePlantUpgrade(cl.inexcell.sistemadegestion.webservices.RequestOutsidePlantUpgrade requestOutsidePlantUpgrade) throws java.rmi.RemoteException;

    /**
     * Test.
     */
    public cl.inexcell.sistemadegestion.webservices.ResponseCertifyDSL certifyDSL(cl.inexcell.sistemadegestion.webservices.RequestCertifyDSL requestCertifyDSL) throws java.rmi.RemoteException;

    /**
     * Test.
     */
    public cl.inexcell.sistemadegestion.webservices.ResponseNotification3G notification3G(cl.inexcell.sistemadegestion.webservices.RequestNotification3G requestNotification3G) throws java.rmi.RemoteException;

    /**
     * Test.
     */
    public cl.inexcell.sistemadegestion.webservices.ResponseLocation location(cl.inexcell.sistemadegestion.webservices.RequestLocation requestLocation) throws java.rmi.RemoteException;

    /**
     * Test.
     */
    public cl.inexcell.sistemadegestion.webservices.ResponseNeighborNode neighborNode(cl.inexcell.sistemadegestion.webservices.RequestNeighborNode requestNeighborNode) throws java.rmi.RemoteException;
}
