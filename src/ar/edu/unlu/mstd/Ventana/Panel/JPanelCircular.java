package ar.edu.unlu.mstd.Ventana.Panel;

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
        double valor = (posA  % 1000);
        double fraccion = valor / 1000;
        //calculo una fraccion y le hago raiz porque si calculaba la distancia en base al numero aleatorio
        //y el radio se generaba una espiral y quedaban muchos lugares espaciados
        double pos = radio * Math.sqrt(fraccion);
        //int distancia = (posA % radio);
        int x = (int) ((centerX + pos * Math.cos(angulo)));
        int y = (int) ((centerY + pos * Math.sin(angulo)));
        comp.setBounds(x,y,5,10);
        return super.add(comp);
    }
    public Component addFCirculo(Component comp,int posA) {
        int radio = Math.min(getWidth(),getHeight()) / 2;
        int centerX = getWidth()/2;
        int centerY = getHeight()/2;
        //calculo la distancia total del cuadrado
        int maxDistancia = (int) (Math.sqrt((getWidth() * getWidth() + getHeight() * getHeight())) / 2);

        double angulo = Math.toRadians(posA % 360);
        //reduzco el angulo al primer cuadrante
        if (angulo > 210){
            angulo = angulo/4;
        } else if (angulo > 180) {
            angulo = angulo/3;
        } else if (angulo > 90) {
            angulo = angulo/2;
        }
        //calculo la distancia del angulo actual con el de 45 grados y decremento la maxima distancia
        int distanciaEsquina = 0;
        if (angulo < 45){
            distanciaEsquina = (int) (45 - angulo);
        }else {
            distanciaEsquina = (int) (angulo - 45);
        }
        int decremento = distanciaEsquina;
        /*if (distanciaEsquina > 5) {
             decremento= (distanciaEsquina - 5);
             maxDistancia = maxDistancia - decremento;
        }*/

        maxDistancia = maxDistancia - decremento;
        int distanciaX = radio + (posA % (maxDistancia - radio ));
        int distanciaY = radio + (posA % (maxDistancia - radio ));

        int x = (int) (centerX + distanciaX * Math.cos(angulo));
        int y = (int) (centerY + distanciaY * Math.sin(angulo));
        comp.setBounds(x,y,5,10);
        return super.add(comp);
    }
}
