package ar.edu.unlu.mstd.Ventana;

import javax.swing.*;
import java.awt.*;

public class JPanelCircular extends JPanel {
    private Color colorFondo;
    private int radioC = 15;
    public JPanelCircular(LayoutManager layout,int radio) {
        super(layout);
        radioC = radio;
    }
    public JPanelCircular(LayoutManager layout,int radio, Color color) {
        super(layout);
        radioC = radio;
        colorFondo = color;
    }

    public JPanelCircular(int radio,Color color) {
        radioC = radio;
        colorFondo = color;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Dimension arcs = new Dimension(radioC,radioC);
        int width = getWidth();
        int height = getHeight();
        Graphics2D graphics = (Graphics2D) g;
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        if (colorFondo != null){
            graphics.setColor(colorFondo);
        }else {
            graphics.setColor(getBackground());
        }
        graphics.fillRoundRect(0,0,width-1,height-1, arcs.width, arcs.height);
        graphics.setColor(getForeground());
    }
}
