/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package botpubblicita;

import java.io.IOException;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author User
 */
public class XMLDom {
    
    public String parseDocument(String fileName) throws ParserConfigurationException, SAXException, IOException
    {
        String results = "";
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(fileName);
        doc.getDocumentElement().normalize();
        NodeList nList = doc.getElementsByTagName("place");
         
        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            if (nNode.getNodeType() == Node.ELEMENT_NODE)
            {
                Element eElement = (Element) nNode;
                if(eElement.hasAttribute("place_id"))
                {
                    //System.out.println("place_id: " + eElement.getAttribute("place_id") + " display_name: " + eElement.getAttribute("display_name"));
                    results += temp+1 + ";" + eElement.getAttribute("place_id") + ";" + eElement.getAttribute("display_name") +'\n';
                }
            }
        }
        return results;
    }
}
