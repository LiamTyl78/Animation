
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class CanvasPanel extends JPanel {
    public final static int X_CORNER = 25;
    public final static int Y_CORNER = 25;
    public final static int CANVAS_WIDTH = 600;
    public final static int CANVAS_HEIGHT = 600;

    private ArrayList<Shape2Di> shapes; // list of all the shapes

    private int frameNumber; // For animation, increases by 1 in each frame.
    private float pixelSize; // The size of a pixel in drawing coordinates.

    static boolean time;

    //random intgers used to set the x and y coordnates of trees and stars
    RandomInteger x = new RandomInteger(25, 550);
    RandomInteger y = new RandomInteger(50, 300);
    RandomInteger Xspeed = new RandomInteger(-2,2);
    RandomInteger YSpeed = new RandomInteger(1,3);

    public static void main(String[] args) {
        //P1();
        P2();
    }

    public CanvasPanel() {
        
        shapes = new ArrayList<Shape2Di>();
        if (time) {

            // Mountain
            int[] xCoords = { 25, 150, 200, 300, 400, 500, 625 };
            int[] yCoords = { 490, 390, 430, 350, 430, 300, 490 };
            shapes.add(new Polygon2Di(4, 0, -65, xCoords, yCoords)); // Mountain, shape 1
            
            y.SetMax(350);
            y.SetMin(300);
            shapes.add(new Circle2Di(8, 150, 140, 70)); // A yellow circle, shape 0
            shapes.add(new Rectangle2Di(5, 25, 425, 600, 200)); // Green rectangle, shape 1 
            
            //create 30 TreePoly2Di objects
            for (int i = 1; i < 30; i++) {
                shapes.add(new TreePoly2Di(1, x.Generate(), y.Generate()));
            }
            
            // construct snowman
            shapes.add(new Rectangle2Di(17, 275, 475, 40, 5));// Brown rectangle, shape 28 
            shapes.add(new Rectangle2Di(17, 340, 475, 40, 5));// Brown rectangle, shape 29
            shapes.add(new Circle2Di(16, 300, 500, 55)); // Snowman Base, shape 30
            shapes.add(new Circle2Di(16, 305, 465, 45)); // Snowman Middle, shape 31
            shapes.add(new Circle2Di(16, 310, 440, 35)); // Snowman Head, shape 32
            shapes.add(new Circle2Di(3, 320, 450, 5)); // Snowman Head, shape 33
            shapes.add(new Circle2Di(3, 330, 450, 5)); // Snowman Head, shape 34
            
            //Create 20 snowflakes
            for (int i = 39; i < 128; i++) {
                shapes.add(new StarPoly2Di(5, x.Generate(), 20));// star, shape 3
                shapes.get(i).SetZRotate(Xspeed.Generate());
            }
            for (int i = 39; i < 128; i++) {
                shapes.get(i).SetSpeed(Xspeed.Generate(), YSpeed.Generate());
            }

            new Timer(30, new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    frameNumber++;
                    // Snow
                    for (int i = 39; i < 128; i++) {
                        if (shapes.get(i).GetY() > 620 || shapes.get(i).GetX() > 615 || shapes.get(i).GetX() < 30) {
                            shapes.get(i).SetPos(x.Generate(), 20);
                            shapes.get(i).SetSpeed(Xspeed.Generate(), YSpeed.Generate());
                        }
                        shapes.get(i).SetPos(shapes.get(i).GetX() + shapes.get(i).GetXSpeed(), shapes.get(i).GetY() + shapes.get(i).GetYSpeed());
                        shapes.get(i).SetZRotate(shapes.get(i).GetZRotate() + 1);

                    }
                    repaint();
                }
            }).start();
        } else {
            y.SetMax(350);
            y.SetMin(300);
            shapes.add(new Circle2Di(8, 150, 140, 70)); // A yellow circle, shape 0
            shapes.add(new Rectangle2Di(5, 25, 425, 600, 200)); // Green rectangle, shape 1 
            //create 26 TreePoly2Di objects
            for (int i = 2; i < 30; i++) {
                shapes.add(new TreePoly2Di(1, x.Generate(), y.Generate()));
            }
            //snowman
            shapes.add(new Rectangle2Di(17, 275, 475, 40, 5));// Brown rectangle, shape 28 
            shapes.add(new Rectangle2Di(17, 340, 475, 40, 5));// Brown rectangle, shape 29
            shapes.add(new Circle2Di(16, 300, 500, 55)); // Snowman Base, shape 30
            shapes.add(new Circle2Di(16, 305, 465, 45)); // Snowman Middle, shape 31
            shapes.add(new Circle2Di(16, 310, 440, 35)); // Snowman Head, shape 32
            shapes.add(new Circle2Di(3, 320, 450, 5)); // Snowman Head, shape 33
            shapes.add(new Circle2Di(3, 330, 450, 5)); // Snowman Head, shape 34

        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g.setColor(Color.BLACK);
        g.fillRect(0, 0, CANVAS_WIDTH + 2 * X_CORNER, CANVAS_HEIGHT + 2 * Y_CORNER); // draw the black border
        if(time){
        g.setColor(Color.lightGray);
        }
        else{
            g.setColor(Color.lightGray);
        }
        g.fillRect(X_CORNER, Y_CORNER, CANVAS_WIDTH, CANVAS_HEIGHT); // make the canvas white

        // Render all the shapes in the shapes list
        for (int i = 0; i < shapes.size(); i++) {
            shapes.get(i).Draw(g);
        }
    }
    //returns canvas width
    public static int GetCanvasWidth() {
        return CANVAS_WIDTH;
    }
    //returns the height of the canvas
    public static int GetCanvasHeight() {
        return CANVAS_HEIGHT;
    }
    // returns the x corner
    public static int GetCanvasXBorder() {
        return X_CORNER;
    }
    // returns the y corner
    public static int GetCanvasYBorder() {
        return Y_CORNER;
    }

    public static void P1() {
        time = false;
        CanvasFrame f = new CanvasFrame();
    }

    public static void P2() {
        time = true;
        CanvasFrame f = new CanvasFrame();
    }
}
