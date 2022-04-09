package com.java8.defaultmethod;

import java.io.StringReader;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class Test {
	
	public static void main(String args[]) {
		/*
		 * ExistingClass existingClass = new ExistingClass();
		 * existingClass.newDefaultMethod();
		 */
		
		/*
		 * NewClass newClass = new NewClass(); newClass.newDefaultMethod();
		 */
		
		//String xml = "<company><staff id=\"1001\"><firstname>yong</firstname><lastname>mook kim</lastname><nickname>mkyong</nickname><salary>100000</salary></staff><staff id=\"2001\"> <firstname>low</firstname> <lastname>yin fong</lastname> <nickname>fong fong</nickname> <salary>200000</salary></staff></company>";
		String xml = "<company>\r\n" + 
				"	<staff id=\"1001\">\r\n" + 
				"		<firstname>yong</firstname>\r\n" + 
				"		<lastname>mook kim</lastname>\r\n" + 
				"		<nickname>mkyong</nickname>\r\n" + 
				"		<salary>100000</salary>\r\n" + 
				"	</staff>\r\n" + 
				"	<staff id=\"2001\">\r\n" + 
				"		<firstname>low</firstname>\r\n" + 
				"		<lastname>yin fong</lastname>\r\n" + 
				"		<nickname>fong fong</nickname>\r\n" + 
				"		<salary>200000</salary>\r\n" + 
				"	</staff>\r\n" + 
				"</company>";
		Document doc = convertStringToXMLDocument(xml);
		System.out.println(doc.getFirstChild().getNodeName());
		
		NodeList nList = doc.getElementsByTagName("staff");

		System.out.println("----------------------------");

		for (int temp = 0; temp < nList.getLength(); temp++) {

			Node nNode = nList.item(temp);

			System.out.println("\nCurrent Element :" + nNode.getNodeName());

			if (nNode.getNodeType() == Node.ELEMENT_NODE) {

				Element eElement = (Element) nNode;

				System.out.println("Staff id : " + eElement.getAttribute("id"));
				System.out.println("First Name : " + eElement.getElementsByTagName("firstname").item(0).getTextContent());
				System.out.println("Last Name : " + eElement.getElementsByTagName("lastname").item(0).getTextContent());
				System.out.println("Nick Name : " + eElement.getElementsByTagName("nickname").item(0).getTextContent());
				System.out.println("Salary : " + eElement.getElementsByTagName("salary").item(0).getTextContent());

			}
		}
		
	}
	
	private static Document convertStringToXMLDocument(String xmlString) {
        //Parser that produces DOM object trees from XML content
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
         
        //API to obtain DOM Document instance
        DocumentBuilder builder = null;
        try{
            //Create DocumentBuilder with default configuration
            builder = factory.newDocumentBuilder();
             
            //Parse the content to Document object
            Document doc = builder.parse(new InputSource(new StringReader(xmlString)));
            return doc;
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
