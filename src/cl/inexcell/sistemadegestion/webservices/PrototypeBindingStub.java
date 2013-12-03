/**
 * PrototypeBindingStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cl.inexcell.sistemadegestion.webservices;

public class PrototypeBindingStub extends org.apache.axis.client.Stub implements cl.inexcell.sistemadegestion.webservices.PrototypePortType {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[5];
        _initOperationDesc1();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("Customer");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "RequestCustomer"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:Demo", "RequestCustomer"), cl.inexcell.sistemadegestion.webservices.RequestCustomer.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("urn:Demo", "ResponseCustomer"));
        oper.setReturnClass(cl.inexcell.sistemadegestion.webservices.ResponseCustomer.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "ResponseCustomer"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("Vendor");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "RequestVendor"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:Demo", "RequestVendor"), cl.inexcell.sistemadegestion.webservices.RequestVendor.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("urn:Demo", "ResponseVendor"));
        oper.setReturnClass(cl.inexcell.sistemadegestion.webservices.ResponseVendor.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "ResponseVendor"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[1] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("Model");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "RequestModel"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:Demo", "RequestModel"), cl.inexcell.sistemadegestion.webservices.RequestModel.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("urn:Demo", "ResponseModel"));
        oper.setReturnClass(cl.inexcell.sistemadegestion.webservices.ResponseModel.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "ResponseModel"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[2] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("InventoryUpdate");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "RequestInventoryUpdate"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:Demo", "RequestInventoryUpdate"), cl.inexcell.sistemadegestion.webservices.RequestInventoryUpdate.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("urn:Demo", "ResponseInventoryUpdate"));
        oper.setReturnClass(cl.inexcell.sistemadegestion.webservices.ResponseInventoryUpdate.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "ResponseInventoryUpdate"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[3] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("OutsidePlant");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "RequestOutsidePlant"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:Demo", "RequestOutsidePlant"), cl.inexcell.sistemadegestion.webservices.RequestOutsidePlant.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("urn:Demo", "ResponseOutsidePlant"));
        oper.setReturnClass(cl.inexcell.sistemadegestion.webservices.ResponseOutsidePlant.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "ResponseOutsidePlant"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[4] = oper;

    }

    public PrototypeBindingStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public PrototypeBindingStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public PrototypeBindingStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
        if (service == null) {
            super.service = new org.apache.axis.client.Service();
        } else {
            super.service = service;
        }
        ((org.apache.axis.client.Service)super.service).setTypeMappingVersion("1.2");
            java.lang.Class cls;
            javax.xml.namespace.QName qName;
            javax.xml.namespace.QName qName2;
            java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            java.lang.Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            java.lang.Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            java.lang.Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            java.lang.Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            java.lang.Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
            java.lang.Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
            qName = new javax.xml.namespace.QName("urn:Demo", "CPE");
            cachedSerQNames.add(qName);
            cls = cl.inexcell.sistemadegestion.webservices.CPE.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:Demo", "CustomerIn");
            cachedSerQNames.add(qName);
            cls = cl.inexcell.sistemadegestion.webservices.CustomerIn.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:Demo", "CustomerInData");
            cachedSerQNames.add(qName);
            cls = cl.inexcell.sistemadegestion.webservices.CustomerInData.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:Demo", "CustomerOut");
            cachedSerQNames.add(qName);
            cls = cl.inexcell.sistemadegestion.webservices.CustomerOut.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:Demo", "CustomerOutData");
            cachedSerQNames.add(qName);
            cls = cl.inexcell.sistemadegestion.webservices.CustomerOutData.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:Demo", "ElementType");
            cachedSerQNames.add(qName);
            cls = cl.inexcell.sistemadegestion.webservices.ElementType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:Demo", "GPSType");
            cachedSerQNames.add(qName);
            cls = cl.inexcell.sistemadegestion.webservices.GPSType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:Demo", "InventoryUpdateIn");
            cachedSerQNames.add(qName);
            cls = cl.inexcell.sistemadegestion.webservices.InventoryUpdateIn.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:Demo", "InventoryUpdateInData");
            cachedSerQNames.add(qName);
            cls = cl.inexcell.sistemadegestion.webservices.InventoryUpdateInData.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:Demo", "InventoryUpdateOut");
            cachedSerQNames.add(qName);
            cls = cl.inexcell.sistemadegestion.webservices.InventoryUpdateOut.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:Demo", "InventoryUpdateOutData");
            cachedSerQNames.add(qName);
            cls = cl.inexcell.sistemadegestion.webservices.InventoryUpdateOutData.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:Demo", "Model");
            cachedSerQNames.add(qName);
            cls = java.lang.String[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string");
            qName2 = new javax.xml.namespace.QName("", "Name");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("urn:Demo", "ModelIn");
            cachedSerQNames.add(qName);
            cls = cl.inexcell.sistemadegestion.webservices.ModelIn.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:Demo", "ModelInData");
            cachedSerQNames.add(qName);
            cls = cl.inexcell.sistemadegestion.webservices.ModelInData.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:Demo", "ModelOut");
            cachedSerQNames.add(qName);
            cls = cl.inexcell.sistemadegestion.webservices.ModelOut.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:Demo", "ModelOutData");
            cachedSerQNames.add(qName);
            cls = cl.inexcell.sistemadegestion.webservices.ModelOutData.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:Demo", "OperationType");
            cachedSerQNames.add(qName);
            cls = cl.inexcell.sistemadegestion.webservices.OperationType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:Demo", "OutsidePlantIn");
            cachedSerQNames.add(qName);
            cls = cl.inexcell.sistemadegestion.webservices.OutsidePlantIn.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:Demo", "OutsidePlantInData");
            cachedSerQNames.add(qName);
            cls = cl.inexcell.sistemadegestion.webservices.OutsidePlantInData.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:Demo", "OutsidePlantOut");
            cachedSerQNames.add(qName);
            cls = cl.inexcell.sistemadegestion.webservices.OutsidePlantOut.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:Demo", "OutsidePlantOutData");
            cachedSerQNames.add(qName);
            cls = cl.inexcell.sistemadegestion.webservices.OutsidePlantOutData.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:Demo", "RequestCustomer");
            cachedSerQNames.add(qName);
            cls = cl.inexcell.sistemadegestion.webservices.RequestCustomer.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:Demo", "RequestInventoryUpdate");
            cachedSerQNames.add(qName);
            cls = cl.inexcell.sistemadegestion.webservices.RequestInventoryUpdate.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:Demo", "RequestModel");
            cachedSerQNames.add(qName);
            cls = cl.inexcell.sistemadegestion.webservices.RequestModel.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:Demo", "RequestOutsidePlant");
            cachedSerQNames.add(qName);
            cls = cl.inexcell.sistemadegestion.webservices.RequestOutsidePlant.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:Demo", "RequestVendor");
            cachedSerQNames.add(qName);
            cls = cl.inexcell.sistemadegestion.webservices.RequestVendor.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:Demo", "ResponseCustomer");
            cachedSerQNames.add(qName);
            cls = cl.inexcell.sistemadegestion.webservices.ResponseCustomer.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:Demo", "ResponseInventoryUpdate");
            cachedSerQNames.add(qName);
            cls = cl.inexcell.sistemadegestion.webservices.ResponseInventoryUpdate.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:Demo", "ResponseModel");
            cachedSerQNames.add(qName);
            cls = cl.inexcell.sistemadegestion.webservices.ResponseModel.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:Demo", "ResponseOutsidePlant");
            cachedSerQNames.add(qName);
            cls = cl.inexcell.sistemadegestion.webservices.ResponseOutsidePlant.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:Demo", "ResponseVendor");
            cachedSerQNames.add(qName);
            cls = cl.inexcell.sistemadegestion.webservices.ResponseVendor.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:Demo", "ReturnType");
            cachedSerQNames.add(qName);
            cls = cl.inexcell.sistemadegestion.webservices.ReturnType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:Demo", "ServiceCustomerIn");
            cachedSerQNames.add(qName);
            cls = cl.inexcell.sistemadegestion.webservices.ServiceCustomerIn.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:Demo", "ServiceCustomerOut");
            cachedSerQNames.add(qName);
            cls = cl.inexcell.sistemadegestion.webservices.ServiceCustomerOut.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:Demo", "ServiceInventoryUpdateIn");
            cachedSerQNames.add(qName);
            cls = cl.inexcell.sistemadegestion.webservices.ServiceInventoryUpdateIn.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:Demo", "ServiceInventoryUpdateOut");
            cachedSerQNames.add(qName);
            cls = cl.inexcell.sistemadegestion.webservices.ServiceInventoryUpdateOut.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:Demo", "ServiceModelIn");
            cachedSerQNames.add(qName);
            cls = cl.inexcell.sistemadegestion.webservices.ServiceModelIn.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:Demo", "ServiceModelOut");
            cachedSerQNames.add(qName);
            cls = cl.inexcell.sistemadegestion.webservices.ServiceModelOut.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:Demo", "ServiceOutsidePlantIn");
            cachedSerQNames.add(qName);
            cls = cl.inexcell.sistemadegestion.webservices.ServiceOutsidePlantIn.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:Demo", "ServiceOutsidePlantOut");
            cachedSerQNames.add(qName);
            cls = cl.inexcell.sistemadegestion.webservices.ServiceOutsidePlantOut.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:Demo", "ServiceVendorIn");
            cachedSerQNames.add(qName);
            cls = cl.inexcell.sistemadegestion.webservices.ServiceVendorIn.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:Demo", "ServiceVendorOut");
            cachedSerQNames.add(qName);
            cls = cl.inexcell.sistemadegestion.webservices.ServiceVendorOut.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:Demo", "Vendor");
            cachedSerQNames.add(qName);
            cls = java.lang.String[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string");
            qName2 = new javax.xml.namespace.QName("", "Name");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("urn:Demo", "VendorIn");
            cachedSerQNames.add(qName);
            cls = cl.inexcell.sistemadegestion.webservices.VendorIn.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:Demo", "VendorInData");
            cachedSerQNames.add(qName);
            cls = cl.inexcell.sistemadegestion.webservices.VendorInData.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:Demo", "VendorOut");
            cachedSerQNames.add(qName);
            cls = cl.inexcell.sistemadegestion.webservices.VendorOut.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:Demo", "VendorOutData");
            cachedSerQNames.add(qName);
            cls = cl.inexcell.sistemadegestion.webservices.VendorOutData.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

    }

    protected org.apache.axis.client.Call createCall() throws java.rmi.RemoteException {
        try {
            org.apache.axis.client.Call _call = super._createCall();
            if (super.maintainSessionSet) {
                _call.setMaintainSession(super.maintainSession);
            }
            if (super.cachedUsername != null) {
                _call.setUsername(super.cachedUsername);
            }
            if (super.cachedPassword != null) {
                _call.setPassword(super.cachedPassword);
            }
            if (super.cachedEndpoint != null) {
                _call.setTargetEndpointAddress(super.cachedEndpoint);
            }
            if (super.cachedTimeout != null) {
                _call.setTimeout(super.cachedTimeout);
            }
            if (super.cachedPortName != null) {
                _call.setPortName(super.cachedPortName);
            }
            java.util.Enumeration keys = super.cachedProperties.keys();
            while (keys.hasMoreElements()) {
                java.lang.String key = (java.lang.String) keys.nextElement();
                _call.setProperty(key, super.cachedProperties.get(key));
            }
            // All the type mapping information is registered
            // when the first call is made.
            // The type mapping information is actually registered in
            // the TypeMappingRegistry of the service, which
            // is the reason why registration is only needed for the first call.
            synchronized (this) {
                if (firstCall()) {
                    // must set encoding style before registering serializers
                    _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
                    _call.setEncodingStyle(org.apache.axis.Constants.URI_SOAP11_ENC);
                    for (int i = 0; i < cachedSerFactories.size(); ++i) {
                        java.lang.Class cls = (java.lang.Class) cachedSerClasses.get(i);
                        javax.xml.namespace.QName qName =
                                (javax.xml.namespace.QName) cachedSerQNames.get(i);
                        java.lang.Object x = cachedSerFactories.get(i);
                        if (x instanceof Class) {
                            java.lang.Class sf = (java.lang.Class)
                                 cachedSerFactories.get(i);
                            java.lang.Class df = (java.lang.Class)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                        else if (x instanceof javax.xml.rpc.encoding.SerializerFactory) {
                            org.apache.axis.encoding.SerializerFactory sf = (org.apache.axis.encoding.SerializerFactory)
                                 cachedSerFactories.get(i);
                            org.apache.axis.encoding.DeserializerFactory df = (org.apache.axis.encoding.DeserializerFactory)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                    }
                }
            }
            return _call;
        }
        catch (java.lang.Throwable _t) {
            throw new org.apache.axis.AxisFault("Failure trying to get the Call object", _t);
        }
    }

    public cl.inexcell.sistemadegestion.webservices.ResponseCustomer customer(cl.inexcell.sistemadegestion.webservices.RequestCustomer requestCustomer) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:Demo#Customer");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("urn:Demo", "Customer"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {requestCustomer});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cl.inexcell.sistemadegestion.webservices.ResponseCustomer) _resp;
            } catch (java.lang.Exception _exception) {
                return (cl.inexcell.sistemadegestion.webservices.ResponseCustomer) org.apache.axis.utils.JavaUtils.convert(_resp, cl.inexcell.sistemadegestion.webservices.ResponseCustomer.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public cl.inexcell.sistemadegestion.webservices.ResponseVendor vendor(cl.inexcell.sistemadegestion.webservices.RequestVendor requestVendor) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:Demo#Vendor");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("urn:Demo", "Vendor"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {requestVendor});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cl.inexcell.sistemadegestion.webservices.ResponseVendor) _resp;
            } catch (java.lang.Exception _exception) {
                return (cl.inexcell.sistemadegestion.webservices.ResponseVendor) org.apache.axis.utils.JavaUtils.convert(_resp, cl.inexcell.sistemadegestion.webservices.ResponseVendor.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public cl.inexcell.sistemadegestion.webservices.ResponseModel model(cl.inexcell.sistemadegestion.webservices.RequestModel requestModel) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[2]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:Demo#Model");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("urn:Demo", "Model"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {requestModel});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cl.inexcell.sistemadegestion.webservices.ResponseModel) _resp;
            } catch (java.lang.Exception _exception) {
                return (cl.inexcell.sistemadegestion.webservices.ResponseModel) org.apache.axis.utils.JavaUtils.convert(_resp, cl.inexcell.sistemadegestion.webservices.ResponseModel.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public cl.inexcell.sistemadegestion.webservices.ResponseInventoryUpdate inventoryUpdate(cl.inexcell.sistemadegestion.webservices.RequestInventoryUpdate requestInventoryUpdate) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[3]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:Demo#InventoryUpdate");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("urn:Demo", "InventoryUpdate"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {requestInventoryUpdate});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cl.inexcell.sistemadegestion.webservices.ResponseInventoryUpdate) _resp;
            } catch (java.lang.Exception _exception) {
                return (cl.inexcell.sistemadegestion.webservices.ResponseInventoryUpdate) org.apache.axis.utils.JavaUtils.convert(_resp, cl.inexcell.sistemadegestion.webservices.ResponseInventoryUpdate.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public cl.inexcell.sistemadegestion.webservices.ResponseOutsidePlant outsidePlant(cl.inexcell.sistemadegestion.webservices.RequestOutsidePlant requestOutsidePlant) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[4]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:Demo#OutsidePlant");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("urn:Demo", "OutsidePlant"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {requestOutsidePlant});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (cl.inexcell.sistemadegestion.webservices.ResponseOutsidePlant) _resp;
            } catch (java.lang.Exception _exception) {
                return (cl.inexcell.sistemadegestion.webservices.ResponseOutsidePlant) org.apache.axis.utils.JavaUtils.convert(_resp, cl.inexcell.sistemadegestion.webservices.ResponseOutsidePlant.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

}
