package com.pinelabs.RnD.CommonUtils;

import org.openqa.selenium.NotFoundException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class XMLUtility {
    public static void main(String[] args) {


        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;

        {
            try {
                builder = builderFactory.newDocumentBuilder();
                Document document = builder.parse("D:\\Projects\\ParagonAutomationFramework\\ParagonAutomationFramework\\src\\main\\resources\\TestData\\R_Test_PVM_221221.xml");
                document.getDocumentElement().normalize();
               NodeList list= document.getElementsByTagName("Main");
                for (int i = 0; i < list.getLength(); i++) {
                 Node list2=  list.item(i);
                   // System.out.println( list2.getAttributes().getNamedItem("nt"));
                   if(list2.getNodeType()==Node.ELEMENT_NODE){
                       Element pvm = (Element) list2;
                       if(pvm.hasAttribute("nt"))
                       System.out.println(pvm.getAttribute("nt"));
                       else throw new NotFoundException("XML Attribute not present");
                   }
                }
            } catch (ParserConfigurationException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (SAXException e) {
                e.printStackTrace();
            }
        }
    }
}
