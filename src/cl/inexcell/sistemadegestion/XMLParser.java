package cl.inexcell.sistemadegestion;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Vector;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.w3c.dom.CharacterData;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import android.util.Log;

public class XMLParser {
	
	/*
	 * Parser Return Code
	 */
	
	public static String getReturnCode(String xml) throws ParserConfigurationException, 
	SAXException, IOException, XPathExpressionException
	{
		ArrayList<String> models = new ArrayList<String>();
        		
        String xmlRecords = xml;
        
        DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        InputSource is = new InputSource();
        is.setCharacterStream(new StringReader(xmlRecords));
        
        Document doc = db.parse(is);
        NodeList nodes = doc.getElementsByTagName("Return");
        
        //for (int i = 0; i < nodes.getLength(); i++) 
    	for (int i = 0; i < 1; i++)
        {
                Element element = (Element) nodes.item(i);
                NodeList name = element.getElementsByTagName("Code");
                
                for(int j=0; j< name.getLength(); j++){
                	Element line1 = (Element) name.item(j);
                	models.add(getCharacterDataFromElement(line1));
                }
        }

        return models.toString();
        //return cpe.elementAt(1).toString(); // Mostrar elemento 1 del Vector
	}

	
	/*
	 * XML-001: Parser consultar Cliente
	 */
	
	public static String getCustomer(String xml) throws ParserConfigurationException,
    SAXException, IOException
    {
		Vector<String> cpe = new Vector<String>();
		
		String xmlRecords = xml;
		
		DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		InputSource is = new InputSource();
		is.setCharacterStream(new StringReader(xmlRecords));
		
		Document doc = db.parse(is);
		NodeList nodes = doc.getElementsByTagName("CPE");
		String texto1, texto2, texto3;
		
		for (int i = 0; i < nodes.getLength(); i++)
		{
			Element element = (Element) nodes.item(i);
			
			NodeList name = element.getElementsByTagName("CPEType");
			Element line1 = (Element) name.item(0);
			
			NodeList title = element.getElementsByTagName("VendorName");
			Element line2 = (Element) title.item(0);
			
			NodeList cpe_model = element.getElementsByTagName("CPEModel");
			Element line3 = (Element) cpe_model.item(0);
			
			texto1 = getCharacterDataFromElement(line1);
			texto2 = getCharacterDataFromElement(line2);
			texto3 = getCharacterDataFromElement(line3);
			
			if(texto1.trim() == "") texto1 = "---";
			if(texto2.trim() == "") texto2 = "---";
			if(texto3.trim() == "") texto3 = "---";

			cpe.addElement(texto1
					+";"+texto2
					+";"+texto3);
		}

		return cpe.toString();
		//	return cpe.elementAt(1).toString(); // Mostrar elemento 1 del Vector
    }
	
	
	/*
	 * XML-002: Obtener Fabricante de Equipo
	 */
	
	public static ArrayList<String> getVendor(String xml) throws ParserConfigurationException, 
	SAXException, IOException, XPathExpressionException
	{
		ArrayList<String> models = new ArrayList<String>();
        
        String xmlRecords = xml;
        
        DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        InputSource is = new InputSource();
        is.setCharacterStream(new StringReader(xmlRecords));
        
        Document doc = db.parse(is);
        NodeList nodes = doc.getElementsByTagName("Vendor");
        
        //for (int i = 0; i < nodes.getLength(); i++) 
    	for (int i = 0; i < 1; i++)
        {
                Element element = (Element) nodes.item(i);
                NodeList name = element.getElementsByTagName("Name");
                
                for(int j=0; j< name.getLength(); j++){
                	Element line1 = (Element) name.item(j);
                	models.add(getCharacterDataFromElement(line1));
                }
        }

        return models;
        //return cpe.elementAt(1).toString(); // Mostrar elemento 1 del Vector
	}

	
	/*
	 * XML-003: Obtener Fabricante y Modelo (DECO/MODEM)
	 */
	
	public static ArrayList<String> getModel(String xml) throws ParserConfigurationException, 
	SAXException, IOException
	{
		ArrayList<String> models = new ArrayList<String>();
        
        String xmlRecords = xml;
        
        DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        InputSource is = new InputSource();
        is.setCharacterStream(new StringReader(xmlRecords));
        
        Document doc = db.parse(is);
        NodeList nodes = doc.getElementsByTagName("Model");
        
        //for (int i = 0; i < nodes.getLength(); i++) 
    	for (int i = 0; i < 1; i++)
        {
                Element element = (Element) nodes.item(i);
                NodeList name = element.getElementsByTagName("Name");
                
                for(int j=0; j< name.getLength(); j++){
                	Element line1 = (Element) name.item(j);
                	models.add(getCharacterDataFromElement(line1));
                }
        }

        return models;
        //return cpe.elementAt(1).toString(); // Mostrar elemento 1 del Vector
	}
	
	public static ArrayList<String> setUpdateInventory(String xml) throws ParserConfigurationException,
    SAXException, IOException
    {
          ArrayList<String> res = new ArrayList<String>();
         
          String xmlRecords = xml;
         
          DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
          InputSource is = new InputSource();
          is.setCharacterStream(new StringReader(xmlRecords));
         
          Document doc = db.parse(is);
          NodeList nodes = doc.getChildNodes().item(0)
                                 .getChildNodes().item(0)
                                 .getChildNodes().item(0)
                                 .getChildNodes().item(0)
                                 .getChildNodes().item(1)
                                 .getChildNodes().item(0)
                                 .getChildNodes().item(0)
                                 .getChildNodes().item(0)
                                 .getChildNodes(); //Llegamos al tag Return
         
         
          for(int i = 0; i< nodes.getLength(); i++){
                NodeList elemento = nodes.item(i).getChildNodes();
                res.add(elemento.item(0).getNodeValue());
          }
               
          return res;
          //return cpe.elementAt(1).toString(); // Mostrar elemento 1 del Vector
    }
	
	// TODO
	
	
	/*
	 * XML-005: Planta Externa
	 */
	
	public static String getOutsidePlant(String xml) throws ParserConfigurationException, 
	SAXException, IOException, XPathExpressionException
	{
		ArrayList<String> models = new ArrayList<String>();
        
        String xmlRecords = xml;
        
        DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        InputSource is = new InputSource();
        is.setCharacterStream(new StringReader(xmlRecords));
        
        Document doc = db.parse(is);
        NodeList nodes = doc.getElementsByTagName("Element");
        
        //for (int i = 0; i < nodes.getLength(); i++) 
    	for (int i = 0; i < 1; i++)
        {
                Element element = (Element) nodes.item(i);
                NodeList name = element.getElementsByTagName("Value");
                
                for(int j=0; j< name.getLength(); j++){
                	Element line1 = (Element) name.item(j);
                	models.add(getCharacterDataFromElement(line1));
                }
        }

        return models.toString();
        //return cpe.elementAt(1).toString(); // Mostrar elemento 1 del Vector
	}
	
	/*
	 * XML-006: Actualizar Planta Externa
	 */
	
	// TODO
	
	/*
     * XML-007: Certificar Red fija (xDSL)
     */
     public static ArrayList<String> getCertifyDsl(String xml) throws ParserConfigurationException,
     SAXException, IOException
     {
           ArrayList<String> res = new ArrayList<String>();
          
           String xmlRecords = xml;
          
           DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
           InputSource is = new InputSource();
           is.setCharacterStream(new StringReader(xmlRecords));
          
           Document doc = db.parse(is);
           NodeList nodes = doc.getChildNodes().item(0)
                                  .getChildNodes().item(0)
                                  .getChildNodes().item(0)
                                  .getChildNodes().item(0)
                                  .getChildNodes().item(1)
                                  .getChildNodes().item(0)
                                  .getChildNodes().item(0)
                                  .getChildNodes().item(1)
                                  .getChildNodes(); //Llegamos al tag Return
          
          
           for(int i = 0; i< nodes.getLength(); i++){
                 NodeList elemento = nodes.item(i).getChildNodes();
                 res.add(elemento.item(0).getNodeValue());
           }
                
           return res;
           //return cpe.elementAt(1).toString(); // Mostrar elemento 1 del Vector
     }
	
	// TODO
	
	/*
	 * XML-008: Informar 3G
	 */
	
	public static ArrayList<String> setNotificacion3G(String xml) throws ParserConfigurationException, 
	SAXException, IOException
	{
		ArrayList<String> res = new ArrayList<String>();
		
		String xmlRecords = xml;
		
		DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		InputSource is = new InputSource();
		is.setCharacterStream(new StringReader(xmlRecords));
		
		Document doc = db.parse(is);
		NodeList nodes = doc.getChildNodes().item(0)
						.getChildNodes().item(0)
						.getChildNodes().item(0)
						.getChildNodes().item(0)
						.getChildNodes().item(1)
						.getChildNodes().item(0)
						.getChildNodes().item(0)
						.getChildNodes().item(0)
						.getChildNodes(); //Llegamos al tag Return
		
		
		for(int i = 0; i< nodes.getLength(); i++){
			NodeList elemento = nodes.item(i).getChildNodes();
			res.add(elemento.item(0).getNodeValue());
		}
			
		return res;
		//return cpe.elementAt(1).toString(); // Mostrar elemento 1 del Vector
	}
	
	/*
	 * XML-009: Localizacion de Averia
	 */
	
	public static ArrayList<String> setLocation(String xml) throws ParserConfigurationException, 
	SAXException, IOException
	{
		ArrayList<String> res = new ArrayList<String>();
		
		String xmlRecords = xml;
		
		DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		InputSource is = new InputSource();
		is.setCharacterStream(new StringReader(xmlRecords));
		
		Document doc = db.parse(is);
		NodeList nodes = doc.getChildNodes().item(0)
						.getChildNodes().item(0)
						.getChildNodes().item(0)
						.getChildNodes().item(0)
						.getChildNodes().item(1)
						.getChildNodes().item(0)
						.getChildNodes().item(0)
						.getChildNodes().item(0)
						.getChildNodes(); //Llegamos al tag Return
		
		
		for(int i = 0; i< nodes.getLength(); i++){
			NodeList elemento = nodes.item(i).getChildNodes();
			res.add(elemento.item(0).getNodeValue());
		}
			
		return res;
		//return cpe.elementAt(1).toString(); // Mostrar elemento 1 del Vector
	}
	
	/*
	 * XML-010: Nodos de planta externa vecinos
	 */
	
	public static ArrayList<String> getNeighborNode(String xml) throws ParserConfigurationException, 
														SAXException, IOException
	{
		ArrayList<String> res = new ArrayList<String>();
		
		String xmlRecords = xml;

	    DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
	    InputSource is = new InputSource();
	    is.setCharacterStream(new StringReader(xmlRecords));

	    Document doc = db.parse(is);
	    NodeList nodes = doc.getChildNodes().item(0)
				.getChildNodes().item(0)
				.getChildNodes().item(0)
				.getChildNodes().item(0)
				.getChildNodes().item(1)
				.getChildNodes().item(0)
				.getChildNodes().item(0)
				.getChildNodes();
	    
	   int tamano = nodes.getLength();
	   NodeList Return = nodes.item(tamano-1).getChildNodes();
	   String code = Return.item(0).getChildNodes().item(0).getNodeValue();
	   String linea = "";
	   /** GUARDAMOS EL CODE Y DESCRIPTION DEL RESULT **/
		for (int i = 0; i < Return.getLength(); i++) 
	    {
			if(i>0)
				linea+=";";
	    	linea+=Return.item(i).getChildNodes().item(0).getNodeValue();	
	    	
	    }
		res.add(linea);
		linea = "";
	    
		/** SI CODIGO ES "0" GUARDAMOS EL RESTO DE NODOS.*/
	    if(Integer.valueOf(code)==0 || Integer.valueOf(code)==48){
		    for (int i = 0; i < tamano-1; i++) 
		    {
		    	NodeList planta = nodes.item(i).getChildNodes();
		    	int n_datos = planta.getLength();
		    	for(int j = 0; j < n_datos; j++){
		    		NodeList dato = planta.item(j).getChildNodes();
		    		int not_empty = dato.getLength();
		    		if(j>0)
						linea+=";";
		    		
		    		if(not_empty == 0){
		    			linea+= "--";
		    		}
		    		else{		    			
			    		if(j==2){
			    			linea+=dato.item(0).getChildNodes().item(0).getNodeValue();
			    			linea+=";";
			    			linea+=dato.item(1).getChildNodes().item(0).getNodeValue();
			    		}
			    		else if(j==6){
			    			if(dato.item(0).getChildNodes().getLength() == 0){
				    			linea+= "--;--;--";
				    		}
			    			else{
				    			linea+=dato.item(0).getChildNodes().item(0).getNodeValue();
				    			linea+=";";
				    			linea+=dato.item(1).getChildNodes().item(0).getNodeValue();
				    			linea+=";";
				    			linea+=dato.item(2).getChildNodes().item(0).getNodeValue();
			    			}
			    		}
			    		else
			    			linea+=dato.item(0).getNodeValue();
		    		}
		    	}
		    	res.add(linea);
		    	linea = "";
		    }
	    }
	    
		return res;
	}
	
	public static ArrayList<String> getCertification(String xml) throws ParserConfigurationException, 
	SAXException, IOException
	{
		ArrayList<String> res = new ArrayList<String>();
		
		String xmlRecords = xml;
		
		DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		InputSource is = new InputSource();
		is.setCharacterStream(new StringReader(xmlRecords));
		
		Document doc = db.parse(is);
		NodeList nodes = doc.getChildNodes().item(0)
							.getChildNodes().item(0)
							.getChildNodes().item(0)
							.getChildNodes().item(0)
							.getChildNodes().item(1)
							.getChildNodes().item(0)
							.getChildNodes().item(0)
							.getChildNodes();
		
		int tamano = nodes.getLength();
		NodeList Return = nodes.item(tamano-1).getChildNodes();
		String code = Return.item(0).getChildNodes().item(0).getNodeValue();
		String linea = "";
		/** GUARDAMOS EL CODE Y DESCRIPTION DEL RESULT **/
		for (int i = 0; i < Return.getLength(); i++) 
		{
			if(i>0)
				linea+=";";
			linea+=Return.item(i).getChildNodes().item(0).getNodeValue();	
		
		}
		res.add(linea);
		linea = "";
		
		/** SI CODIGO ES "0" GUARDAMOS EL RESTO DE NODOS.*/
		if(Integer.valueOf(code)==0 || Integer.valueOf(code)==48){
			for (int i = 0; i < tamano-1; i++) 
			{
				NodeList planta = nodes.item(i).getChildNodes();
				int n_datos = planta.getLength();
				for(int j = 0; j < n_datos; j++){
					NodeList dato = planta.item(j).getChildNodes();
					int not_empty = dato.getLength();
					if(j>0)
						linea+=";";
					
					if(not_empty == 0){
						linea+= "--";
					}
					else{		    			
						linea+=dato.item(0).getNodeValue();
					}
			}
			res.add(linea);
			linea = "";
		}
	}

	return res;
}
	

	/*
	 * Generico para todas las consultas
	 */
	
	public static String getCharacterDataFromElement(Element e) {
	    Node child = e.getFirstChild();
	    if (child instanceof CharacterData) {
	      CharacterData cd = (CharacterData) child;
	      return cd.getData();
	    }
	    return "";
	  }

}
