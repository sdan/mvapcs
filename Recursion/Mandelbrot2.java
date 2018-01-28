import java.awt.*;

import javax.swing.*;

import java.awt.event.*;


class ComplexNumber {

    public final double real, imaginary;


    public ComplexNumber(double real, double imaginary)  {

        this.real = real;

        this.imaginary = imaginary;

    }


    public ComplexNumber()  { this(0,0); }

    public ComplexNumber(ComplexNumber cn)  { this(cn.real, cn.imaginary); }


    public ComplexNumber add(ComplexNumber x) {

        return new ComplexNumber(real + x.real, imaginary + x.imaginary);

    }


    public ComplexNumber multiply (ComplexNumber x) {

        return new ComplexNumber(

            (real * x.real) - (imaginary * x.imaginary),

            (real * x.imaginary) + (imaginary * x.real)

        );

    }


    public double getMagnitude() { return Math.sqrt(real*real + imaginary*imaginary); }


    public String toString (){ return real + "+" + imaginary + "i"; }           

}


class MandelbrotCanvas1 extends Canvas{

    boolean draw = false;

    final int size = 600;

    final int depth = 255;

    ComplexNumber[][] cnSet = new ComplexNumber[size][size];


    MandelbrotCanvas1(){

         double lx = -1.5;

         double ly = -1.25;

         double ux = 0.5;

         double uy = 1.25;

         double xStep = (ux - lx)/size;

         double yStep = (uy - ly)/size;

        for( int i = 0; i < size; i ++){

            for (int j = 0; j < size; j++){

                cnSet[i][j] = new ComplexNumber(lx + i*xStep, uy - j*yStep);

            }

        }


    }



    public void paint(Graphics g){

        if (draw){

            for (int i = 0; i < size; i++){

                for (int j = 0; j < size; j++){

                    int iterations = getIterations(cnSet[i][j]);

                    g.setColor((iterations==depth) ? Color.BLACK : new Color(180, (iterations*2) % 254, 0) );

                    g.fillRect(i ,j ,1,1);

                }

            }


        }

    }


    private int getIterations(ComplexNumber c){

        ComplexNumber z = new ComplexNumber();

        int iterations = 0;

        for(; iterations < depth; iterations++) {

            if (z.getMagnitude() > 2 ){ break; }

            z = z.multiply(z).add(c);

        }

        return iterations;

    }


    public void draw(){

        draw = true;

    }


}



class MandelbrotFrame extends JFrame implements ActionListener {

    MandelbrotCanvas1 rtc;

    JButton startButton;

    Container c;


    MandelbrotFrame(){

        super("Dragon");

        addComponents();

        setSize(800,500);

    }


    public void addComponents(){

        c = getContentPane();

        c.setLayout(null);


        rtc = new MandelbrotCanvas1();

        rtc.setBackground(Color.GRAY);

        startButton = new JButton("Dragon!!!");

        startButton.addActionListener(this);


        c.add(rtc);

        c.add(startButton);

        rtc.setBounds(0,0,600,600);

        startButton.setBounds(650,50,100,50);

    }


    public void actionPerformed(ActionEvent e){

        if (e.getSource() == startButton){

            rtc.draw();

            rtc.repaint();

        }

    }

}


public class Mandelbrot2 {

    public static void main(String[] args){

        JFrame frame = new MandelbrotFrame();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);

    }

}
