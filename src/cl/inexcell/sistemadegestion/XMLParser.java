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
