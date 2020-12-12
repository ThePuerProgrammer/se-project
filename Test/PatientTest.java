package Test;

import java.util.ArrayList;

import Model.Patient;

public class PatientTest {
    public static void main(String[] args) {
        Patient patient = new Patient();
        ArrayList<String> stringInts = new ArrayList<>();
        for (int i = 0; i < 11; i++) {
            stringInts.add(String.valueOf(i));
        }
        patient.setPatientResults(stringInts);

        assert(patient.getPatientID() == 0);
        assert(patient.getClumpThickness() == 1);
        assert(patient.getUniformityCellShape() == 2);
        assert(patient.getUniformityCellSize() == 3);
        assert(patient.getMarginalAdhesion() == 4);
        assert(patient.getSingleEpithelialCellSize() == 5);
        assert(patient.getBareNuclei() == 6);
        assert(patient.getBlandChromatin() == 7);
        assert(patient.getNormalNucleoli() == 8);
        assert(patient.getMitoses() == 9);
        assert(patient.getClassVal() == 10);
    }
}
