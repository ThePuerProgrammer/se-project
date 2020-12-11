package Test;

import java.util.ArrayList;

import Model.Diagnosis;
import Model.Parser;

public class Test {
    
    public static void main(String[] args){
        Parser parsing = new Parser();
        parsing.parseEm(); //sucess

        Diagnosis diag = new Diagnosis(parsing.getValues());
        diag.Diagnose();
        System.out.println("Classification is : " + diag.getClassification()); //success
        diag.getValues(); //success

        ArrayList<Integer> testing = new ArrayList<>();
        int tester = 3;
        for(int i = 0; i < 10; i++){
        testing.add(tester);
        tester++;
       }
        Diagnosis diagTwo = new Diagnosis(testing);
        diagTwo.Diagnose();
        diagTwo.getValues();
        System.out.println("Classification is : " + diagTwo.getClassification()); 
      
        // all tests passed
    }

}
