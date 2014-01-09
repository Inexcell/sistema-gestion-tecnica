package cl.inexcell.sistemadegestion;


import java.security.KeyStore;
import java.util.Date;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapSerializationEnvelope;

public class SoapRequestMovistar {
	
	private static			
	final String URL="https://pcba.telefonicachile.cl:443/smartphone/ws/shark.php";	
	//final String URL="http://cmn81.gratishosting.cl:80/shark_fijo.php";
	/*
	 * Clase Principal de Conexion SSL a WDSL
	 */
	
	private static HttpClient getNewHttpClient() {
        try {
            KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
            trustStore.load(null, null);

            SSLSocketFactory sf = new MySSLSocketFactory(trustStore);
            sf.setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);

            HttpParams params = new BasicHttpParams();
            HttpProtocolParams.setVersion(params, HttpVersion.HTTP_1_1);
            HttpProtocolParams.setContentCharset(params, HTTP.UTF_8);

            SchemeRegistry registry = new SchemeRegistry();
            registry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
            registry.register(new Scheme("https", sf, 443));

            ClientConnectionManager ccm = new ThreadSafeClientConnManager(params, registry);

            return new DefaultHttpClient(ccm, params);
        } catch (Exception e) {
            return new DefaultHttpClient();
        }
    }
	
	/*
	 * XML-001: Seleccionar Cliente
	 */
	 
	public static String getCustomer(String area, String phone, String IMEI, String IMSI) throws Exception {		
		final String SOAP_ACTION = "urn:Demo#Customer";
	    String response= null;
	    String xml = null;
	    
	    Date fecha = new Date();

	    HttpClient httpClient = getNewHttpClient();
	    HttpPost httpPost = new HttpPost(URL);

	    SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
	    envelope.encodingStyle = SoapSerializationEnvelope.ENC;
	    envelope.dotNet = false;		
		envelope.implicitTypes = true;
		
	    String bodyOut = 
	    		"<?xml version=\"1.0\" encoding=\"utf-8\"?><soapenv:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:urn=\"urn:Demo\">" +
				"<soapenv:Header/>" +
				"<soapenv:Body>" +
				 "<urn:Customer soapenv:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\">" +
				  	"<RequestCustomer xsi:type=\"urn:RequestCustomer\">" +
				  	"<Operation xsi:type=\"urn:OperationType\">" +
				    "<OperationCode xsi:type=\"xsd:string\">XML-001</OperationCode>" +
				     "<OperationId xsi:type=\"xsd:string\">1</OperationId>" +
				      "<!--Optional:-->" +
				       "<DateTime xsi:type=\"xsd:string\">"+fecha+"</DateTime>" +
				        "<!--Optional:-->" +
				         "<IdUser xsi:type=\"xsd:string\">1</IdUser>" +
				          "<IMEI xsi:type=\"xsd:string\">"+IMEI+"</IMEI>" +
				           "<IMSI xsi:type=\"xsd:string\">"+IMSI+"</IMSI>" +
				         "</Operation>" +
				         "<Service xsi:type=\"urn:ServiceCustomerIn\">" +
				            "<Customer xsi:type=\"urn:CustomerIn\">" +
				               "<Input xsi:type=\"urn:CustomerInData\">" +
				                  "<Area xsi:type=\"xsd:string\">" + area +"</Area>" +
				                  "<Phone xsi:type=\"xsd:string\">" + phone + "</Phone>" +
				               "</Input>" +
				            "</Customer>" +
				         "</Service>" +
				      "</RequestCustomer>" +
				   "</urn:Customer>" +
				"</soapenv:Body>" +
				"</soapenv:Envelope>";
	    xml = bodyOut;
	    StringEntity se = new StringEntity(xml, HTTP.UTF_8);
	    se.setContentType("text/xml");	    
	    httpPost.addHeader(SOAP_ACTION, URL);		
	    
	    httpPost.setEntity(se);
	    HttpResponse httpResponse = httpClient.execute(httpPost);
	    HttpEntity resEntity = httpResponse.getEntity();	    
	    response = EntityUtils.toString(resEntity);
	    return response;
	}
	
	
	/*
	 * XML-002: Seleccionar Fabricante de Equipo
	 */
	
	public static String getVendor(String CPE, String IMEI, String IMSI) throws Exception {		
		final String SOAP_ACTION = "urn:Demo#Vendor";
	    String response= null;
	    String xml = null;
	    
	    Date fecha = new Date();

	    HttpClient httpClient = getNewHttpClient();
	    HttpPost httpPost = new HttpPost(URL);

	    SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
	    envelope.encodingStyle = SoapSerializationEnvelope.ENC;
	    envelope.dotNet = false;		
		envelope.implicitTypes = true;
		
	    String bodyOut = 
		"<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?><soapenv:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:urn=\"urn:Demo\">"+
		   "<soapenv:Header/>"+
		   "<soapenv:Body>"+
		      "<urn:Vendor soapenv:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\">"+
		         "<RequestVendor xsi:type=\"urn:RequestVendor\">"+
		            "<Operation xsi:type=\"urn:OperationType\">"+
		               "<OperationCode xsi:type=\"xsd:string\">XML-002</OperationCode>"+
		               "<OperationId xsi:type=\"xsd:string\">2</OperationId>"+
		               "<!--Optional:-->"+
		               "<DateTime xsi:type=\"xsd:string\">"+fecha+"</DateTime>"+
		               "<!--Optional:-->"+
		               "<IdUser xsi:type=\"xsd:string\">1</IdUser>"+
		               "<IMEI xsi:type=\"xsd:string\">"+IMEI+"</IMEI>"+
		               "<IMSI xsi:type=\"xsd:string\">"+IMSI+"</IMSI>"+
		            "</Operation>"+
		            "<Service xsi:type=\"urn:ServiceVendorIn\">"+
		               "<Vendor xsi:type=\"urn:VendorIn\">"+
		                  "<Input xsi:type=\"urn:VendorInData\">"+
		                     "<CPEType xsi:type=\"xsd:string\">"+CPE+"</CPEType>"+
		                  "</Input>"+
		               "</Vendor>"+
		            "</Service>"+
		         "</RequestVendor>"+
		      "</urn:Vendor>"+
		   "</soapenv:Body>"+
		"</soapenv:Envelope>";
	    		
	    xml = bodyOut;
	    StringEntity se = new StringEntity(xml, HTTP.UTF_8);
	    se.setContentType("text/xml");	    
	    httpPost.addHeader(SOAP_ACTION, URL);		
	    
	    httpPost.setEntity(se);
	    HttpResponse httpResponse = httpClient.execute(httpPost);
	    HttpEntity resEntity = httpResponse.getEntity();	    
	    response = EntityUtils.toString(resEntity);
	    return response;
	}
	
	
	
	/*
	 * XML-003: Seleccionar Dupla Fabricante/Modelo (MODEM o DECO)
	 */
	
	public static String getModel(String CPE, String Vendor, String IMEI, String IMSI) throws Exception {		
		final String SOAP_ACTION = "urn:Demo#Model";
	    String response= null;
	    String xml = null;
	    
	    Date fecha = new Date();

	    HttpClient httpClient = getNewHttpClient();
	    HttpPost httpPost = new HttpPost(URL);

	    SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
	    envelope.encodingStyle = SoapSerializationEnvelope.ENC;
	    envelope.dotNet = false;		
		envelope.implicitTypes = true;
		
	    String bodyOut = 
			"<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?><soapenv:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:urn=\"urn:Demo\">"+
		    "<soapenv:Header/>"+
		    "<soapenv:Body>"+
		       "<urn:Model soapenv:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\">"+
		          "<RequestModel xsi:type=\"urn:RequestModel\">"+
		             "<Operation xsi:type=\"urn:OperationType\">"+
		                "<OperationCode xsi:type=\"xsd:string\">XML-003</OperationCode>"+
		                "<OperationId xsi:type=\"xsd:string\">?</OperationId>"+
		                "<!--Optional:-->"+
		                "<DateTime xsi:type=\"xsd:string\">"+fecha+"</DateTime>"+
		                "<!--Optional:-->"+
		                "<IdUser xsi:type=\"xsd:string\">?</IdUser>"+
		                "<IMEI xsi:type=\"xsd:string\">"+IMEI+"</IMEI>"+
		                "<IMSI xsi:type=\"xsd:string\">"+IMSI+"</IMSI>"+
		             "</Operation>"+
		             "<Service xsi:type=\"urn:ServiceModelIn\">"+
		                "<Model xsi:type=\"urn:ModelIn\">"+
		                   "<Input xsi:type=\"urn:ModelInData\">"+
		                      "<CPEType xsi:type=\"xsd:string\">"+CPE+"</CPEType>"+
		                      "<VendorName xsi:type=\"xsd:string\">"+Vendor+"</VendorName>"+
		                   "</Input>"+
		                "</Model>"+
		             "</Service>"+
		          "</RequestModel>"+
		       "</urn:Model>"+
		    "</soapenv:Body>"+
		 "</soapenv:Envelope>";
	    		
	    xml = bodyOut;
	    StringEntity se = new StringEntity(xml, HTTP.UTF_8);
	    se.setContentType("text/xml");	    
	    httpPost.addHeader(SOAP_ACTION, URL);		
	    
	    httpPost.setEntity(se);
	    HttpResponse httpResponse = httpClient.execute(httpPost);
	    HttpEntity resEntity = httpResponse.getEntity();	    
	    response = EntityUtils.toString(resEntity);
	    return response;
	}
	

	/*
	 * XML-004: Actualiza Inventario (MODEM/DECO)
	 */
	
	public static String setInventoryUpdate(String Area, String Phone, String CPEType, String CPEModel, String IMEI, String IMSI) throws Exception {		
		final String SOAP_ACTION = "urn:Demo#InventoryUpdate";
	    String response= null;
	    String xml = null;
	    
	    Date fecha = new Date();

	    HttpClient httpClient = getNewHttpClient();
	    HttpPost httpPost = new HttpPost(URL);

	    SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
	    envelope.encodingStyle = SoapSerializationEnvelope.ENC;
	    envelope.dotNet = false;		
		envelope.implicitTypes = true;
		
	    String bodyOut = 
		"<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?><soapenv:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:urn=\"urn:Demo\">"+
		   "<soapenv:Header/>"+
		   "<soapenv:Body>"+
		      "<urn:InventoryUpdate soapenv:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\">"+
		         "<RequestInventoryUpdate xsi:type=\"urn:RequestInventoryUpdate\">"+
		            "<Operation xsi:type=\"urn:OperationType\">"+
		               "<OperationCode xsi:type=\"xsd:string\">XML-004</OperationCode>"+
		               "<OperationId xsi:type=\"xsd:string\">4</OperationId>"+
		               "<!--Optional:-->"+
		               "<DateTime xsi:type=\"xsd:string\">"+fecha+"</DateTime>"+
		               "<!--Optional:-->"+
		               "<IdUser xsi:type=\"xsd:string\">1</IdUser>"+
		               "<IMEI xsi:type=\"xsd:string\">"+IMEI+"</IMEI>"+
		               "<IMSI xsi:type=\"xsd:string\">"+IMSI+"</IMSI>"+
		            "</Operation>"+
		            "<Service xsi:type=\"urn:ServiceInventoryUpdateIn\">"+
		               "<InventoryUpdate xsi:type=\"urn:InventoryUpdateIn\">"+
		                  "<Input xsi:type=\"urn:InventoryUpdateInData\">"+
		                     "<Area xsi:type=\"xsd:string\">"+Area+"</Area>"+
		                     "<Phone xsi:type=\"xsd:string\">"+Phone+"</Phone>"+
		                     "<CPEType xsi:type=\"xsd:string\">"+CPEType+"</CPEType>"+
		                     "<CPEModel xsi:type=\"xsd:string\">"+CPEModel+"</CPEModel>"+
		                  "</Input>"+
		               "</InventoryUpdate>"+
		            "</Service>"+
		         "</RequestInventoryUpdate>"+
		      "</urn:InventoryUpdate>"+
		   "</soapenv:Body>"+
		"</soapenv:Envelope>";
	    		
	    xml = bodyOut;
	    StringEntity se = new StringEntity(xml, HTTP.UTF_8);
	    se.setContentType("text/xml");	    
	    httpPost.addHeader(SOAP_ACTION, URL);		
	    
	    httpPost.setEntity(se);
	    HttpResponse httpResponse = httpClient.execute(httpPost);
	    HttpEntity resEntity = httpResponse.getEntity();	    
	    response = EntityUtils.toString(resEntity);
	    return response;
	}
	
	/*
	 * XML-005: Listar elementos de Planta Externa 
	 */

	public static String getOutsidePlant(String Area, String Phone, String Type, String IMEI, String IMSI) throws Exception {		
		final String SOAP_ACTION = "urn:Demo#OutsidePlant";
	    String response= null;
	    String xml = null;
	    
	    Date fecha = new Date();

	    HttpClient httpClient = getNewHttpClient();
	    HttpPost httpPost = new HttpPost(URL);

	    SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
	    envelope.encodingStyle = SoapSerializationEnvelope.ENC;
	    envelope.dotNet = false;		
		envelope.implicitTypes = true;
		
	    String bodyOut = 
		"<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?><soapenv:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:urn=\"urn:Demo\">"+
		   "<soapenv:Header/>"+
		   "<soapenv:Body>"+
		      "<urn:OutsidePlant soapenv:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\">"+
		         "<RequestOutsidePlant xsi:type=\"urn:RequestOutsidePlant\">"+
		            "<Operation xsi:type=\"urn:OperationType\">"+
		               "<OperationCode xsi:type=\"xsd:string\">XML-005</OperationCode>"+
		               "<OperationId xsi:type=\"xsd:string\">5</OperationId>"+
		               "<!--Optional:-->"+
		               "<DateTime xsi:type=\"xsd:string\">"+fecha+"</DateTime>"+
		               "<!--Optional:-->"+
		               "<IdUser xsi:type=\"xsd:string\">1</IdUser>"+
		               "<IMEI xsi:type=\"xsd:string\">"+IMEI+"</IMEI>"+
		               "<IMSI xsi:type=\"xsd:string\">"+IMSI+"</IMSI>"+
		            "</Operation>"+
		            "<Service xsi:type=\"urn:ServiceOutsidePlantIn\">"+
		               "<OutsidePlant xsi:type=\"urn:OutsidePlantIn\">"+
		                  "<Input xsi:type=\"urn:OutsidePlantInData\">"+
		                     "<Area xsi:type=\"xsd:string\">"+Area+"</Area>"+
		                     "<Phone xsi:type=\"xsd:string\">"+Phone+"</Phone>"+
		                     "<Type xsi:type=\"xsd:string\">"+Type+"</Type>"+
		                  "</Input>"+
		               "</OutsidePlant>"+
		            "</Service>"+
		         "</RequestOutsidePlant>"+
		      "</urn:OutsidePlant>"+
		   "</soapenv:Body>"+
		"</soapenv:Envelope>";
	    		
	    xml = bodyOut;
	    StringEntity se = new StringEntity(xml, HTTP.UTF_8);
	    se.setContentType("text/xml");	    
	    httpPost.addHeader(SOAP_ACTION, URL);		
	    
	    httpPost.setEntity(se);
	    HttpResponse httpResponse = httpClient.execute(httpPost);
	    HttpEntity resEntity = httpResponse.getEntity();	    
	    response = EntityUtils.toString(resEntity);
	    return response;
	}
	
	/*
	 * XML-006: Actualiza Planta Externa
	 */
	
	public static String setOutsidePlantUpgrade(String Id, String Value, 
			String Type, String Lat, String Lng, 
			String Pict, String IMEI, String IMSI) throws Exception {
		
		final String SOAP_ACTION = "urn:Demo#OutsidePlantUpgrade";
		String response= null;
	    String xml = null;
    
	    Date fecha = new Date();


	    HttpClient httpClient = getNewHttpClient();
	    HttpPost httpPost = new HttpPost(URL);

	    SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
	    envelope.encodingStyle = SoapSerializationEnvelope.ENC;
	    envelope.dotNet = false;		
		envelope.implicitTypes = true;
		
	    String bodyOut = 
		"<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?><soapenv:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:urn=\"urn:Demo\">"+
		   "<soapenv:Header/>"+
		   "<soapenv:Body>"+
		      "<urn:OutsidePlantUpgrade soapenv:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\">"+
		         "<RequestOutsidePlantUpgrade xsi:type=\"urn:RequestOutsidePlantUpgrade\">"+
		            "<Operation xsi:type=\"urn:OperationType\">"+
		               "<OperationCode xsi:type=\"xsd:string\">XML-006</OperationCode>"+
		               "<OperationId xsi:type=\"xsd:string\">6</OperationId>"+
		               "<!--Optional:-->"+
		               "<DateTime xsi:type=\"xsd:string\">"+fecha+"</DateTime>"+
		               "<!--Optional:-->"+
		               "<IdUser xsi:type=\"xsd:string\">1</IdUser>"+
		               "<IMEI xsi:type=\"xsd:string\">"+IMEI+"</IMEI>"+
		               "<IMSI xsi:type=\"xsd:string\">"+IMSI+"</IMSI>"+
		            "</Operation>"+
		            "<Service xsi:type=\"urn:ServiceOutsidePlantUpgradeIn\">"+
		               "<OutsidePlantUpgrade xsi:type=\"urn:OutsidePlantUpgradeIn\">"+
		                  "<Input xsi:type=\"urn:OutsidePlantUpgradeInData\">"+
		                     "<Element xsi:type=\"urn:ElementPlantUpgradeType\">"+
		                        "<Id xsi:type=\"xsd:string\">"+Id+"</Id>"+
		                        "<Type xsi:type=\"xsd:string\">"+Type+"</Type>"+
		                        "<Value xsi:type=\"xsd:string\">"+Value+"</Value>"+
		                        "<Gps xsi:type=\"urn:GPSType\">"+
		                           "<Lat xsi:type=\"xsd:string\">"+Lat+"</Lat>"+
		                           "<Lng xsi:type=\"xsd:string\">"+Lng+"</Lng>"+
		                        "</Gps>"+
		                        "<Picture xsi:type=\"xsd:string\">"+Pict+"</Picture>"+
		                     "</Element>"+
		                  "</Input>"+
		               "</OutsidePlantUpgrade>"+
		            "</Service>"+
		         "</RequestOutsidePlantUpgrade>"+
		      "</urn:OutsidePlantUpgrade>"+
		   "</soapenv:Body>"+
		"</soapenv:Envelope>";
	    		
	    xml = bodyOut;
	    StringEntity se = new StringEntity(xml, HTTP.UTF_8);
	    se.setContentType("text/xml");	    
	    httpPost.addHeader(SOAP_ACTION, URL);		
	    
	    httpPost.setEntity(se);
	    HttpResponse httpResponse = httpClient.execute(httpPost);
	    HttpEntity resEntity = httpResponse.getEntity();	    
	    response = EntityUtils.toString(resEntity);
	    return response;
	}
	
	/*
	 * XML-007: Certificacion DSL
	 */
	
	public static String getCertifyDSL(String Area, String Phone, String IMEI, String IMSI) throws Exception {		
		final String SOAP_ACTION = "urn:Demo#CertifyDSL";
	    String response= null;
	    String xml = null;
	    
	    Date fecha = new Date();

	    HttpClient httpClient = getNewHttpClient();
	    HttpPost httpPost = new HttpPost(URL);

	    SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
	    envelope.encodingStyle = SoapSerializationEnvelope.ENC;
	    envelope.dotNet = false;		
		envelope.implicitTypes = true;
		
	    String bodyOut = 
		"<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?><soapenv:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:urn=\"urn:Demo\">"+
		   "<soapenv:Header/>"+
		   "<soapenv:Body>"+
		      "<urn:CertifyDSL soapenv:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\">"+
		         "<RequestCertifyDSL xsi:type=\"urn:RequestCertifyDSL\">"+
		            "<Operation xsi:type=\"urn:OperationType\">"+
		               "<OperationCode xsi:type=\"xsd:string\">XML-007</OperationCode>"+
		               "<OperationId xsi:type=\"xsd:string\">7</OperationId>"+
		               "<!--Optional:-->"+
		               "<DateTime xsi:type=\"xsd:string\">"+fecha+"</DateTime>"+
		               "<!--Optional:-->"+
		               "<IdUser xsi:type=\"xsd:string\">1</IdUser>"+
		               "<IMEI xsi:type=\"xsd:string\">"+IMEI+"</IMEI>"+
		               "<IMSI xsi:type=\"xsd:string\">"+IMSI+"</IMSI>"+
		            "</Operation>"+
		            "<Service xsi:type=\"urn:ServiceCertifyDSLIn\">"+
		               "<CertifyDSL xsi:type=\"urn:CertifyDSLIn\">"+
		                  "<Input xsi:type=\"urn:CertifyDSLInData\">"+
		                     "<Area xsi:type=\"xsd:string\">"+Area+"</Area>"+
		                     "<Phone xsi:type=\"xsd:string\">"+Phone+"</Phone>"+
		                  "</Input>"+
		               "</CertifyDSL>"+
		            "</Service>"+
		         "</RequestCertifyDSL>"+
		      "</urn:CertifyDSL>"+
		   "</soapenv:Body>"+
		"</soapenv:Envelope>";
	    		
	    xml = bodyOut;
	    StringEntity se = new StringEntity(xml, HTTP.UTF_8);
	    se.setContentType("text/xml");	    
	    httpPost.addHeader(SOAP_ACTION, URL);		
	    
	    httpPost.setEntity(se);
	    HttpResponse httpResponse = httpClient.execute(httpPost);
	    HttpEntity resEntity = httpResponse.getEntity();	    
	    response = EntityUtils.toString(resEntity);
	    return response;
	}
	
	/*
	 * XML-008: Notificacion de 3G
	 */
	
	public static String setNotification3G(String Lat, String Lng, String Provider, 
			String Name, String Value, String Code, 
			String Desc, String IMEI, String IMSI) throws Exception {		
		final String SOAP_ACTION = "urn:Demo#Notification3g";
	    String response= null;
	    String xml = null;
	    
	    Date fecha = new Date();

	    HttpClient httpClient = getNewHttpClient();
	    HttpPost httpPost = new HttpPost(URL);

	    SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
	    envelope.encodingStyle = SoapSerializationEnvelope.ENC;
	    envelope.dotNet = false;		
		envelope.implicitTypes = true;
		
	    String bodyOut = 
		"<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?><soapenv:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:urn=\"urn:Demo\">"+
		   "<soapenv:Header/>"+
		   "<soapenv:Body>"+
		      "<urn:Notification3g soapenv:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\">"+
		         "<RequestNotification3g xsi:type=\"urn:RequestNotification3g\">"+
		            "<Operation xsi:type=\"urn:OperationType\">"+
		               "<OperationCode xsi:type=\"xsd:string\">XML-008</OperationCode>"+
		               "<OperationId xsi:type=\"xsd:string\">8</OperationId>"+
		               "<!--Optional:-->"+
		               "<DateTime xsi:type=\"xsd:string\">"+fecha+"</DateTime>"+
		               "<!--Optional:-->"+
		               "<IdUser xsi:type=\"xsd:string\">"+1+"</IdUser>"+
		               "<IMEI xsi:type=\"xsd:string\">"+IMEI+"</IMEI>"+
		               "<IMSI xsi:type=\"xsd:string\">"+IMSI+"</IMSI>"+
		            "</Operation>"+
		            "<Service xsi:type=\"urn:ServiceNotification3gIn\">"+
		               "<Notification3g xsi:type=\"urn:Notification3gIn\">"+
		                  "<Input xsi:type=\"urn:Notification3gInData\">"+
		                     "<Gps xsi:type=\"urn:GPSType\">"+
		                        "<Lat xsi:type=\"xsd:string\">"+Lat+"</Lat>"+
		                        "<Lng xsi:type=\"xsd:string\">"+Lng+"</Lng>"+
		                     "</Gps>"+
		                     "<Provider xsi:type=\"xsd:string\">"+Provider+"</Provider>"+
		                     "<!--Zero or more repetitions:-->"+
		                     "<Parameter xsi:type=\"urn:CertifyParameterType\">"+
		                     
		                        /*
		                         * TODO: 	Implementar un foreach para parsear el array de
		                         * 			operaciones de 3G
		                         */
		                        
		                        "<!--Zero or more repetitions:-->"+
		                        "<Name xsi:type=\"xsd:string\">"+Name+"</Name>"+
		                        "<!--Zero or more repetitions:-->"+
		                        "<Value xsi:type=\"xsd:string\">"+Value+"</Value>"+
		                        "<!--Zero or more repetitions:-->"+
		                        "<Code xsi:type=\"xsd:string\">"+Code+"</Code>"+
		                        "<!--Zero or more repetitions:-->"+
		                        "<Description xsi:type=\"xsd:string\">"+Desc+"</Description>"+
		                     "</Parameter>"+
		                  "</Input>"+
		               "</Notification3g>"+
		            "</Service>"+
		         "</RequestNotification3g>"+
		      "</urn:Notification3g>"+
		   "</soapenv:Body>"+
		"</soapenv:Envelope>";
	    		
	    xml = bodyOut;
	    StringEntity se = new StringEntity(xml, HTTP.UTF_8);
	    se.setContentType("text/xml");	    
	    httpPost.addHeader(SOAP_ACTION, URL);		
	    
	    httpPost.setEntity(se);
	    HttpResponse httpResponse = httpClient.execute(httpPost);
	    HttpEntity resEntity = httpResponse.getEntity();	    
	    response = EntityUtils.toString(resEntity);
	    return response;
	}
	
	/*
	 * XML-009: Localizacion de Averia
	 */
	
	public static String setLocation(String Pict, String Type, String Lat, String Lng, 
			String Comment, String IMEI, String IMSI) throws Exception {		
		final String SOAP_ACTION = "urn:Demo#Location";
	    String response= null;
	    String xml = null;
	    
	    Date fecha = new Date();

	    HttpClient httpClient = getNewHttpClient();
	    HttpPost httpPost = new HttpPost(URL);

	    SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
	    envelope.encodingStyle = SoapSerializationEnvelope.ENC;
	    envelope.dotNet = false;		
		envelope.implicitTypes = true;
		
	    String bodyOut = 
		"<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?><soapenv:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:urn=\"urn:Demo\">"+
		   "<soapenv:Header/>"+
		   "<soapenv:Body>"+
		      "<urn:Location soapenv:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\">"+
		         "<RequestLocation xsi:type=\"urn:RequestLocation\">"+
		            "<Operation xsi:type=\"urn:OperationType\">"+
		               "<OperationCode xsi:type=\"xsd:string\">XML-009</OperationCode>"+
		               "<OperationId xsi:type=\"xsd:string\">9</OperationId>"+
		               "<!--Optional:-->"+
		               "<DateTime xsi:type=\"xsd:string\">"+fecha+"</DateTime>"+
		               "<!--Optional:-->"+
		               "<IdUser xsi:type=\"xsd:string\">1</IdUser>"+
		               "<IMEI xsi:type=\"xsd:string\">"+IMEI+"</IMEI>"+
		               "<IMSI xsi:type=\"xsd:string\">"+IMSI+"</IMSI>"+
		            "</Operation>"+
		            "<Service xsi:type=\"urn:ServiceLocationIn\">"+
		               "<Location xsi:type=\"urn:LocationIn\">"+
		                  "<Input xsi:type=\"urn:LocationInData\">"+
		                     "<Type xsi:type=\"xsd:string\">"+Type+"</Type>"+
		                     "<Gps xsi:type=\"urn:GPSType\">"+
		                        "<Lat xsi:type=\"xsd:string\">"+Lat+"</Lat>"+
		                        "<Lng xsi:type=\"xsd:string\">"+Lng+"</Lng>"+
		                     "</Gps>"+
		                     "<Picture xsi:type=\"xsd:string\">"+Pict+"</Picture>"+
		                     "<Coment xsi:type=\"xsd:string\">"+Comment+"</Coment>"+
		                  "</Input>"+
		               "</Location>"+
		            "</Service>"+
		         "</RequestLocation>"+
		      "</urn:Location>"+
		   "</soapenv:Body>"+
		"</soapenv:Envelope>";
	    		
	    xml = bodyOut;
	    StringEntity se = new StringEntity(xml, HTTP.UTF_8);
	    se.setContentType("text/xml");	    
	    httpPost.addHeader(SOAP_ACTION, URL);		
	    
	    httpPost.setEntity(se);
	    HttpResponse httpResponse = httpClient.execute(httpPost);
	    HttpEntity resEntity = httpResponse.getEntity();	    
	    response = EntityUtils.toString(resEntity);
	    return response;
	}
	
	/*
	 * XML-010: Planta Externa Proxima
	 */
	
	public static String getNeighborNode(String Lat, String Lng, 
			String IMEI, String IMSI) throws Exception {
		
		final String SOAP_ACTION = "urn:Demo#NeighborNode";
	    String response= null;
	    String xml = null;
	    
	    Date fecha = new Date();

	    HttpClient httpClient = getNewHttpClient();
	    HttpPost httpPost = new HttpPost(URL);

	    SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
	    envelope.encodingStyle = SoapSerializationEnvelope.ENC;
	    envelope.dotNet = false;		
		envelope.implicitTypes = true;
		
	    String bodyOut = 
		"<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?><soapenv:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:urn=\"urn:Demo\">"+
		   "<soapenv:Header/>"+
		   "<soapenv:Body>"+
		      "<urn:NeighborNode soapenv:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\">"+
		         "<RequestNeighborNode xsi:type=\"urn:RequestNeighborNode\">"+
		            "<Operation xsi:type=\"urn:OperationType\">"+
		               "<OperationCode xsi:type=\"xsd:string\">XML-010</OperationCode>"+
		               "<OperationId xsi:type=\"xsd:string\">10</OperationId>"+
		               "<!--Optional:-->"+
		               "<DateTime xsi:type=\"xsd:string\">"+fecha+"</DateTime>"+
		               "<!--Optional:-->"+
		               "<IdUser xsi:type=\"xsd:string\">1</IdUser>"+
		               "<IMEI xsi:type=\"xsd:string\">"+IMEI+"</IMEI>"+
		               "<IMSI xsi:type=\"xsd:string\">"+IMSI+"</IMSI>"+
		            "</Operation>"+
		            "<Service xsi:type=\"urn:ServiceNeighborNodeIn\">"+
		               "<NeighborNode xsi:type=\"urn:NeighborNodeIn\">"+
		                  "<Input xsi:type=\"urn:NeighborNodeInData\">"+
		                     "<Gps xsi:type=\"urn:GPSType\">"+
		                        "<Lat xsi:type=\"xsd:string\">"+Lat+"</Lat>"+
		                        "<Lng xsi:type=\"xsd:string\">"+Lng+"</Lng>"+
		                     "</Gps>"+
		                  "</Input>"+
		               "</NeighborNode>"+
		            "</Service>"+
		         "</RequestNeighborNode>"+
		      "</urn:NeighborNode>"+
		   "</soapenv:Body>"+
		"</soapenv:Envelope>";
	    		
	    xml = bodyOut;
	    StringEntity se = new StringEntity(xml, HTTP.UTF_8);
	    se.setContentType("text/xml");	    
	    httpPost.addHeader(SOAP_ACTION, URL);		
	    
	    httpPost.setEntity(se);
	    HttpResponse httpResponse = httpClient.execute(httpPost);
	    HttpEntity resEntity = httpResponse.getEntity();	    
	    response = EntityUtils.toString(resEntity);
	    return response;
	}
}

