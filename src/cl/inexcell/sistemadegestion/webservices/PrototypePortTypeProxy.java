package cl.inexcell.sistemadegestion.webservices;

public class PrototypePortTypeProxy implements cl.inexcell.sistemadegestion.webservices.PrototypePortType {
  private String _endpoint = null;
  private cl.inexcell.sistemadegestion.webservices.PrototypePortType prototypePortType = null;
  
  public PrototypePortTypeProxy() {
    _initPrototypePortTypeProxy();
  }
  
  public PrototypePortTypeProxy(String endpoint) {
    _endpoint = endpoint;
    _initPrototypePortTypeProxy();
  }
  
  private void _initPrototypePortTypeProxy() {
    try {
      prototypePortType = (new cl.inexcell.sistemadegestion.webservices.PrototypeLocator()).getPrototypePort();
      if (prototypePortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)prototypePortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)prototypePortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (prototypePortType != null)
      ((javax.xml.rpc.Stub)prototypePortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public cl.inexcell.sistemadegestion.webservices.PrototypePortType getPrototypePortType() {
    if (prototypePortType == null)
      _initPrototypePortTypeProxy();
    return prototypePortType;
  }
  
  public cl.inexcell.sistemadegestion.webservices.ResponseCustomer customer(cl.inexcell.sistemadegestion.webservices.RequestCustomer requestCustomer) throws java.rmi.RemoteException{
    if (prototypePortType == null)
      _initPrototypePortTypeProxy();
    return prototypePortType.customer(requestCustomer);
  }
  
  public cl.inexcell.sistemadegestion.webservices.ResponseVendor vendor(cl.inexcell.sistemadegestion.webservices.RequestVendor requestVendor) throws java.rmi.RemoteException{
    if (prototypePortType == null)
      _initPrototypePortTypeProxy();
    return prototypePortType.vendor(requestVendor);
  }
  
  public cl.inexcell.sistemadegestion.webservices.ResponseModel model(cl.inexcell.sistemadegestion.webservices.RequestModel requestModel) throws java.rmi.RemoteException{
    if (prototypePortType == null)
      _initPrototypePortTypeProxy();
    return prototypePortType.model(requestModel);
  }
  
  public cl.inexcell.sistemadegestion.webservices.ResponseInventoryUpdate inventoryUpdate(cl.inexcell.sistemadegestion.webservices.RequestInventoryUpdate requestInventoryUpdate) throws java.rmi.RemoteException{
    if (prototypePortType == null)
      _initPrototypePortTypeProxy();
    return prototypePortType.inventoryUpdate(requestInventoryUpdate);
  }
  
  public cl.inexcell.sistemadegestion.webservices.ResponseOutsidePlant outsidePlant(cl.inexcell.sistemadegestion.webservices.RequestOutsidePlant requestOutsidePlant) throws java.rmi.RemoteException{
    if (prototypePortType == null)
      _initPrototypePortTypeProxy();
    return prototypePortType.outsidePlant(requestOutsidePlant);
  }
  
  public cl.inexcell.sistemadegestion.webservices.ResponseOutsidePlantUpgrade outsidePlantUpgrade(cl.inexcell.sistemadegestion.webservices.RequestOutsidePlantUpgrade requestOutsidePlantUpgrade) throws java.rmi.RemoteException{
    if (prototypePortType == null)
      _initPrototypePortTypeProxy();
    return prototypePortType.outsidePlantUpgrade(requestOutsidePlantUpgrade);
  }
  
  public cl.inexcell.sistemadegestion.webservices.ResponseCertifyDSL certifyDSL(cl.inexcell.sistemadegestion.webservices.RequestCertifyDSL requestCertifyDSL) throws java.rmi.RemoteException{
    if (prototypePortType == null)
      _initPrototypePortTypeProxy();
    return prototypePortType.certifyDSL(requestCertifyDSL);
  }
  
  public cl.inexcell.sistemadegestion.webservices.ResponseNotification3G notification3G(cl.inexcell.sistemadegestion.webservices.RequestNotification3G requestNotification3G) throws java.rmi.RemoteException{
    if (prototypePortType == null)
      _initPrototypePortTypeProxy();
    return prototypePortType.notification3G(requestNotification3G);
  }
  
  public cl.inexcell.sistemadegestion.webservices.ResponseLocation location(cl.inexcell.sistemadegestion.webservices.RequestLocation requestLocation) throws java.rmi.RemoteException{
    if (prototypePortType == null)
      _initPrototypePortTypeProxy();
    return prototypePortType.location(requestLocation);
  }
  
  public cl.inexcell.sistemadegestion.webservices.ResponseNeighborNode neighborNode(cl.inexcell.sistemadegestion.webservices.RequestNeighborNode requestNeighborNode) throws java.rmi.RemoteException{
    if (prototypePortType == null)
      _initPrototypePortTypeProxy();
    return prototypePortType.neighborNode(requestNeighborNode);
  }
  
  
}