package Model;

import java.util.ArrayList;

public class Patient {

    // PRIVATE VALUES
    ///////////////////////////////////////////////////////////////////////////////////////
    private int patientID;
    private int clumpThickness;
    private int uniformityCellSize;
    private int uniformityCellShape;
    private int marginalAdhesion;
    private int singleEpithelialCellSize;
    private int bareNuclei;
    private int blandChromatin;
    private int normalNucleoli;
    private int mitoses;
    private int classVal;
    ///////////////////////////////////////////////////////////////////////////////////////


    // CONSTRUCTORS
    ///////////////////////////////////////////////////////////////////////////////////////
    public Patient() {
        this(0);
    }

    public Patient(int patientID) {
        this(patientID, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
    }

    public Patient(int patientID, 
                   int clumpThickness, 
                   int uniformityCellShape, 
                   int uniformityCellSize, 
                   int marginalAdhesion, 
                   int singleEpithelialCellSize, 
                   int bareNuclei, 
                   int blandChromatin, 
                   int normalNucleoli, 
                   int mitoses, 
                   int classVal) {

        this.patientID = patientID;
        this.clumpThickness = clumpThickness;
        this.uniformityCellShape = uniformityCellShape;
        this.uniformityCellSize = uniformityCellSize;
        this.marginalAdhesion = marginalAdhesion;
        this.singleEpithelialCellSize = singleEpithelialCellSize;
        this.bareNuclei = bareNuclei;
        this.blandChromatin = blandChromatin;
        this.normalNucleoli = normalNucleoli;
        this.mitoses = mitoses;
        this.classVal = classVal;
    }
    ///////////////////////////////////////////////////////////////////////////////////////


    // SET ALL VALUES WITH INPUTS
    ///////////////////////////////////////////////////////////////////////////////////////
    public void setPatientResults(int patientID, 
                                  int clumpThickness, 
                                  int uniformityCellShape, 
                                  int uniformityCellSize, 
                                  int marginalAdhesion, 
                                  int singleEpithelialCellSize, 
                                  int bareNuclei, 
                                  int blandChromatin, 
                                  int normalNucleoli, 
                                  int mitoses, 
                                  int classVal) {

        this.patientID = patientID;
        this.clumpThickness = clumpThickness;
        this.uniformityCellShape = uniformityCellShape;
        this.uniformityCellSize = uniformityCellSize;
        this.marginalAdhesion = marginalAdhesion;
        this.singleEpithelialCellSize = singleEpithelialCellSize;
        this.bareNuclei = bareNuclei;
        this.blandChromatin = blandChromatin;
        this.normalNucleoli = normalNucleoli;
        this.mitoses = mitoses;
        this.classVal = classVal;
    }
    ///////////////////////////////////////////////////////////////////////////////////////


        // SET ALL VALUES WITH INPUTS
    ///////////////////////////////////////////////////////////////////////////////////////
    public void setPatientResults(ArrayList<String> v) {

        assert(v.size() == 11);

        this.patientID = Integer.parseInt(v.get(0));
        this.clumpThickness = Integer.parseInt(v.get(1));
        this.uniformityCellShape = Integer.parseInt(v.get(2));
        this.uniformityCellSize = Integer.parseInt(v.get(3));
        this.marginalAdhesion = Integer.parseInt(v.get(4));
        this.singleEpithelialCellSize = Integer.parseInt(v.get(5));
        this.bareNuclei = Integer.parseInt(v.get(6));
        this.blandChromatin = Integer.parseInt(v.get(7));
        this.normalNucleoli = Integer.parseInt(v.get(8));
        this.mitoses = Integer.parseInt(v.get(9));
        this.classVal = Integer.parseInt(v.get(10));
    }
    ///////////////////////////////////////////////////////////////////////////////////////


    // SETTERS AND GETTERS
    ///////////////////////////////////////////////////////////////////////////////////////
    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }

    public void setClumpThickness(int clumpThickness) {
        this.clumpThickness = clumpThickness;
    }

    public void setUniformityCellShape(int uniformityCellShape) {
        this.uniformityCellShape = uniformityCellShape;
    }

    public void setUniformityCellSize(int uniformityCellSize) {
        this.uniformityCellSize = uniformityCellSize;
    }

    public void setMarginalAdhesion(int marginalAdhesion) {
        this.marginalAdhesion = marginalAdhesion;
    }

    public void setSingleEpithelialCellSize(int singleEpithelialCellSize) {
        this.singleEpithelialCellSize = singleEpithelialCellSize;
    }

    public void setBareNuclei(int bareNuclei) {
        this.bareNuclei = bareNuclei;
    }

    public void setBlandChromatin(int blandChromatin) {
        this.blandChromatin = blandChromatin;
    }

    public void setNormalNucleoli(int normalNucleoli) {
        this.normalNucleoli = normalNucleoli;
    }

    public void setMitoses(int mitoses) {
        this.mitoses = mitoses;
    }

    public void setClassVal(int classVal) {
        this.classVal = classVal;
    }

    public int getPatientID() {
        return patientID;
    }

    public int getClumpThickness() {
        return clumpThickness;
    }

    public int getUniformityCellShape() {
        return uniformityCellShape;
    }

    public int getUniformityCellSize() {
        return uniformityCellSize;
    }

    public int getMarginalAdhesion() {
        return marginalAdhesion;
    }

    public int getSingleEpithelialCellSize() {
        return singleEpithelialCellSize;
    }

    public int getBareNuclei() {
        return bareNuclei;
    }

    public int getBlandChromatin() {
        return blandChromatin;
    }

    public int getNormalNucleoli() {
        return normalNucleoli;
    }

    public int getMitoses() {
        return mitoses;
    }

    public int getClassVal() {
        return classVal;
    }
    ///////////////////////////////////////////////////////////////////////////////////////

}
