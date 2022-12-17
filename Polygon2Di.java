//Liam Tyler
import java.awt.Graphics;

public class Polygon2Di extends Shape2Di {
    int[] txCoords;
    int[] tyCoords;
    int[] xCoords;
    int[] yCoords;
    // Polygon2Di Constructor
    Polygon2Di(int fillColorIndex, int xPos, int yPos, int[] xCoords, int[] yCoords) {
        super(fillColorIndex, xPos, yPos);
        this.xCoords = new int[xCoords.length];
        this.yCoords = new int[yCoords.length];
        this.txCoords = new int[xCoords.length];
        this.tyCoords = new int[yCoords.length];

        for (int i = 0; i < xCoords.length; i++) {
            this.xCoords[i] = xCoords[i];
            this.txCoords[i] = xCoords[i] + xPos;
        }
        for (int i = 0; i < yCoords.length; i++) {
            this.yCoords[i] = yCoords[i];
            this.tyCoords[i] = yCoords[i] + yPos;
        }
    }
    //Method for transforming rotating and chainging the scale of a polygon 
    private void Transform() {
        double degs = super.GetZRotate();
        double rads = Math.toRadians(degs);
        double Sx = super.GetScaleX();
        double Sy = super.GetScaleY();
        for (int i = 0; i < xCoords.length; i++) {
            int x = (int) ((Sx * this.xCoords[i]) + 0.5);
            int y = (int) ((Sy * this.yCoords[i]) + 0.5);
            this.txCoords[i] = ((int) ((x * Math.cos(rads) - y *
                    Math.sin(rads)) + 0.5)) + super.GetX();
            this.tyCoords[i] = ((int) ((x * Math.sin(rads) + y *
                    Math.cos(rads)) + 0.5)) + super.GetY();
        }
    }
    //Draws Polygon2Di
    @Override
    public void Draw(Graphics g) {
        Transform();
        if (getFill()) {
            g.setColor(super.getColor());
            g.fillPolygon(txCoords, tyCoords, xCoords.length);
        }
        if (getOutline()) {
            g.setColor(super.getOutlineColor());
            g.fillPolygon(txCoords, tyCoords, xCoords.length);
        }
    }
    
}
