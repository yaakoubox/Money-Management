
package controls;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JButton;
import javax.swing.JTextField;

/**
 *
 * @author YOUCEF
 */
public class JMyBoutton extends JButton{
    
    public  JMyBoutton(){
  
        setOpaque(false);
        setContentAreaFilled(false);
        setForeground(Color.white);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }
    @Override
    protected void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D)g;
        g.setColor(new Color(70,130,180));
        g.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
        super.paintComponent(g);
    }
    @Override
    protected void paintBorder(Graphics g){
       g.setColor(Color.blue);
       g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 20, 20);
    
    }
    

}

    
