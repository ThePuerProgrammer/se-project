package Model;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Parser {

    private DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    private ArrayList<Integer> values = new ArrayList<>(); 
    private int counter;

    public Parser() {
        
    }
    
    public void parseEm() {
                                                                            
        try {

            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse("xmlfile.xml");
            NodeList patientList = doc.getElementsByTagName("Patient");

            for (int i = 0; i < patientList.getLength();i++) {

                Node p = patientList.item(i);

                if (p.getNodeType() == Node.ELEMENT_NODE) {
                    
                    Element patient = (Element) p;
                    // String id = patient.getAttribute("id");
                    NodeList attybutes = patient.getChildNodes();

                    for (int j = 0; j<attybutes.getLength() - 2; j++) {

                        Node n = attybutes.item(j);

                        if (n.getNodeType() == Node.ELEMENT_NODE) {

                            Element name = (Element) n;
                            int k = Integer.parseInt(name.getTextContent());
                            values.add(k);
                        
                            System.out.println(values.get(counter));
                            counter++;
                            // System.out.println("Patient " + id + ":" + name.getTagName() + " = " 
                            // + name.getTextContent());
                            
                        }
                    }
                    counter = 0;
                }
            }
        } catch (ParserConfigurationException e) {
           
            e.printStackTrace();
        } catch (SAXException e) {
         
            e.printStackTrace();
        } catch (IOException e) {
          
            e.printStackTrace();
        }
    }

    public ArrayList<Integer> getValues() {
        return values;
    }

    static public Document toXML(String[] values){
        Document doc;
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        
        
        try{
        DocumentBuilder builder = factory.newDocumentBuilder();
        doc = builder.newDocument();
        Element root = doc.createElementNS("patient dataset", "dataset");
        doc.appendChild(root);
        root.appendChild(patientNode(doc,values));
        
        
            
        
        return doc;
        
        }catch(ParserConfigurationException e){
            e.printStackTrace();
        }
        return null;
        
    }
    
    private static Node patientNode(Document doc, String[] values) {
        Element patient = doc.createElement("Patient");
        patient.setAttribute("id", values[0]);
        patient.setAttribute("clump_thickness", values[1]);
        patient.setAttribute("uniformity_cell_size", values[2]);
        patient.setAttribute("uniformity_cell_shape", values[3]);
        patient.setAttribute("marginal_adhesion", values[4]);
        patient.setAttribute("single_epithelial_cell_size", values[5]);
        patient.setAttribute("bare_nuclei", values[6]);
        patient.setAttribute("bland_chromatin", values[7]);
        patient.setAttribute("normal_nucleoli", values[8]);
        patient.setAttribute("mitoses", values[9]);
        patient.setAttribute("class", values[10]);
        
        
        return patient;
    }
}