package models;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class personalXmlReader {

    public String[] XmlReader(int temp){
        String tempQ = "Error while loading question";
        String tempA = "Error while loading answer";

        try {
            File fXmlFile = new File("/home/barna/Szoftverfejelsztes/HistoryQuiz/questions.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();

            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("element");
            System.out.println("----------------------------");

            Node nNode = nList.item(temp);
            System.out.println("\nCurrent Element :" + nNode.getNodeName());
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                System.out.println("Question id : " + eElement.getAttribute("id"));
                tempQ = eElement.getElementsByTagName("text").item(0).getTextContent();
                tempA = eElement.getElementsByTagName("answer").item(0).getTextContent();

                System.out.println("Question Text : " + eElement.getElementsByTagName("text").item(0).getTextContent());
                System.out.println("Answer : " + eElement.getElementsByTagName("answer").item(0).getTextContent());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        String[] selectedQuestion = new String[] {tempQ, tempA};
        return selectedQuestion;
    }
}
