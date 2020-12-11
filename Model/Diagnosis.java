package Model;

import java.util.ArrayList;

public class Diagnosis {
    
    private ArrayList<Integer> values;
    private int counter = 0;
    private int classification;

    public Diagnosis(ArrayList<Integer> values) {
        this.values = values;
    }

    public void Diagnose() {

        for (int i = 0; i < values.size(); i ++) {
            if (values.get(i) >= 5) {
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

    public int getClassification() {
        return classification;
    }

    public void getValues() {
        for (var e: values) {
            System.out.println(e);
        }
    }
    
    public void setValues(ArrayList<Integer> values) {
        this.values = values;
    }
}
