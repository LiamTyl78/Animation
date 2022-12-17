import java.awt.Graphics;

public class Circle2Di extends Shape2Di{
    private int Diameter;
    
    // Constructor for Circle2Di
    Circle2Di(int fillColorIndex, int xPos, int yPos, int Diameter){
        super(fillColorIndex,xPos,yPos);
        this.Diameter = Diameter;
    }
    // Returns diameter
    int GetDiameter(){
        return Diameter;
    }
    //Draws circle based on parameters
    @Override
    public void Draw(Graphics g) {
        if(super.getFill()){
            g.setColor(super.getColor());
            g.fillOval(super.GetX(), super.GetY(), this.Diameter, this.Diameter);
        }
        if(super.getOutline()){
            g.setColor(super.getOutlineColor());
            g.drawOval(super.GetX(), super.GetY(), this.Diameter, this.Diameter);
        }
    }
}
