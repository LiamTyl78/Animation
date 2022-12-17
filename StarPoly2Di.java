
public class StarPoly2Di extends Polygon2Di{
        // instance variables
        private static int[] xCoords = { 0, 2, 10, 2, 0, -2, -10, -2 };
        private static int[] yCoords = { -10, -2, 0, 2, 10, 2, 0, -2 };

        /**
         * Constructor for objects of class StarPoly2Di
         */
        public StarPoly2Di(int colorIndex, int xPosition, int yPosition) {
            super(colorIndex, xPosition, yPosition, xCoords, yCoords);
        }
    }
