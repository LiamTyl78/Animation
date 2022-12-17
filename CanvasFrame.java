
import javax.swing.*;
import java.awt.*;

public class CanvasFrame 
{
    private JFrame                frame;    // the window
    private CanvasPanel           canvas;   // the canvas we'll be drawing on
    
    /**
     * Creates a new CanvasFrame object.
     */

    public CanvasFrame()
    {
        frame = new JFrame("Canvas Frame"); //make the JFrame 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        canvas = new CanvasPanel();
        canvas.setPreferredSize(new Dimension(2 * CanvasPanel.X_CORNER + CanvasPanel.CANVAS_WIDTH, 2 * CanvasPanel.Y_CORNER + CanvasPanel.CANVAS_HEIGHT));
        frame.getContentPane().add(canvas); //put the canvas in the fram

        frame.pack();                       //make everything the preferred size
        frame.setVisible(true);   
        frame.setResizable(false);          //show the frame
        
    }
    
    
}
