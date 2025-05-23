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

    public Component addCirculo(Component comp,int posA) {
        int radio = Math.min(getWidth(),getHeight()) / 2;

        int centerX = getWidth()/2;
        int centerY = getHeight()/2;
        double angulo = Math.toRadians(posA % 360);
        int distancia = (posA % radio);
        int x = (int) ((centerX + distancia * Math.cos(angulo)));
        int y = (int) ((centerY + distancia * Math.sin(angulo)));
        comp.setBounds(x,y,5,5);
        return super.add(comp);
    }
    public Component addFCirculo(Component comp,int posA) {
        //int [] angulosPosibles = {45,135,225,315};

        int radio = Math.min(getWidth(),getHeight()) / 2;
        int diferenciaX = getWidth() - radio;
        int diferenciaY = getHeight() - radio;
        int centerX = getWidth()/2;
        int centerY = getHeight()/2;
        int maxDistancia = (int) (Math.sqrt((getWidth() * getWidth() + getHeight() * getHeight())) / 2);
        //int area = (int) ((getWidth() * getHeight())- (Math.PI * Math.pow(radio,2)));
        int maxX = Math.min(centerX, getWidth() - centerX);
        int maxY = Math.min(centerY, getHeight() - centerY);
        int distanciaMax = Math.min(maxX, maxY);
        //double angulo = Math.toRadians(angulosPosibles[posA % angulosPosibles.length]);
        double angulo = Math.toRadians(posA % 360);
        int cos = (int) Math.cos(angulo);
        int sin = (int) Math.sin(angulo);
        if (angulo > 210){
            angulo = angulo/4;
        } else if (angulo > 180) {
            angulo = angulo/3;
        } else if (angulo > 90) {
            angulo = angulo/2;
        }
        int distanciaEsquina = 0;
        if (angulo < 45){
            distanciaEsquina = (int) (45 - angulo);
        }else {
            distanciaEsquina = (int) (angulo - 45);
        }
        int decremento = 0;
        if (distanciaEsquina > 5) {
             decremento= (distanciaEsquina - 5);
             maxDistancia = maxDistancia - decremento;
        }

        int distanciaX = radio + (posA % (maxDistancia - radio ));
        int distanciaY = radio + (posA % (maxDistancia - radio ));

        int x = (int) (centerX + distanciaX * Math.cos(angulo));
        int y = (int) (centerY + distanciaY * Math.sin(angulo));
        comp.setBounds(x,y,10,10);
        return super.add(comp);
    }
}
