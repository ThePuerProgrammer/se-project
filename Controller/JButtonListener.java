package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;

import Model.DiagnosePatient;
import Model.Patient;
import Model.XMLDocBuilder;
import Model.XMLPatientDataParser;
import View.DiagPanel;

public class JButtonListener implements ActionListener {

    private DiagPanel diagPanel;
    private ArrayList<String> ips = new ArrayList<>();

    public JButtonListener(DiagPanel diagPanel) {
        this.diagPanel = diagPanel;
        ips.add("23.123.213.59"); // blake
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        JButton b = (JButton) e.getSource();

        if (b == diagPanel.getEstablishServerButton()) {

        } else if (b == diagPanel.getestablishConnectionButton()) {

        } else if (b == diagPanel.getDiagnosePatientDataButton()) {

            diagPanel.getLeftCanvas().getStringArrayList().add("Parsing data from /doc/patient_diagnosis_data.xml");

            XMLPatientDataParser xmlPatientDataParser = new XMLPatientDataParser();
            xmlPatientDataParser.parse();

            diagPanel.getLeftCanvas().getStringArrayList().add("Establishing Patient");
            Patient patient = new Patient();
            patient.setPatientResults(xmlPatientDataParser.getParsedData());

            diagPanel.getLeftCanvas().getStringArrayList().add("Processing Diagnosis");
            DiagnosePatient diagnosePatient = new DiagnosePatient(patient);
            diagnosePatient.diagnose();
            String result = diagnosePatient.getClassification() == 4 ? "Cancerous" : "Benign";


            diagPanel.getLeftCanvas().getStringArrayList().add("Diagnosis Complete");
            diagPanel.getLeftCanvas().getStringArrayList().add("Results: " + result);

            diagPanel.getLeftCanvas().repaint();

        }else if (b == diagPanel.getgenerateXMLFromPatientDataButton()) {

            diagPanel.getRightCanvas().getStringArrayList().add("Values Submitted");
            
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

            XMLDocBuilder xmlDocBuilder = new XMLDocBuilder(values);
            xmlDocBuilder.buildAndSaveXMLDoc();

            diagPanel.getRightCanvas().getStringArrayList().add(".xml generated in /doc/patient_diagnosis_data.xml");

            diagPanel.getRightCanvas().repaint();

        } else if (b == diagPanel.getQuitButton()) {
            System.exit(0);
        }
    }
    
}
