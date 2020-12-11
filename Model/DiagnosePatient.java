package Model;

import java.util.ArrayList;

public class DiagnosePatient {

    // PRIVATE VALUES
    ///////////////////////////////////////////////////////////////////////////////////////
    private ArrayList<Integer> patientResultsArray;

    private int counter = 0;
    private int classification;
    ///////////////////////////////////////////////////////////////////////////////////////


    // CONSTRUCTOR REQUIRES ACTIVE PATIENT
    ///////////////////////////////////////////////////////////////////////////////////////
    public DiagnosePatient(Patient patient) {

        patientResultsArray = new ArrayList<>();
        patientResultsArray.add(patient.getClumpThickness());
        patientResultsArray.add(patient.getUniformityCellShape());
        patientResultsArray.add(patient.getUniformityCellSize());
        patientResultsArray.add(patient.getMarginalAdhesion());
        patientResultsArray.add(patient.getSingleEpithelialCellSize());
        patientResultsArray.add(patient.getBareNuclei());
        patientResultsArray.add(patient.getBlandChromatin());
        patientResultsArray.add(patient.getNormalNucleoli());
        patientResultsArray.add(patient.getMitoses());
        patientResultsArray.add(patient.getClassVal());

    }
    ///////////////////////////////////////////////////////////////////////////////////////


    // CLASSIFICATION OFF OF PATIENT RESULT DATA HAVING >= 5 RESULTS OF VALUES >= 5
    ///////////////////////////////////////////////////////////////////////////////////////
    public void diagnose() {

        for (int i = 0; i < patientResultsArray.size(); i ++) {
            if (patientResultsArray.get(i) >= 5) {
                counter++;
            }
        }
        
        if (counter >= 5) {
            classification = 4;
            counter = 0;
        } else {
            classification = 2;
            counter = 0;
        }

    }
    ///////////////////////////////////////////////////////////////////////////////////////


    // GETTERS AND SETTERS
    ///////////////////////////////////////////////////////////////////////////////////////
    public int getClassification() {
        return classification;
    }

    public void getpatientResultsArray() {
        for (var e: patientResultsArray) {
            System.out.println(e);
        }
    }
    
    public void setpatientResultsArray(ArrayList<Integer> patientResultsArray) {
        this.patientResultsArray = patientResultsArray;
    }
    ///////////////////////////////////////////////////////////////////////////////////////
}
