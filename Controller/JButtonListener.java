package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;

import Model.PatientUser;
import Model.XMLDocBuilder;
import View.DiagPanel;

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
