//Liam Tyler
import java.awt.Graphics;

public class Rectangle2Di extends Shape2Di{
    private int height;
    private int width;
    //Constructor for Rectangle2Di
    Rectangle2Di(int fillColorIndex, int xPos, int yPos, int width, int height){
        super(fillColorIndex,xPos,yPos);
        this.height = height;
        this.width = width;
    }
    //Returns the height of the rectangle
    int GetHeight(){
        return height;
    }
    //Returns the width of the rectangle
    int GetWidth(){
        return width;
    }
    //Draws Rectangle2Di
    @Override
    public void Draw(Graphics g) {
        if(super.getFill()){
            g.setColor(super.getColor());
            g.fillRect(super.GetX(), super.GetY(), this.width, this.height);
        }
        if(super.getOutline()){
            g.setColor(super.getOutlineColor());
            g.fillRect(super.GetX(), super.GetY(), this.width, this.height);
        }
    }
}
