
public class TreePoly2Di extends Polygon2Di{
    // instance variables
    private static int[] xCoords = { 21, 37, 2, 42, 8, 158, 123, 156, 120, 148, 83};
    private static int[] yCoords = { 132, 132, 210, 210, 283, 283, 210, 210, 132, 132, 3};

    /**
     * Constructor for objects of class TreePoly2Di
     */
    static RandomInteger color = new RandomInteger(18,20);
    
    public TreePoly2Di(int colorIndex, int xPosition, int yPosition) {
        super(color.Generate(), xPosition, yPosition, xCoords, yCoords);
        this.SetScale(0.5, 0.5);
    }
}
