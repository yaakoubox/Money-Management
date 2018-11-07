package howmuchwehave;

/*
119-126-134-138-139-140-141-142-143-144-145-146-147-148-149
*/
import java.awt.AWTException;
import java.awt.BasicStroke;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.Buffer;
import java.text.MessageFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.paint.Color;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

  public class Tolls{
  
      
      
      //////////////////////////////////////////////////////////////////////////
      public static void MsgBox(Object message){
      JOptionPane.showMessageDialog(null, message);
        }
      
            
      
      
      //////////////////////////////////////////////////////////////////////////
      public static boolean confirmMsg(String message){
       int msgC = JOptionPane.showConfirmDialog(null, message);
       if (msgC==JOptionPane.YES_OPTION){
           return true; 
       }
       else{
           return false;
      }
      }
      
      
      //////////////////////////////////////////////////////////////////////////
      public static void CreatFolder(String NameFolder ,String path ){
      File f = new File(path + "/" + NameFolder);
      f.mkdir();
      }  
      
      
      
      //////////////////////////////////////////////////////////////////////////
      public static void OpenForm (JFrame form){
         try {
              form.setLocationRelativeTo(null);
             
              Image img = ImageIO.read(Tolls.class.getResource("1.png"));
              form.setIconImage(img);
              form.setDefaultCloseOperation(2);
              form.getContentPane().setBackground(java.awt.Color.white);
              form.setVisible(true);
          } catch (IOException ex) {
              Logger.getLogger(Tolls.class.getName()).log(Level.SEVERE, null, ex);
          }
     }
      
      
      
      //////////////////////////////////////////////////////////////////////////
      public static void OpenFormWithTitle (String title,JFrame form){
         try {
              form.setLocationRelativeTo(null);
              form.setTitle(title);
              form.setUndecorated(true);
              Image img = ImageIO.read(Tolls.class.getResource("1.png"));
              form.setIconImage(img);
              form.setDefaultCloseOperation(2);
              form.getContentPane().setBackground(java.awt.Color.white);
              form.setVisible(true);
          } catch (IOException ex) {
              Logger.getLogger(Tolls.class.getName()).log(Level.SEVERE, null, ex);
          }
     }
      
      
      
      //////////////////////////////////////////////////////////////////////////
      public static void ClearText(Container form){
      for (Component c : form.getComponents()){
      if (c instanceof JTextField)
      {JTextField txt = (JTextField)c;
      txt.setText("");
      }
      else if (c instanceof Container){ClearText((Container)c);}
      }
      }
      
      
      
      //////////////////////////////////////////////////////////////////////////
      public static void CreatEmptyNewFile(String NameFile){
      File f = new File(NameFile+".txt");
          try {
              f.createNewFile();
          } catch (IOException ex) {
              Logger.getLogger(Tolls.class.getName()).log(Level.SEVERE, null, ex);
          }
            }
      
      
      
      //////////////////////////////////////////////////////////////////////////
      public static void CreatMultiFile(String NameFiles[]){
          for(String NameFile :NameFiles){
       Tolls.CreatEmptyNewFile(NameFile);
          }
      }
      
      
      
      //////////////////////////////////////////////////////////////////////////
      public static void CreatdataFile(String NameFile,Object MyData[]){
          try {
              PrintWriter p = new PrintWriter(NameFile+".txt");
              for (Object obj : MyData){
                  p.println(obj);
              }
              p.close();
          } catch (FileNotFoundException ex) {
              Logger.getLogger(Tolls.class.getName()).log(Level.SEVERE, null, ex);
          }
      }
      
      
      
      //////////////////////////////////////////////////////////////////////////
      public static void CreatDataFiles(String NamesFile[],String Datas[][]){
          for(int x=0;x<NamesFile.length;x++){
            Tolls.CreatdataFile(NamesFile[x], Datas[x]);
              }
      }
     
      
      
      //////////////////////////////////////////////////////////////////////////
      public static Object InputBox (Object name){
      Object obj =JOptionPane.showInputDialog(name);
      return obj;
      }
      
      
      
      //////////////////////////////////////////////////////////////////////////
      public static String Getnumber(Object text){
          String val ="";    
          for (char c : text.toString().toCharArray()){
      if (c=='0' || c=='1' || c=='2' || c=='3' || c=='4' || c=='5' || c=='6' || c=='7' || c=='8' || c=='9')val+=c;
      }
          return val ; 
      }
      
      
      
      //////////////////////////////////////////////////////////////////////////
      public static int getNumbertoInteger(String text){
      String val="";
      for(char c : text.toCharArray()){
      if (c=='0' || c=='1' || c=='2' || c=='3' || c=='4' || c=='5' || c=='6' || c=='7' || c=='8' || c=='9')
          val+=c;
      }
      return Integer.parseInt(val);
      }
             
     
      
      //////////////////////////////////////////////////////////////////////////
      public static String RemoveNumber(Object text){
      String val = "";
      for(char c :text.toString().toCharArray()){
      if (!(c=='0' || c=='1' || c=='2' || c=='3' || c=='4' || c=='5' || c=='6' || c=='7' || c=='8' || c=='9'))val+=c;
      }
          return val;
      }
  
      
      
      //////////////////////////////////////////////////////////////////////////
      public static void PrintScreen(String ImageName,JFrame form){
          try {
              form.setState(1);
              Robot r = new Robot();
              Rectangle rec = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
              BufferedImage img = r.createScreenCapture(rec);
              ImageIO.write(img, "jpg",new File(ImageName+".jpg"));
              form.setState(0);
              
          } catch (Exception ex) {
              Logger.getLogger(Tolls.class.getName()).log(Level.SEVERE, null, ex);
          }
      }
  
      
      
      //////////////////////////////////////////////////////////////////////////
      public static class StringTolls {

          static String  str;
          private static String stri;
            
          public static void PrintCharByChar(String str) {

              for (char c : str.toCharArray()) {
                  System.out.println(c);
              }

          }

          public static void PrintCharByCharInverse(String str) {
              StringBuilder e = new StringBuilder(str);
              stri = e.reverse().toString();
              for (char c : stri.toCharArray()) {
                  System.out.println(c);
              }
          }
      }
      
      
      
      //////////////////////////////////////////////////////////////////////////
      public class Table{

    
public int coulumns;
public Object Names[][];


public Table(int coulumns){
this.coulumns=coulumns;    
Names = new Object [0][coulumns];
}
public void AddNewRow(Object row[]){
    Object TimeNames [][] = Names; 
    Names = new Object[Names.length+1][coulumns];
    for (int x=0; x<TimeNames.length;x++){
        Names[x]=TimeNames[x];
}    
Names[Names.length-1]=row;
    
    
}

public void PirntItems(){
for (Object obj[] : Names){
for (Object obje : obj)
{
System.out.print(obje+" / ");
}
System.out.println();

}
}
public void EditRow(int numberrow,int numbercoulum,Object newdata){
Names[numberrow][numbercoulum] = newdata;

}
public void DeleatRow(int RowIndex){
Object TimeName[][] = Names;
Names = new Object [Names.length-1][coulumns];    
for (int i=0, x=0;x<TimeName.length;i++,x++){
if (x==RowIndex){
     x+=1;
    Names[i]=TimeName[x];
}
else{
    Names[i]=TimeName[x];
 
}
    
}
    
}

public Object GetValue(int NumberRow, int NumberCoulom){
Object k =Names[NumberRow][NumberCoulom];
return k ;
}
public Object GetRow (int NumberRow){

return Names[NumberRow];

}







}
      ////////////////////////////////////////////////////////////////
      public class MergeArray {

Object[] numbers1;
Object[] numbers2;


public MergeArray(Object[] numbers1 , Object[] numbers2){
    this.numbers1=numbers1;
    this.numbers2=numbers2;
}
public Object[] MergeTowArray (){
    Object[] numbers3 = new Object [numbers1.length+numbers2.length];
    System.arraycopy(numbers1, 0, numbers3, 0, numbers1.length);
    System.arraycopy(numbers2, 0, numbers3, numbers1.length, numbers2.length);
    
return numbers3;
}
}
      /////////////////////////////////////////////////////////////
       public static class MyDraw {

    private static JFrame form;
    private static int wFrame;
    private static int hFrame;
    public MyDraw(JFrame form) {
        this.form = form;
        wFrame = form.getWidth();
        hFrame = form.getHeight();
    }
    public int Border = 1;
    public java.awt.Color color = java.awt.Color.BLACK;

    public void DrawLine(int x1, int y1, int width, int height) {
        JPanel pnl = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g;
                g2.setStroke(new BasicStroke(Border));
                g2.setColor(color);
                g2.drawLine(x1, y1, width, height);
            }
        };
        form.add(pnl);
        pnl.setBounds(0, 0, wFrame, hFrame);
    }

    public void DrawRect(int x, int y, int width, int height) {
        JPanel pnl = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g;
                g2.setColor(color);
                g2.setStroke(new BasicStroke(Border));
                g2.drawRect(x, y, width, height);
            }
        };
        form.add(pnl);
        pnl.setBounds(0, 0, wFrame, hFrame);

    }
   
    public void DrawOval(int x, int y, int width, int height) {
        JPanel pnl = new JPanel() {
            
            public void PaintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g;
                g2.setColor(color);
                g2.setStroke(new BasicStroke(Border));
                g2.drawOval(x, y, width, height);

            }
        };
    form.add(pnl);
    pnl.setBounds(0, 0, wFrame, hFrame);
    }
    
    public void DrawPolygone(int xPoints[],int yPoints[],int nPoints) {
        JPanel pnl = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g;
                g2.setColor(color);
                g2.setStroke(new BasicStroke(Border));
                g2.drawPolygon(xPoints, yPoints, nPoints);
            }
        };
        form.add(pnl);
        pnl.setBounds(0, 0, wFrame, hFrame);
    }
    
    public void DrawString(int x , int y ,String Text ,String FontName ,int FontSize){
    JPanel pnl = new JPanel(){
    @Override
    public void paintComponent(Graphics g){
    Graphics2D g2 = (Graphics2D)g;
    g2.setColor(color);
    g2.setFont(new Font(FontName, Font.BOLD, FontSize));
    //Font font = new Font(FontName, Font.BOLD, FontSize);
    //g2.setFont(font);
    g2.drawString(Text, x, y);
    
    }
    };
    form.add(pnl);
    pnl.setBounds(0,0,wFrame,hFrame);
    
    }
    
    public static void DrawImage(int x,int y ,String path){
    JPanel pnl = new JPanel(){
    @Override
    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D)g;
        File FileImage = new File(path);
        try {
            Image img = ImageIO.read(FileImage);
            g2.drawImage(img, x, y, form);
        } catch (IOException ex) {
            Logger.getLogger(MyDraw.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    };
    form.add(pnl);
    pnl.setBounds(0, 0, wFrame, hFrame);
    }
    
    public void DrawRoundRect(int x, int y , int width , int height , int BorderRadius ,int BorderRadius1){
    JPanel pnl = new JPanel(){
    @Override
    public void paintComponent(Graphics g){
    Graphics2D g2 = (Graphics2D)g;
    g2.setColor(color);
    g2.setStroke(new BasicStroke(Border));
    g2.drawRoundRect(x, y, width, height, BorderRadius, BorderRadius1);
    }
    
    };
    form.add(pnl);
    pnl.setBounds(0,0,wFrame,hFrame);
    }
}
       
  public static void setReport(JTable table){
       table.getTableHeader().setBackground(new java.awt.Color(0,0,100));
       table.getTableHeader().setForeground(java.awt.Color.white);
  
  }
  public static void printReport(JTable table , String Title){
    try{
        MessageFormat headear = new MessageFormat(Title+" Report");
        MessageFormat footer = new MessageFormat("Page - {0}");
        table.print(JTable.PrintMode.FIT_WIDTH,headear,footer);
        }catch(Exception ex){
        Tolls.MsgBox(ex.getMessage());
        }
  }
  
  }
      
  
 
  