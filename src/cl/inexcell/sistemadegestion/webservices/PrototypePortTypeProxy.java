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
  
  
}