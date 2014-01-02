package cl.inexcell.sistemadegestion;

import java.io.IOException;
import java.io.StringReader;
import java.util.Vector;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.CharacterData;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class XMLParser {
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static String getCustomer(String xml) throws ParserConfigurationException, 
														SAXException, IOException
	{
		Vector cpe = new Vector();
		
		String xmlRecords = xml;

	    DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
	    InputSource is = new InputSource();
	    is.setCharacterStream(new StringReader(xmlRecords));

	    Document doc = db.parse(is);
	    NodeList nodes = doc.getElementsByTagName("CPE");

	    for (int i = 0; i < nodes.getLength(); i++) 
	    {
	    	Element element = (Element) nodes.item(i);

  			NodeList name = element.getElementsByTagName("CPEType");
  			Element line1 = (Element) name.item(0);
  
		  	NodeList title = element.getElementsByTagName("VendorName");
		  	Element line2 = (Element) title.item(0);
  
  			NodeList cpe_model = element.getElementsByTagName("CPEModel");
			Element line3 = (Element) cpe_model.item(0);
  
  			cpe.addElement(getCharacterDataFromElement(line1)
  					 +";"+getCharacterDataFromElement(line2)
  					 +";"+getCharacterDataFromElement(line3));
  
	    }
	    
		return cpe.toString();
		//return cpe.elementAt(1).toString(); // Mostrar elemento 1 del Vector
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static String getModel(String xml) throws ParserConfigurationException, 
	SAXException, IOException
	{
		Vector models = new Vector();
		
		String xmlRecords = xml;
		
		DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		InputSource is = new InputSource();
		is.setCharacterStream(new StringReader(xmlRecords));
		
		Document doc = db.parse(is);
		NodeList nodes = doc.getElementsByTagName("Model");
		
		for (int i = 0; i < nodes.getLength(); i++) 
		{
			Element element = (Element) nodes.item(i);
			
			NodeList name = element.getElementsByTagName("Name");
			Element line1 = (Element) name.item(0);
			
			models.addElement(getCharacterDataFromElement(line1));

		}

		return models.toString();
		//return cpe.elementAt(1).toString(); // Mostrar elemento 1 del Vector
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static String getNeighborNode(String xml) throws ParserConfigurationException, 
														SAXException, IOException
	{
		Vector node = new Vector();
		
		String xmlRecords = xml;

	    DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
	    InputSource is = new InputSource();
	    is.setCharacterStream(new StringReader(xmlRecords));

	    Document doc = db.parse(is);
	    NodeList nodes = doc.getElementsByTagName("Node");
	    
	    
	    for (int i = 0; i < nodes.getLength(); i++) 
	    {
	    	Element element = (Element) nodes.item(i);

  			NodeList id = element.getElementsByTagName("Id");
  			Element line1 = (Element) id.item(0);
  			
  			NodeList type = element.getElementsByTagName("Type");
  			Element line2 = (Element) type.item(0);
  			
  			NodeList gps = element.getElementsByTagName("Gps");
  			Element line3 = (Element) gps.item(0);
  			
  			NodeList adStr = element.getElementsByTagName("AddressStreet");
  			Element line4 = (Element) adStr.item(0);
  			
  			NodeList adNmb = element.getElementsByTagName("AddressNumber");
  			Element line5 = (Element) adNmb.item(0);
  			
  			NodeList adCde = element.getElementsByTagName("AddressCode");
  			Element line6 = (Element) adCde.item(0);
  			
  			NodeList fbty = element.getElementsByTagName("Feasibility");
  			Element line7 = (Element) fbty.item(0);
  			
  			NodeList ste = element.getElementsByTagName("Site");
  			Element line8 = (Element) ste.item(0);
  			
  			NodeList cbl = element.getElementsByTagName("Cable");
  			Element line9 = (Element) cbl.item(0);
  			
  			NodeList cbt = element.getElementsByTagName("Cabinet");
  			Element line10 = (Element) cbt.item(0);

  			NodeList pFrm = element.getElementsByTagName("PairForm");
  			Element line11 = (Element) pFrm.item(0);
  			
  			NodeList pUtl = element.getElementsByTagName("PairUntil");
  			Element line12 = (Element) pUtl.item(0);
  			
  			NodeList pOcp = element.getElementsByTagName("PairOccupied");
  			Element line13 = (Element) pOcp.item(0);
  			
  			NodeList pVct = element.getElementsByTagName("PairVacant");
  			Element line14 = (Element) pVct.item(0);
  			
  			NodeList pRsvd = element.getElementsByTagName("PairReserved");
  			Element line15 = (Element) pRsvd.item(0);
  			
  			NodeList pBd = element.getElementsByTagName("PairBad");
  			Element line16 = (Element) pBd.item(0);
  
  			node.addElement(getCharacterDataFromElement(line1)
  					 +";"+getCharacterDataFromElement(line2)
  					 +";"+getCharacterDataFromElement(line3)
  					 +";"+getCharacterDataFromElement(line4)
  					 +";"+getCharacterDataFromElement(line5)
  					 +";"+getCharacterDataFromElement(line6)
  					 +";"+getCharacterDataFromElement(line7)
  					 +";"+getCharacterDataFromElement(line8)
  					 +";"+getCharacterDataFromElement(line9)
  					 +";"+getCharacterDataFromElement(line10)
  					 +";"+getCharacterDataFromElement(line11)
  					 +";"+getCharacterDataFromElement(line12)
  					 +";"+getCharacterDataFromElement(line13)
  					 +";"+getCharacterDataFromElement(line14)
  					 +";"+getCharacterDataFromElement(line15)
  					 +";"+getCharacterDataFromElement(line16));
  
	    }
	    
		return node.toString();
		//return cpe.elementAt(1).toString(); // Mostrar elemento 1 del Vector
	}
	
	


	// Generico para todas las consultas
	public static String getCharacterDataFromElement(Element e) {
	    Node child = e.getFirstChild();
	    if (child instanceof CharacterData) {
	      CharacterData cd = (CharacterData) child;
	      return cd.getData();
	    }
	    return "";
	  }

}
