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
}
