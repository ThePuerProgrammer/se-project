import javax.swing.JFrame;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import View.DiagPanel;

public class Main{
    private static final Logger log = LogManager.getLogger(Main.class);
    public static void main(String [] args){
        
        log.info("Program starting");

        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setTitle("Cancer Diagnosis Program");

        var DiagPanel = new DiagPanel(window);
        DiagPanel.init();

        window.setResizable(false);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
}