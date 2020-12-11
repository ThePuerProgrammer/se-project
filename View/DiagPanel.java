package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import Controller.JButtonListener;
import Model.Parser;
import tcp_connect.MyServer;

public class DiagPanel {

    private Color background = new Color(10, 40, 50);
    public static final int WIDTH = 1000;
    public static final int HEIGHT = 1000;
    private JFrame window;    
    private JButton connectButton;
    private JButton diagnoseButton;
    private JButton deliverResultsButton;
    private JButton quitButton;
    private Dimension buttonDimension = new Dimension(150, 50);
    private JButtonListener jButtonListener;
    private DiagnoseCanvas leftCanvas;
    private UploadCanvas rightCanvas;
    private MyServer myServer;
    private JTextArea patientIDArea;
    private JTextArea clumpThicknessArea;
    private JTextArea uniformityCellSizeArea;
    private JTextArea uniformityCellShapeArea;
    private JTextArea marginalAdhesionArea;
    private JTextArea singleEpithelialCellSizeArea;
    private JTextArea bareNucleiArea;
    private JTextArea blandChromatinArea;
    private JTextArea normalNucleoliArea;
    private JTextArea mitosesArea;
    private JTextArea classArea;

    public DiagPanel(JFrame window) {
        this.window = window;
        diagnoseButton = new JButton("Establish Connection");
        deliverResultsButton = new JButton("Diagnose User");
        quitButton = new JButton("Quit");
        jButtonListener = new JButtonListener(this);
        diagnoseButton.addActionListener(jButtonListener);
        deliverResultsButton.addActionListener(jButtonListener);
        quitButton.addActionListener(jButtonListener);
        leftCanvas = new DiagnoseCanvas(this);
        rightCanvas = new UploadCanvas(this);
        patientIDArea = new JTextArea("Patient ID");
        clumpThicknessArea = new JTextArea("Clump Thickness");
        uniformityCellSizeArea = new JTextArea("Uniformity Cell Size");
        uniformityCellShapeArea = new JTextArea("Uniformity Cell Shape");
        marginalAdhesionArea = new JTextArea("Marginal Adhesion");
        singleEpithelialCellSizeArea = new JTextArea("Single Epithelial Cell Size");
        bareNucleiArea = new JTextArea("Bare Nuclei");
        blandChromatinArea = new JTextArea("Bland Chromatin");
        normalNucleoliArea = new JTextArea("Normal Nucleoli");
        mitosesArea = new JTextArea("Mitoses");
        classArea = new JTextArea("Class");
    }

    public void init() {

        myServer = new MyServer();

        Container cp = window.getContentPane();

        JPanel eastPanel = new JPanel();
        eastPanel.setPreferredSize(new Dimension(WIDTH / 3 + 200, HEIGHT / 2 + 100));
        eastPanel.setBackground(background);
        JPanel westPanel = new JPanel();
        westPanel.setPreferredSize(new Dimension(WIDTH / 3 + 200, HEIGHT / 2 + 100));
        westPanel.setBackground(background);
        JPanel southPanel = new JPanel();
        southPanel.setPreferredSize(new Dimension(WIDTH, HEIGHT / 8));
        southPanel.setBackground(background);
        JPanel textArePanel = new JPanel();
        textArePanel.setLayout(new GridLayout(2, 6));
        textArePanel.add(patientIDArea);
        textArePanel.add(clumpThicknessArea);
        textArePanel.add(uniformityCellSizeArea);
        textArePanel.add(uniformityCellShapeArea);
        textArePanel.add(marginalAdhesionArea);
        textArePanel.add(singleEpithelialCellSizeArea);
        textArePanel.add(bareNucleiArea);
        textArePanel.add(blandChromatinArea);
        textArePanel.add(normalNucleoliArea);
        textArePanel.add(mitosesArea);
        textArePanel.add(classArea);

        southPanel.add(BorderLayout.NORTH, textArePanel);
        diagnoseButton.setPreferredSize(buttonDimension);
        southPanel.add(diagnoseButton);
        deliverResultsButton.setPreferredSize(buttonDimension);
        southPanel.add(deliverResultsButton);
        quitButton.setPreferredSize(buttonDimension);
        southPanel.add(quitButton);

        westPanel.add(leftCanvas);
        eastPanel.add(rightCanvas);

        cp.add(BorderLayout.EAST, eastPanel);
        cp.add(BorderLayout.WEST, westPanel);
        cp.add(BorderLayout.SOUTH, southPanel);
    }
    public JButton getDeliverResultsButton() {
        return deliverResultsButton;
    }

    public JButton getDiagnoseButton() {
        return diagnoseButton;
    }

    public JButton getQuitButton() {
        return quitButton;
    }

    public DiagnoseCanvas getLeftCanvas() {
        return leftCanvas;
    }

    public UploadCanvas getRightCanvas() {
        return rightCanvas;
    }

    public JTextArea getBareNucleiArea() {
        return bareNucleiArea;
    }

    public JTextArea getBlandChromatinArea() {
        return blandChromatinArea;
    }

    public JTextArea getClassArea() {
        return classArea;
    }

    public JTextArea getClumpThicknessArea() {
        return clumpThicknessArea;
    }

    public JTextArea getMarginalAdhesionArea() {
        return marginalAdhesionArea;
    }

    public JTextArea getMitosesArea() {
        return mitosesArea;
    }

    public JTextArea getNormalNucleoliArea() {
        return normalNucleoliArea;
    }

    public JTextArea getPatientIDArea() {
        return patientIDArea;
    }

    public JTextArea getSingleEpithelialCellSizeArea() {
        return singleEpithelialCellSizeArea;
    }

    public JTextArea getUniformityCellShapeArea() {
        return uniformityCellShapeArea;
    }

    public JTextArea getUniformityCellSizeArea() {
        return uniformityCellSizeArea;
    }
}