package Model;

import java.io.File;
import java.io.FileWriter;
import java.io.StringReader;
import java.util.ArrayList;

import javax.xml.parsers.*;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class XMLDocBuilder {
    private Document doc;
    private DocumentBuilderFactory factory;
    private DocumentBuilder builder;
    private String xmlTemplateString;
    private ArrayList<String> diagnosisValues;
    private String path;


    // CONSTRUCTOR REQUIRES PATIENT DIAGNOSIS DATA
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public XMLDocBuilder(ArrayList<String> diagnosisValues) {

        this.diagnosisValues = diagnosisValues;
        assert(diagnosisValues.size() == 11);

        path = new File("doc/patient_diagnosis_data.xml").getAbsolutePath();


        try {
            factory = DocumentBuilderFactory.newInstance();
            builder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {System.out.println("Exception occurred in XMLDocBuilder Constructor: " + e);}
    } //XMLDocBuilder(ArrayList<String>)
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    // BUILDS AND SAVES THE DOCUMENT USING THE TEMPLATE STRING AND TWO PRIVATE METHODS
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void buildAndSaveXMLDoc() {

        generateXMLTemplateString();

        try {
            doc = builder.parse(new InputSource(new StringReader(xmlTemplateString)));
        } catch (Exception e) {System.out.println("Exception occurred in XMLDocBuilder.buildAndSaveXMLDoc(): " + e);}

        saveDocumentToDocFolder();

    } // buildAndSaveXMLDoc()
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    // PLACES COMPLETED DOCUMENT IN /doc/filename.xml
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private void saveDocumentToDocFolder() {
        try {
            DOMSource source = new DOMSource(doc);
            FileWriter writer = new FileWriter(new File(path));
            StreamResult result = new StreamResult(writer);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.transform(source, result);
        } catch (Exception e) {System.out.println("Exception occurred in XMLDocBuilder.saveDocumentToDocFolder(): " + e);}
    } // saveDocumetToDocFolder()
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    // GENERATES THE STRING FORMAT FOR THE XML DOCUMENT
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private void generateXMLTemplateString() {
        xmlTemplateString = "<Dataset>" + System.lineSeparator() +
                            "    <Patient id='" + diagnosisValues.get(0) + "'>" + System.lineSeparator() +
                            "        <clump_thickness>" + diagnosisValues.get(1) + "</clump_thickness>" + System.lineSeparator() +
                            "        <uniformity_cell_size>" + diagnosisValues.get(2) + "</uniformity_cell_size>" + System.lineSeparator() +
                            "        <uniformity_cell_shape>" + diagnosisValues.get(3) + "</uniformity_cell_shape>" + System.lineSeparator() +
                            "        <marginal_adhesion>" + diagnosisValues.get(4) + "</marginal_adhesion>" + System.lineSeparator() +
                            "        <single_epithelial_cell_size>" + diagnosisValues.get(5) + "</single_epithelial_cell_size>" + System.lineSeparator() +
                            "        <bare_nuclei>" + diagnosisValues.get(6) + "</bare_nuclei>" + System.lineSeparator() +
                            "        <bland_chromatin>" + diagnosisValues.get(7) + "</bland_chromatin>" + System.lineSeparator() +
                            "        <normal_nucleoli>" + diagnosisValues.get(8) + "</normal_nucleoli>" + System.lineSeparator() +
                            "        <mitoses>" + diagnosisValues.get(9) + "</mitoses>" + System.lineSeparator() +
                            "        <class>" + diagnosisValues.get(10) + "</class>" + System.lineSeparator() +
                            "    </Patient>" + System.lineSeparator() +
                            "</Dataset>";
    } // generateXMLTemplateString()
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}