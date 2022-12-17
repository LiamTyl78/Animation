//Liam Tyler
import java.awt.*;

//Shape2Di Parameters
public abstract class Shape2Di {
    private int xPos; // xPos
    private int yPos; // yPos
    private int xVel;
    private int yVel;
    private boolean fill;
    private Color fillcolor;
    private int fillColorIndex;
    private boolean outline;
    private Color outlineColor;
    private int outlineColorIndex;
    private double Zrot;
    private double ScaleX;
    private double ScaleY;

    // RGB color table
    public static final Color[] COLORS = {
            // R G B
            new Color(255, 0, 0), // Red 0
            new Color(0, 255, 0), // Green 1
            new Color(0, 0, 255), // Blue 2
            new Color(0, 0, 0), // Black 3
            new Color(128, 128, 128), // Grey 4
            new Color(255, 255, 255), // White 5
            new Color(255, 38, 38),//6 Red
            new Color(255, 168, 38),//7 Orange
            new Color(212, 255, 38),//8 Yellow
            new Color(82, 255, 38),//9 Green
            new Color(38, 255, 125),//10 Lime Green
            new Color(38, 255, 255),//11 Cyan
            new Color(38, 125, 255),//12 Light Blue
            new Color(82, 38, 255),//13 Violet
            new Color(212, 38, 255),//14 Purple
            new Color(255, 38, 168),//15 Pink
            new Color(237, 237, 237),//16 Very Light Grey
            new Color(115, 60, 5), // 17 Brown
            new Color(5, 87, 42),//18
            new Color(7, 97, 47),//19
            new Color(9, 135, 65),//20
    };

//Constructor for Shape2Di
    public Shape2Di(int fillColorIndex, int xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.fill = true;
        this.outline = false;
        
        this.fillColorIndex = fillColorIndex;
        this.fillcolor = COLORS[fillColorIndex];
        
        this.outlineColorIndex = 3;
        this.outlineColor = COLORS[3];

        this.ScaleX = 1;
        this.ScaleY = 1;
        this.Zrot = 0;
    }

    void Animate() {
        xPos += xVel;
        yPos += yVel;
    }

    abstract void Draw(Graphics g);

    boolean getFill() {
        return fill;
    }

    Color getColor(){
        return fillcolor;
    }
    //returns index of the color of the fill color
    int getFillColorIndex(){
        return fillColorIndex;
    }
    //returns whether or not the outline should be drawn or not
    boolean getOutline(){
        return outline;
    }
    //returns the color of the outline
    Color getOutlineColor(){
        return outlineColor;
    }
    //returns index of the color of the outline
    int getOutlineColorIndex(){
        return outlineColorIndex;
    }
    //returns current x posistion
    int GetX(){
        return xPos;
    }
    //returns current x velocity
    int GetXSpeed(){
        return xVel;
    }
    //returns current y posistion
    int GetY(){
        return yPos;
    }
    //returns current y velocity
    int GetYSpeed(){
        return yVel;
    }
    //returns current rotation
    double GetZRotate(){
        return Zrot;
    }
    //changes the rotation of the 
    void SetZRotate(double ZRotate){
        this.Zrot = ZRotate;
    }
    //returns x scale factor
    double GetScaleX(){
        return ScaleX;
    }
    //returns y scale factor
    double GetScaleY(){
        return ScaleY;
    }
    //sets the x and y scale factors to the size indicated
    void SetScale(double ScaleX, double ScaleY){
        this.ScaleX = ScaleX;
        this.ScaleY = ScaleY;
    }
    //changes the x and y posistion based on the amount specified
    void Move(double xDelta, double yDelta){  
        xPos += xDelta;
        yPos += yDelta;
    }
    //boolean for whether or not to fill the shape in
    void SetFill(boolean setting){
        this.fill = setting;
    }
    //sets the fill color of the shape
    void SetFillColor(int fillColorIndex){
        this.fillColorIndex = fillColorIndex;
    }
    //determines whether or not to render an outline
    void SetOutline(boolean setting){
        this.outline = setting;
    }
    //sets the outline color of the shape
    void SetOutlineColor(int OutlineColorIndex){
        this.outlineColorIndex = OutlineColorIndex;
    }
    //sets the x and y posistion of the shpae based on inputs in parameters
    void SetPos(int x, int y){
        xPos = x;
        yPos = y;
    }
    //sets the velocity of the object on the x and y axis
    void SetSpeed(int xV, int yV){
        xVel = xV;
        yVel = yV;
    }
}
