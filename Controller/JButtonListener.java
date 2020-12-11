package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;

import Model.Parser;
import Model.PatientUser;
import View.DiagPanel;
import tcp_connect.MyServer;

public class JButtonListener implements ActionListener {

    private DiagPanel diagPanel;
    private ArrayList<String> ips = new ArrayList<>();
    private int count = 0;
    private Thread socketThread;
    private PatientUser patientUser;

    public JButtonListener(DiagPanel diagPanel) {
        this.diagPanel = diagPanel;
        ips.add("23.123.213.59"); // blake
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        JButton b = (JButton) e.getSource();

        if (b == diagPanel.getDiagnoseButton()) {

            if (count == 2) count = 0;

            diagPanel.getLeftCanvas().getStringArrayList().add("Establishing Connection...");
            diagPanel.getLeftCanvas().repaint();
            
            socketThread = new Thread(()->{
                patientUser = new PatientUser(ips.get(count));
            });
            
            
            if (patientUser.getS().isConnected()) {
                diagPanel.getLeftCanvas().getStringArrayList().add("Connection Established to: ");
                diagPanel.getLeftCanvas().repaint();
            } else {
                diagPanel.getLeftCanvas().getStringArrayList().add("Unable to establish connection.");
                diagPanel.getLeftCanvas().repaint();
            }
        } else if (b == diagPanel.getDeliverResultsButton()) {

            diagPanel.getRightCanvas().setConfirmation("Values Parsed");
            
            ArrayList<String> values = new ArrayList<>();
            values.add(diagPanel.getPatientIDArea().getText());
            values.add(diagPanel.getClumpThicknessArea().getText());
            values.add(diagPanel.getUniformityCellSizeArea().getText());
            values.add(diagPanel.getUniformityCellShapeArea().getText());
            values.add(diagPanel.getMarginalAdhesionArea().getText());
            values.add(diagPanel.getSingleEpithelialCellSizeArea().getText());
            values.add(diagPanel.getBareNucleiArea().getText());
            values.add(diagPanel.getBlandChromatinArea().getText());
            values.add(diagPanel.getNormalNucleoliArea().getText());
            values.add(diagPanel.getMitosesArea().getText());
            values.add(diagPanel.getClassArea().getText());

            String[] v = new String[values.size()];
            for (int i = 0; i < values.size(); ++i) {
                v[i] = values.get(i);
            }
            Document xmlDocument = Parser.toXML(v);

            // write the content into xml file
            try {
                DOMSource source = new DOMSource(xmlDocument);
                FileWriter writer = new FileWriter(new File("/Users/thepuerprogrammer/Documents/dpp/UCO/cssem4/swe1/SE_Project/patient_results.xml"));
                StreamResult result = new StreamResult(writer);

                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                transformer.transform(source, result);
            } catch (Exception e2) {e2.printStackTrace();}

        } else if (b == diagPanel.getQuitButton()) {
            System.exit(0);
        }
    }
    
}
