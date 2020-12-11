package Model;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.*;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class XMLPatientDataParser {
    private File incomingXML;
    private Document doc;
    private DocumentBuilderFactory factory;
    private DocumentBuilder builder;

    private ArrayList<String> diagnosisValues;
    private String path;
    private NodeList nodeList;

    public XMLPatientDataParser() {

        diagnosisValues = new ArrayList<>();

        path = new File("doc/patient_diagnosis_data.xml").getAbsolutePath();
        incomingXML = new File(path);

        factory = DocumentBuilderFactory.newInstance();
        try {
            builder = factory.newDocumentBuilder();
            doc = builder.parse(incomingXML);
        } catch (Exception e) {
            System.out.println("Exception occured in XMLParientDataParser constructor: " + e);
            e.printStackTrace();
        }

        nodeList = doc.getElementsByTagName("Patient");
    }

    public void parse() {
        for (int i = 0; i < nodeList.getLength(); ++i) {
            Node n = nodeList.item(i);
            if (n.getNodeType() == Node.ELEMENT_NODE) {
                Element e = (Element) n;
                diagnosisValues.add(e.getAttribute("id"));
                diagnosisValues.add(e.getElementsByTagName("clump_thickness").item(0).getTextContent());
                diagnosisValues.add(e.getElementsByTagName("uniformity_cell_size").item(0).getTextContent());
                diagnosisValues.add(e.getElementsByTagName("uniformity_cell_shape").item(0).getTextContent());
                diagnosisValues.add(e.getElementsByTagName("marginal_adhesion").item(0).getTextContent());
                diagnosisValues.add(e.getElementsByTagName("single_epithelial_cell_size").item(0).getTextContent());
                diagnosisValues.add(e.getElementsByTagName("bare_nuclei").item(0).getTextContent());
                diagnosisValues.add(e.getElementsByTagName("bland_chromatin").item(0).getTextContent());
                diagnosisValues.add(e.getElementsByTagName("normal_nucleoli").item(0).getTextContent());
                diagnosisValues.add(e.getElementsByTagName("mitoses").item(0).getTextContent());
                diagnosisValues.add(e.getElementsByTagName("class").item(0).getTextContent());
            }
        }
    }

    public ArrayList<String> getParsedData() {
        return diagnosisValues;
    }
}
