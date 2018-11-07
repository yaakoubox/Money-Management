
package controls;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author YOUCEF
 */
public class JPasswordBox extends JPasswordField{
    
    public  JPasswordBox(int size){
    super(size);
        setOpaque(false);
    }
    @Override
    protected void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D)g;
        g.setColor(getBackground());
        g.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
        super.paintComponent(g);
    }
    @Override
    protected void paintBorder(Graphics g){
       g.setColor(Color.blue);
       g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 20, 20);
    
    }
    

}

    
