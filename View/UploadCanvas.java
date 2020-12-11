package View;

import java.awt.Color;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class UploadCanvas extends JPanel {

    private static final long serialVersionUID = 1L;
    private DiagPanel diagPanel;

    private String confirmation = "";
    
    public UploadCanvas(DiagPanel diagPanel) {
        this.diagPanel = diagPanel;
        setPreferredSize(new Dimension(DiagPanel.WIDTH / 3 + 100, (int)(DiagPanel.HEIGHT / 2 + 90)));
        setBackground(Color.BLACK);
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(Color.GREEN);
        g2.drawString(confirmation, 135, 20);
    }


    public String getConfirmation() {
        return confirmation;
    }

    public void setConfirmation(String confirmation) {
        this.confirmation = confirmation;
    }
}